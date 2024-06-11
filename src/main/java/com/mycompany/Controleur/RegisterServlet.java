/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controleur;

import com.mycompany.ejb.RoleService;
import com.mycompany.ejb.UserService;
import com.mycompany.jpa.Role;
import com.mycompany.jpa.User;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Lenovo
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @EJB
    private UserService userService;

    @EJB
    private RoleService roleService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String roleName = request.getParameter("role");

        Role role = roleService.findByName(roleName);
        if (role == null) {
            role = new Role();
            role.setName(roleName);
            roleService.createRole(role);
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);

        userService.register(newUser);

        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}



