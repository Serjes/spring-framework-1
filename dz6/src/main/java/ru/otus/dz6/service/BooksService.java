package ru.otus.dz6.service;

public interface BooksService {

    void addTemplateBook();

    void addBook(String name, String genre, String author);

    void view();

    void count();

    void delBook(int id);
}
