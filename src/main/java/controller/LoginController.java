package controller;

import entity.User;
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
import java.util.Map;

/**
 * Created by roski on 4/22/16.
 */
@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view;

        String username = request.getParameter("login");
        String password = request.getParameter("password");

        Map<String, String> messages = new HashMap<>();

        if (username == null || username.isEmpty()) {
            messages.put("login", "Please enter login");
        }
        if (password == null || password.isEmpty()) {
            messages.put("password", "Please enter password");
        }

        if (messages.isEmpty()) {
            User user = null;
            try {
                user = UserService.findByLogin(username);
            } catch (ServiceException e) {
                request.setAttribute("error", e.getMessage());
                view = request.getRequestDispatcher("/error.jsp");
                view.forward(request, response);
            }

            if (user != null && (user.getPassword().equals(password))) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/dashboard");
                return;
            } else {
                messages.put("login", "Unknown username or password, please try again");
            }
        }

        request.setAttribute("messages", messages);
        view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
