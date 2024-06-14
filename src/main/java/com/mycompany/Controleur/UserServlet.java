package com.mycompany.Controleur;

import com.mycompany.ejb.RoleService;
import com.mycompany.ejb.UserService;
import com.mycompany.jpa.Role;
import com.mycompany.jpa.User;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/admin/users")
public class UserServlet extends HttpServlet {

    @EJB
    private UserService userService;

    @EJB
    private RoleService roleService;

    private static final Logger LOGGER = Logger.getLogger(UserServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = userService.getAllUsers();
        LOGGER.log(Level.INFO, "Number of users retrieved: " + users.size());
        request.setAttribute("users", users);
        request.getRequestDispatcher("/admin/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("_method");
        if (method != null && method.equalsIgnoreCase("DELETE")) {
            doDelete(request, response);
            return;
        } else if (method != null && method.equalsIgnoreCase("PUT")) {
            doPut(request, response);
            return;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String roleName = request.getParameter("role");
        String email = request.getParameter("email");

        Role role = roleService.findByName(roleName);
        if (role == null) {
            role = new Role();
            role.setName(roleName);
            roleService.createRole(role);
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setEmail(email);

        userService.register(user);
        LOGGER.log(Level.INFO, "User added: " + user.getUsername());

        response.sendRedirect("users");  // Redirect to doGet to display updated list
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String roleName = request.getParameter("role");
        String email = request.getParameter("email");

        User user = userService.findUserById(id);
        if (user != null) {
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);

            Role role = roleService.findByName(roleName);
            if (role == null) {
                role = new Role();
                role.setName(roleName);
                roleService.createRole(role);
            }
            user.setRole(role);

            userService.updateUser(user);
            LOGGER.log(Level.INFO, "User updated: " + user.getUsername());
        }

        response.sendRedirect("users");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        userService.deleteUser(id);
        LOGGER.log(Level.INFO, "User deleted: " + id);

        response.sendRedirect("users");
    }
}
