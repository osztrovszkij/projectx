package controller.filter;

import entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by roski on 4/28/16.
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/login";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean isValidURI = false;

        HashMap<String, String> URIs = new HashMap();
        URIs.put("/", "user");
        URIs.put("/login", "user");
        URIs.put("/login", "user");
        URIs.put("/logout", "user");
        URIs.put("/dashboard", "user");
        URIs.put("/dashboard/order", "user");
        URIs.put("/dashboard/profile", "user");
        URIs.put("/dashboard/users", "admin");
        URIs.put("/dashboard/services", "admin");

        if (loggedIn) {
            User user = (User) session.getAttribute("user");
            String role = user.getRole();

            for (Map.Entry uri : URIs.entrySet()) {
                if (request.getServletPath().equals(uri.getKey())) {
                    if (uri.getValue().equals("admin") && !role.equals("admin")) {
                        isValidURI = false;
                    } else {
                        isValidURI = true;
                    }
                }
            }

            if (!isValidURI) {
                request.setAttribute("error", "It's invalid page");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            } else if (request.getServletPath().equals("/login")) {
                response.sendRedirect("/projectx/dashboard");
            } else {
                chain.doFilter(request, response);
            }
        } else if (loginRequest) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
