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
        boolean isAdminURI = false;

        HashMap<String, String> URIs = new HashMap();
        URIs.put("user", "/");
        URIs.put("user", "/login");
        URIs.put("user", "/dashboard");
        URIs.put("user", "/dashboard/order");
        URIs.put("user", "/dashboard/profile");
        URIs.put("admin", "/dashboard/users");
        URIs.put("admin", "/dashboard/orders");
        URIs.put("admin", "/dashboard/services");

        if (loggedIn) {
            User user = (User) session.getAttribute("user");
            String role = user.getRole();

            for (Map.Entry uri : URIs.entrySet()) {
                if (request.getServletPath().equals(uri.getValue())) {
                    if (uri.getKey().equals("admin") && !role.equals("admin")) {
                        isValidURI = false;
                    } else {
                        isValidURI = true;
                    }
                }
            }

            if (isValidURI) {
                chain.doFilter(request, response);
            } else {
                request.setAttribute("error", "It's invalid page");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

//            for (Map.Entry uri : URIs.entrySet()) {
//                //String s = request.getServletPath();
//                if (request.getServletPath().equals(uri))
//                    isValidUrl = true;
//            }
//
//            if (!isValidUrl) {
//                request.setAttribute("error", "It's invalid page");
//                request.getRequestDispatcher("error.jsp").forward(request, response);
//            } else {
//                chain.doFilter(request, response);
//            }
        } else if (loginRequest) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
