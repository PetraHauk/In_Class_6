package Dao;

import Entities.*;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class LibraryDao {

    protected EntityManager em;

    public LibraryDao(EntityManager em) {
        this.em = em;
    }

    private void performTransaction(Runnable action) {
        try {
            em.getTransaction().begin();
            action.run();
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void addAuthor(Author author) {
        performTransaction(() -> em.persist(author));
    }

    public void removeAuthor(Author author) {
        performTransaction(() -> em.remove(author));
    }

    public void updateAuthor(Author author) {
        performTransaction(() -> em.merge(author));
    }

    public void addBook(Book book) {
        performTransaction(() -> em.persist(book));
    }

    public void removeBook(Book book) {
        performTransaction(() -> em.remove(book));
    }

    public void updateBook(Book book) {
        performTransaction(() -> em.merge(book));
    }

    public void addStudent(Student student) {
        performTransaction(() -> em.persist(student));
    }

    public void removeStudent(Student student) {
        performTransaction(() -> em.remove(student));
    }

    public void updateStudent(Student student) {
        performTransaction(() -> em.merge(student));
    }

    public void addBiography(Biography biography) {
        performTransaction(() -> em.persist(biography));
    }

    public void removeBiography(Biography biography) {
        performTransaction(() -> em.remove(biography));
    }

    public void updateBiography(Biography biography) {
        performTransaction(() -> em.merge(biography));
    }

    public List<Book> getBooks() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public Book getBookById(int id) {
        return em.find(Book.class, id);
    }

    public List<Book> getBooksByTitle(String title) {
        return em.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class)
                .setParameter("title", title)
                .getResultList();
    }

    public List<Book> getBooksByAuthor(Author author) {
        return em.createQuery("SELECT b FROM Book b WHERE b.author = :author", Book.class)
                .setParameter("author", author)
                .getResultList();
    }

    public List<BorrowedBook> getBorrowedBooks() {
        return em.createQuery("SELECT b FROM BorrowedBook b", BorrowedBook.class).getResultList();
    }

    public void borrowBook(Student student, Book book) {
        performTransaction(() -> {
            BorrowedBook borrowedBook = new BorrowedBook(student, book, LocalDate.now());

            em.persist(borrowedBook);

            student.addBorrowedBook(borrowedBook);
            book.addBorrowedBook(borrowedBook);
        });
    }
}
