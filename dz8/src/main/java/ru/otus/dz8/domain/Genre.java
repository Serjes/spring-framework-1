package ru.otus.dz8.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
//    @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy="genre", fetch=FetchType.LAZY, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

//    @OneToOne(orphanRemoval = true)
//    private Book book;

//    public Genre(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }


    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
