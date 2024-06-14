/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controleur.User;


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

@WebServlet("/user/searchBooks")
public class SearchBooksServlet extends HttpServlet {

    @EJB
    private BookService bookService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Book> books = bookService.searchBooks(search);
        request.setAttribute("books", books);
        request.getRequestDispatcher("/user/searchBooks.jsp").forward(request, response);
    }
}

