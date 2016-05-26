package controller;

import entity.Order;
import entity.User;
import service.OrderService;
import service.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by roski on 20.5.16.
 */
@WebServlet(name = "ProfileController", urlPatterns = "/dashboard/profile")
public class ProfileController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view;
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        List<Order> orders = null;

        try {
            orders = OrderService.findByLogin(user.getLogin());
        } catch (ServiceException e) {
            request.setAttribute("error", e.getMessage());
            view = request.getRequestDispatcher("/error.jsp");
            view.forward(request, response);
        }
        request.getSession().setAttribute("orders", orders);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
}
