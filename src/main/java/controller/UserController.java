package controller;

import entity.Service;
import entity.User;
import service.ServiceService;
import service.UserService;
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
@WebServlet(name = "UserController", urlPatterns = "/dashboard/users")
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view;
        Map<String, String> messages = new HashMap<>();
        User user;

        switch (request.getParameter("request")) {
            case "add_user":
                user = new User();
                user.setLogin(request.getParameter("login"));
                user.setPassword(request.getParameter("password"));
                user.setRole(request.getParameter("role"));

                try {
                    if (UserService.addUser(user)) {
                        messages.put("add_user", "successful");
                    } else {
                        messages.put("add_user", "failed");
                    }
                } catch(ServiceException e) {
                    request.setAttribute("error", e.getMessage());
                    view = request.getRequestDispatcher("/error.jsp");
                    view.forward(request, response);
                }
                break;

            case "update_user":
                user = new User();
                user.setLogin(request.getParameter("login"));
                user.setPassword(request.getParameter("password"));
                user.setRole(request.getParameter("role"));

                try {
                    if (UserService.updateUser(user)) {
                        messages.put("update_user", "successful");
                    } else {
                        messages.put("update_user", "failed");
                    }

                } catch(ServiceException e) {
                    request.setAttribute("error", e.getMessage());
                    view = request.getRequestDispatcher("/error.jsp");
                    view.forward(request, response);
                }
                break;

            case "delete_user":
                String login = request.getParameter("login");

                try {
                    if (UserService.deleteUserByLogin(login)) {
                        messages.put("delete_user", "successful");
                    } else {
                        messages.put("delete_user", "failed");
                    }

                } catch(ServiceException e) {
                    request.setAttribute("error", e.getMessage());
                    view = request.getRequestDispatcher("/error.jsp");
                    view.forward(request, response);
                }
                break;
        }

        request.getSession().setAttribute("messages", messages);
        response.sendRedirect("users");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view;
        List<User> users = null;

        try {
            users = UserService.findAll();
        } catch (ServiceException e) {
            request.setAttribute("error", e.getMessage());
            view = request.getRequestDispatcher("/error.jsp");
            view.forward(request, response);
        }

        if (users != null) {
            request.getSession().setAttribute("users", users);
            request.getRequestDispatcher("users.jsp").forward(request, response);
        }
    }
}
