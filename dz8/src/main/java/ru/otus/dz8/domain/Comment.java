package ru.otus.dz8.domain;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Comment() {
    }

    public Comment(String content, Book book) {
        this.content = content;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Book getBook() {
        return book;
    }
}
