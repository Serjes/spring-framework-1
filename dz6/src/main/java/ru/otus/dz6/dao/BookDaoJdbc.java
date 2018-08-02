package ru.otus.dz6.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.dz6.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Repository
public class BookDaoJdbc implements BookDao {

    private final JdbcOperations jdbc;
    private final NamedParameterJdbcOperations npjdbc;

    public BookDaoJdbc(JdbcOperations jdbc, NamedParameterJdbcOperations npjdbc) {
        this.jdbc = jdbc;
        this.npjdbc = npjdbc;
    }

    @Override
    public void insert(Book book) {
        jdbc.update("insert into books (id, `name`, `author_id`, `genre_id`) values (?, ?, ?, ?)",
                book.getId(), book.getName(), book.getIdAuthor(), book.getIdGenre());
    }

    @Override
    public List<Book> getAll(){
        return jdbc.query("select * from books", new BookMapper());
    }

    @Override
    public int count() {
        final HashMap<String, Object> params = new HashMap<>(1);
        return npjdbc.queryForObject("select count(*) from books", params, Integer.class);
    }

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int idAuthor = resultSet.getInt("author_id");
            int idGenre = resultSet.getInt("genre_id");
            return new Book(id, name, idAuthor, idGenre);
        }
    }
}
