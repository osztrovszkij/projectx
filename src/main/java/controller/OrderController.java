package controller;

import entity.Service;
import service.ServiceService;
import service.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by roski on 20.5.16.
 */
@WebServlet(name = "OrderController", urlPatterns = "/dashboard/order")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
            request.getRequestDispatcher("order.jsp").forward(request, response);
        }
    }
}
