/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ejb;

import com.mycompany.jpa.User;
import jakarta.ejb.Local;

/**
 *
 * @author Lenovo
 */
@Local
public interface UserService {
    User authenticate(String username, String password);
}
