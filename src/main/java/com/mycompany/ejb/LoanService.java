package com.mycompany.ejb;

import com.mycompany.jpa.Loan;
import com.mycompany.jpa.User;
import java.util.List;
import jakarta.ejb.Local;

@Local
public interface LoanService {
    void borrowBook(Loan loan);
    User findUserByUsername(String username);
    List<Loan> getLoansByUsername(String username);
}
