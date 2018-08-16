package ru.otus.dz8.repository;

import ru.otus.dz8.domain.Genre;

public interface GenreRepository {

    Genre getByName(String name);

    void insert(Genre genre);
}
