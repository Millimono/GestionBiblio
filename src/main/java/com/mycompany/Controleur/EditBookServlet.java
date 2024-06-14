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

@WebServlet("/admin/books/edit")
public class EditBookServlet extends HttpServlet {

    @EJB
    private BookService bookService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        Book book = bookService.findBookById(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/admin/editBook.jsp").forward(request, response);
    }
}
