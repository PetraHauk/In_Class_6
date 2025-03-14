package Entities;

import jakarta.persistence.*;

@Entity
@Table(name="BIOGRAPHY")
public class Biography {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name="authorId")
    private Author author;

    @Column(name="bio")
    private String bio;

    public Biography() {
        super();
    }

    public Biography(Author author, String bio) {
        super();
        this.author = author;
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
