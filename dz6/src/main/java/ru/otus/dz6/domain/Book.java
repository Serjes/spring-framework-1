package ru.otus.dz6.domain;

public class Book {
    private final int id;
    private final String name;
    private final int idAuthor;
    private final int idGenre;

    public Book(int id, String name, int idAuthor, int idGenre) {
        this.id = id;
        this.name = name;
        this.idAuthor = idAuthor;
        this.idGenre = idGenre;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public int getIdGenre() {
        return idGenre;
    }
}
