package Entities;

import jakarta.persistence.*;

@Entity
@Table(name="PRINTEDBOOK")
public class PrintedBook extends Book {
    @Column(name="weight")
    private int weight;

    @Column(name="pageCount")
    private int pageCount;

    public PrintedBook() {
        super();
    }

    public PrintedBook(String title, Author author, int weight, int pageCount) {
        super(title, author);
        this.weight = weight;
        this.pageCount = pageCount;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
