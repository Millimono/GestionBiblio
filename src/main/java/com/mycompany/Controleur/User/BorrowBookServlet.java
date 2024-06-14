package com.mycompany.Controleur.User;

import com.mycompany.ejb.BookService;
import com.mycompany.ejb.LoanService;
import com.mycompany.ejb.UserService;
import com.mycompany.jpa.Book;
import com.mycompany.jpa.Loan;
import com.mycompany.jpa.User;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/user/borrowBook")
public class BorrowBookServlet extends HttpServlet {

    @EJB
    private LoanService loanService;

    @EJB
    private BookService bookService;

    @EJB
    private UserService userService;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        String username = request.getParameter("username");

        if (username == null || username.isEmpty()) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not authenticated");
            return;
        }

        Book book = bookService.findBookById(Long.parseLong(bookId));
        User user = userService.findByUsername(username);

        if (book != null && user != null) {
            Loan loan = new Loan();
            loan.setBook(book);
            loan.setUser(user);
            loan.setLoanDate(new Date());

            loanService.borrowBook(loan);

            // Envoyer une notification JMS
           // String messageContent = "Le livre " + book.getTitle() + " a été emprunté par " + user.getUsername();
            //notificationService.sendNotification(messageContent);

            // Envoyer un email de notification
            
            //String emailSubject = "Emprunt de livre confirmé";
            //String emailBody = "Cher " + user.getUsername() + ",\n\nVous avez emprunté le livre \"" + book.getTitle() + "\".";
            //notificationService.sendEmail(user.getEmail(), emailSubject, emailBody);
        }

        response.sendRedirect(request.getContextPath() + "/user/myLoans");
    }
}
