package com.mycompany.Controleur.User;

import com.mycompany.ejb.LoanService;
import com.mycompany.jpa.Loan;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/myLoans")
public class UserLoansServlet extends HttpServlet {

    @EJB
    private LoanService loanService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username"); // Assume user is authenticated
        List<Loan> loans = loanService.getLoansByUsername(username);
        request.setAttribute("loans", loans);
        request.getRequestDispatcher("/user/myLoans.jsp").forward(request, response);
    }
}
