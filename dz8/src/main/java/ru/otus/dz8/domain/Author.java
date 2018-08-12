package ru.otus.dz8.domain;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue
    private int id;
    private String name;

//    @OneToOne(orphanRemoval = true)
//    private Book book;

//    public Author(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
