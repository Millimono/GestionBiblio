/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ejb;

import com.mycompany.jpa.Role;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Lenovo
 */
@Local
public interface RoleService {
    Role findByName(String name);
    
    void createRole(Role role);
    
    List<Role> findAllRoles();
}
