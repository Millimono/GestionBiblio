/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package com.mycompany.ejb;

import com.mycompany.jpa.User;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
@Stateless
public class UserServiceImpl implements UserService {

    private static final Map<String, User> users = new HashMap<>();

    static {
        users.put("admin", new User("admin", "admin123", "admin"));
        users.put("user", new User("user", "user123", "user"));
    }

    @Override
    public User authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}

