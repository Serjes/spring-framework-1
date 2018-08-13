package ru.otus.dz6.dao;

import ru.otus.dz6.domain.Author;

public interface AuthorDao {

    void insert(Author author);

    Author getById(int id);

    int getByName(String author);
}
