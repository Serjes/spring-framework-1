package ru.otus.dz8.domain;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private int id;
    private String name;

//    @OneToOne(cascade = CascadeType.ALL)
    @OneToOne
    private Author author;
//    private int idAuthor;

//    @OneToOne(cascade = CascadeType.ALL)
    @OneToOne
    private Genre genre;
//    private int idGenre;
//    private String authorName;
//    private String genreName;

    public Book(String name, Author author, Genre genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;
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
