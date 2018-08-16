package ru.otus.dz8.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @ManyToOne(cascade = CascadeType.PERSIST)
    @ManyToOne
//    @JoinColumn(name = "author_id", nullable = false)
    @JoinColumn(name = "author_id")
    private Author author;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @ManyToOne(cascade = CascadeType.PERSIST)
    @ManyToOne
    @JoinColumn(name = "genre_id")
//    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Comment> comments;

    public Book() {
    }

    public Book(String name, Author author, Genre genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
