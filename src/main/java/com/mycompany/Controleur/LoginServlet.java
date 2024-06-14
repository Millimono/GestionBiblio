package com.mycompany.Controleur;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.jpa.User;
import com.mycompany.ejb.UserService;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author Lenovo
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @EJB
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.authenticate(username, password);

        if (user != null) {
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("username", username);

            if ("admin".equals(user.getRole().getName())) {
                response.sendRedirect(request.getContextPath() + "/admin/home.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/user/home.jsp");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=true");
        }
    }
}

