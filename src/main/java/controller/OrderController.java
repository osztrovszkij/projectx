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
        Map<String, String> messages = null;

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        switch (user.getRole()) {
            case "admin":
                switch (request.getParameter("request")) {
                    case "add_order":
                        messages = addOrder(request, response);
                        break;
                    case "update_order":
                        messages = updateOrder(request, response);
                        break;
                    case "delete_order":
                        messages = deleteOrder(request, response);
                        break;
                }
                break;
            case "user":
                switch (request.getParameter("request")) {
                    case "add_order":
                        messages = addOrder(request, response);
                        break;
                }
                break;
        }

        request.getSession().setAttribute("messages", messages);
        response.sendRedirect("order");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        RequestDispatcher view;
        List<Service> services = null;

        try {
            services = ServiceService.findAll();
        } catch (ServiceException e) {
            request.setAttribute("error", e.getMessage());
            view = request.getRequestDispatcher("/error.jsp");
            view.forward(request, response);
        }

        request.getSession().setAttribute("services", services);

        switch (user.getRole()) {
            case "admin":
                List<Order> orders = null;
                try {
                    orders = OrderService.findAll();
                } catch (ServiceException e) {
                    request.setAttribute("error", e.getMessage());
                    view = request.getRequestDispatcher("/error.jsp");
                    view.forward(request, response);
                }
                request.getSession().setAttribute("orders", orders);

                request.getRequestDispatcher("admin_order.jsp").forward(request, response);
                break;
            case "user":
                request.getRequestDispatcher("user_order.jsp").forward(request, response);
                break;
        }

    }

    private Map<String, String> addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view;
        Order order;
        Map<String, String> messages = new HashMap<>();

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
        return messages;
    }

    private Map<String, String> updateOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view;
        Map<String, String> messages = new HashMap<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        java.util.Date parsedOrderDate = null;
        java.util.Date parsedEventDate = null;

        try {
            parsedOrderDate = format.parse(request.getParameter("order_date"));
            parsedEventDate = format.parse(request.getParameter("event_date"));
        } catch (ParseException e) {
            request.setAttribute("error", e.getMessage());
            view = request.getRequestDispatcher("/error.jsp");
            view.forward(request, response);
        }

        Date orderDate = new Date(parsedOrderDate.getTime());
        Date eventDate = new Date(parsedEventDate.getTime());

        Order order = new Order();
        order.setOrderDate(orderDate);
        order.setEventDate(eventDate);
        order.setId(request.getParameter("id"));
        order.setService(request.getParameter("service_name"));
        order.setUser(request.getParameter("login"));

        try {
            if (OrderService.updateOrder(order)) {
                messages.put("update_order", "successful");
            } else {
                messages.put("update_order", "failed");
            }

        } catch(ServiceException e) {
            request.setAttribute("error", e.getMessage());
            view = request.getRequestDispatcher("/error.jsp");
            view.forward(request, response);
        }

        return messages;
    }

    private Map<String, String> deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view;
        Map<String, String> messages = new HashMap<>();

        String id = request.getParameter("id");

        try {
            if (OrderService.deleteOrderById(id)) {
                messages.put("delete_order", "successful");
            } else {
                messages.put("delete_order", "failed");
            }

        } catch(ServiceException e) {
            request.setAttribute("error", e.getMessage());
            view = request.getRequestDispatcher("/error.jsp");
            view.forward(request, response);
        }

        return messages;
    }
}
