package ru.otus.dz6.dao;

import ru.otus.dz6.domain.Genre;

public interface GenreDao {

    void insert(Genre genre);

    Genre getById(int id);
}
