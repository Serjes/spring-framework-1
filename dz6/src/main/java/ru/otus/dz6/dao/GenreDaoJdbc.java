package ru.otus.dz6.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.dz6.domain.Genre;

@Repository
public class GenreDaoJdbc implements GenreDao {
    private final JdbcOperations jdbc;

    public GenreDaoJdbc(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void insert(Genre genre) {
        jdbc.update("insert into genres (id, `name`) values (?, ?)",
                genre.getId(), genre.getName());
    }
}
