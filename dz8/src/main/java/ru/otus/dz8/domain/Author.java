package ru.otus.dz8.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue
    private int id;
    private String name;

//    @OneToOne(orphanRemoval = true)
    @OneToMany
    private Set<Book> books = new HashSet<>();

//    public Author(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }


    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
