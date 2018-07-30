package ru.otus.dz6.service;

public interface BooksService {
    void start();
    void addBook(String name, String genre, String author);
}
