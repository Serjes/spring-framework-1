package ru.otus.dz8.service;

public interface BooksService {

    void addTemplateBook();

    void addBook(String name, String genre, String author);

    void view();

    void count();

    void delBook(int id);
}
