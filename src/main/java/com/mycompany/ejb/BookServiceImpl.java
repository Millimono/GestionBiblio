package com.mycompany.ejb;

import com.mycompany.jpa.Book;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BookServiceImpl implements BookService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addBook(Book book) {
        em.persist(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    @Override
    public Book findBookById(Long id) {
        return em.find(Book.class, id);
    }

    @Override
    public void updateBook(Book book) {
        em.merge(book);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = em.find(Book.class, id);
        if (book != null) {
            em.remove(book);
        }
    }
    
    @Override
    public List<Book> searchBooks(String search) {
        return em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :search OR b.author LIKE :search", Book.class)
                .setParameter("search", "%" + search + "%")
                .getResultList();
    }
    
}
