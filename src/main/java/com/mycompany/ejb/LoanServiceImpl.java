package com.mycompany.ejb;

import com.mycompany.jpa.Loan;
import com.mycompany.jpa.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class LoanServiceImpl implements LoanService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void borrowBook(Loan loan) {
        em.persist(loan);
    }

    @Override
    public User findUserByUsername(String username) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    @Override
    public List<Loan> getLoansByUsername(String username) {
        TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l WHERE l.user.username = :username", Loan.class);
        query.setParameter("username", username);
        return query.getResultList();
    }
}
