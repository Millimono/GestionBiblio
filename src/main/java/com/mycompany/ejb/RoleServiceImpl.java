/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejb;

import com.mycompany.jpa.Role;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author Lenovo
 */

@Stateless
public class RoleServiceImpl implements RoleService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Role findByName(String name) {
        try {
            return em.createQuery("SELECT r FROM Role r WHERE r.name = :name", Role.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void createRole(Role role) {
        em.persist(role);
    }

    @Override
    public List<Role> findAllRoles() {
        return em.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }
}
