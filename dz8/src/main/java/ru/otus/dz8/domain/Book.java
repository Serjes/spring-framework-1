package ru.otus.dz8.domain;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @ManyToOne
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "author_id", nullable = false)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

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
