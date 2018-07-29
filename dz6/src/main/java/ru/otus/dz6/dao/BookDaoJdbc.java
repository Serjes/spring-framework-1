package ru.otus.dz6.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.dz6.domain.Book;

@Repository
public class BookDaoJdbc implements BookDao {

    private final JdbcOperations jdbc;

    public BookDaoJdbc(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void insert(Book book) {
        jdbc.update("insert into books (id, `name`, `author_id`, `genre_id`) values (?, ?, ?, ?)",
                book.getId(), book.getName(), book.getIdAuthor(), book.getIdGenre());
    }
}
