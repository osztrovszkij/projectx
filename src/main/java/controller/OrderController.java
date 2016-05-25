package controller;

import entity.Order;
import entity.Service;
import entity.User;
import service.OrderService;
import service.ServiceService;
import service.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by roski on 20.5.16.
 */
@WebServlet(name = "OrderController", urlPatterns = "/dashboard/order")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view;
        Map<String, String> messages = new HashMap<>();
        Order order;

        switch (request.getParameter("request")) {
            case "add_order":
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                java.util.Date parsed = null;

                try {
                    parsed = format.parse(request.getParameter("date"));
                } catch (ParseException e) {
                    request.setAttribute("error", e.getMessage());
                    view = request.getRequestDispatcher("/error.jsp");
                    view.forward(request, response);
                }

                Date date = new Date(parsed.getTime());

                order = new Order();
                order.setEventDate(date);
                order.setService(request.getParameter("name"));

                HttpSession session = request.getSession(false);
                User user = (User) session.getAttribute("user");
                order.setUser(user.getLogin());

                try {
                    if (OrderService.addOrder(order)) {
                        messages.put("add_order", "successful");
                    } else {
                        messages.put("add_order", "failed");
                    }
                } catch (ServiceException e) {
                    request.setAttribute("error", e.getMessage());
                    view = request.getRequestDispatcher("/error.jsp");
                    view.forward(request, response);
                }
                break;
        }
        request.getSession().setAttribute("messages", messages);
        response.sendRedirect("order");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view;
        List<Service> services = null;

        try {
            services = ServiceService.findAll();
        } catch (ServiceException e) {
            request.setAttribute("error", e.getMessage());
            view = request.getRequestDispatcher("/error.jsp");
            view.forward(request, response);
        }

        if (services != null) {
            request.getSession().setAttribute("services", services);
            request.getRequestDispatcher("user_order.jsp").forward(request, response);
        }
    }
}
