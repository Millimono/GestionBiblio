/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejb;

import com.mycompany.jpa.Book;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface BookService {
    void addBook(Book book);
    List<Book> getAllBooks();
    Book findBookById(Long id);
    void updateBook(Book book);
    void deleteBook(Long id);
    public List<Book> searchBooks(String search);
}

