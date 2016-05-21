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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by roski on 20.5.16.
 */
@WebServlet(name = "ServiceController", urlPatterns = "/dashboard/services")
public class ServiceController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view;
        Map<String, String> messages = new HashMap<>();
        Service service;

        switch (request.getParameter("request")) {
            case "add_service":
                service = new Service();
                service.setName(request.getParameter("name"));
                service.setDescription(request.getParameter("description"));

                try {
                    if (ServiceService.addService(service)) {
                        messages.put("add_service", "successful");
                    } else {
                        messages.put("add_service", "failed");
                    }
                } catch(ServiceException e) {
                    request.setAttribute("error", e.getMessage());
                    view = request.getRequestDispatcher("/error.jsp");
                    view.forward(request, response);
                }
                break;

            case "update_service":
                service = new Service();
                service.setName(request.getParameter("name"));
                service.setDescription(request.getParameter("description"));

                try {
                    if (ServiceService.updateService(service)) {
                        messages.put("update_service", "successful");
                    } else {
                        messages.put("update_service", "failed");
                    }

                } catch(ServiceException e) {
                    request.setAttribute("error", e.getMessage());
                    view = request.getRequestDispatcher("/error.jsp");
                    view.forward(request, response);
                }
                break;

            case "delete_service":
                String name = request.getParameter("name");

                try {
                    if (ServiceService.deleteServiceByName(name)) {
                        messages.put("delete_service", "successful");
                    } else {
                        messages.put("delete_service", "failed");
                    }

                } catch(ServiceException e) {
                    request.setAttribute("error", e.getMessage());
                    view = request.getRequestDispatcher("/error.jsp");
                    view.forward(request, response);
                }
                break;
        }

        request.getSession().setAttribute("messages", messages);
        response.sendRedirect("services");
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
            request.getRequestDispatcher("services.jsp").forward(request, response);
        }
    }
}
