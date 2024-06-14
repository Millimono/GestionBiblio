package com.mycompany.Controleur;

import com.mycompany.ejb.BookService;
import com.mycompany.jpa.Book;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/admin/books")
public class BooksServlet extends HttpServlet {

    @EJB
    private BookService bookService;

    private static final Logger LOGGER = Logger.getLogger(BooksServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> books = bookService.getAllBooks();
        LOGGER.log(Level.INFO, "Number of books retrieved: " + books.size());
        request.setAttribute("books", books);
        request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("_method");
        if (method != null && method.equalsIgnoreCase("DELETE")) {
            doDelete(request, response);
            return;
        } else if (method != null && method.equalsIgnoreCase("PUT")) {
            doPut(request, response);
            return;
        }

        String title = request.getParameter("title");
        String author = request.getParameter("author");

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);

        bookService.addBook(book);
        LOGGER.log(Level.INFO, "Book added: " + book.getTitle());

        response.sendRedirect("books");  // Redirect to doGet to display updated list
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");

        Book book = bookService.findBookById(id);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            bookService.updateBook(book);
            LOGGER.log(Level.INFO, "Book updated: " + book.getTitle());
        }

        response.sendRedirect("books");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        bookService.deleteBook(id);
        LOGGER.log(Level.INFO, "Book deleted: " + id);

        response.sendRedirect("books");
    }
}
