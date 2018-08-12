package ru.otus.dz8.domain;

import javax.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue
    private int id;
    private String name;

//    @OneToOne(orphanRemoval = true)
//    private Book book;

//    public Genre(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
