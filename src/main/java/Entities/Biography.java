package Entities;

import jakarta.persistence.*;

@Entity
@Table(name="BIOGRAPHY")
public class Biography {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name="author_id")
    private Author author;

    @Column(name="bio")
    private String bio;
}
