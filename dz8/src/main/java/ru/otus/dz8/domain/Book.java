package ru.otus.dz8.domain;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
//    @GeneratedValue
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_ID")
//    @OneToOne
    private Author author;
//    private int idAuthor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GENRE_ID")
//    @OneToOne
    private Genre genre;
//    private int idGenre;
//    private String authorName;
//    private String genreName;


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

    //    public Book(int id, String name, int idAuthor, int idGenre) {
//        this.id = id;
//        this.name = name;
//        this.idAuthor = idAuthor;
//        this.idGenre = idGenre;
//    }
//
//    public Book(int id, String name, String authorName, String genreName) {
//        this.id = id;
//        this.name = name;
//        this.authorName = authorName;
//        this.genreName = genreName;
//    }

//    public String getAuthorName() {
//        return authorName;
//    }
//
//    public String getGenreName() {
//        return genreName;
//    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

//    public int getIdAuthor() {
//        return idAuthor;
//    }
//
//    public int getIdGenre() {
//        return idGenre;
//    }

    //    public int getIdAuthor() {
//        return idAuthor;
//    }
//
//    public int getIdGenre() {
//        return idGenre;
//    }
}
