package Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "BORROWEDBOOK")
public class BorrowedBook {

    @EmbeddedId
    private BorrowedBookId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "bookId")
    private Book book;

    @Column(name = "borrowDate")
    private LocalDate borrowDate;

    public BorrowedBook() {
        super();
    }

    public BorrowedBook(Student student, Book book, LocalDate borrowDate) {
        this.id = new BorrowedBookId(book.getId(), student.getId());
        this.student = student;
        this.book = book;
        this.borrowDate = borrowDate;
    }

    public BorrowedBookId getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
