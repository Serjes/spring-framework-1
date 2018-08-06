package ru.otus.dz6.dao;

import ru.otus.dz6.domain.Book;

import java.util.List;

public interface BookDao {

    void insert(Book book);

    List<Book> getAll();

    int count();

    void deleteById(int id);
}
