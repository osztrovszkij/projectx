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
import java.util.List;

/**
 * Created by roski on 20.5.16.
 */
@WebServlet(name = "UserController", urlPatterns = "/dashboard/users")
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
