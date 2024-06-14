/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ejb;

import com.mycompany.jpa.User;
import jakarta.ejb.Local;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author Lenovo
 */
@Local
public interface UserService {
    User authenticate(String username, String password);
    void register(User user);
    
    public User findUserById(Long id);

    public void updateUser(User user) ;

    public void deleteUser(Long id);
    
    public List<User> getAllUsers() ;
    User findByUsername(String username);

}
