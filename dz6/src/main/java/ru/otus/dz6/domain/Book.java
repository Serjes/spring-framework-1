package ru.otus.dz6.domain;

public class Book {
    private final int id;
    private final String name;
//    private final int idAuthor;
//    private final int idGenre;
    private String authorName;
    private String genreName;

//    public Book(int id, String name, int idAuthor, int idGenre) {
//        this.id = id;
//        this.name = name;
//        this.idAuthor = idAuthor;
//        this.idGenre = idGenre;
//    }
//
//    public Book(int id, String name, int idAuthor, int idGenre, String authorName) {
//        this.id = id;
//        this.name = name;
//        this.idAuthor = idAuthor;
//        this.idGenre = idGenre;
//        this.authorName = authorName;
//    }

    public Book(int id, String name, String authorName, String genreName) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.genreName = genreName;
    }

//    public void setAuthorName(String authorName) {
//        this.authorName = authorName;
//    }

    public String getAuthorName() {
        return authorName;
    }

    public String getGenreName() {
        return genreName;
    }

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
}
