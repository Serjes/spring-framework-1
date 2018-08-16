package ru.otus.dz8.service;

public interface LibraryService {

    void addTemplateBook();

    void addBook(String name, String genre, String author);

    void view();

    void count();

    void delBook(int id);

    void printAuthorId(String name);
}
