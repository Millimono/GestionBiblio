package com.mycompany.Controleur;

import com.mycompany.ejb.BookService;
import com.mycompany.jpa.Book;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/admin/home")
public class AdminHomeServlet extends HttpServlet {

    @EJB
    private BookService bookService;

    private static final Logger LOGGER = Logger.getLogger(AdminHomeServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> books = bookService.getAllBooks();
        LOGGER.log(Level.INFO, "Number of books retrieved: " + books.size());
        request.setAttribute("books", books);
        request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
    }
}
