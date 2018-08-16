package ru.otus.dz8.repository;

import ru.otus.dz8.domain.Author;
//import ru.otus.dz8.domain.Book;

public interface AuthorRepository {

    Author getByName(String name);

    void insert(Author author);
}
