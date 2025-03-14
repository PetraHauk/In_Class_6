package Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BorrowedBookId implements Serializable {
    @Column(name="book_id")
    private int bookId;

    @Column(name="student_id")
    private int studentId;

    public BorrowedBookId() {
        super();
    }

    public BorrowedBookId(int bookId, int studentId) {
        super();
        this.bookId = bookId;
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, studentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BorrowedBookId that = (BorrowedBookId) obj;
        return bookId == that.bookId && studentId == that.studentId;
    }

}
