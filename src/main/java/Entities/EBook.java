package Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "EBOOK")
public class EBook extends Book {

    @Column(name="fileSizeMB")
    private double fileSizeMB;

    @Column(name="fileFormat")
    private String fileFormat;

    public EBook() { super(); }

    public EBook(String title, Author author, double fileSizeMB, String fileFormat) {
        super(title, author);
        this.fileSizeMB = fileSizeMB;
        this.fileFormat = fileFormat;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    public void setFileSizeMB(int fileSizeMB) {
        this.fileSizeMB = fileSizeMB;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }
}
