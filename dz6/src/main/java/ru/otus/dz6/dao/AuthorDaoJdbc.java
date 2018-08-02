package ru.otus.dz6.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.dz6.domain.Author;
import ru.otus.dz6.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

//    private final JdbcOperations jdbc;
    private final NamedParameterJdbcOperations npjdbc;

//    public AuthorDaoJdbc(JdbcOperations jdbc, NamedParameterJdbcOperations npjdbc) {
    public AuthorDaoJdbc(NamedParameterJdbcOperations npjdbc) {
//        this.jdbc = jdbc;
        this.npjdbc = npjdbc;
    }

//    @Override
//    public void insert(Author author) {
//        jdbc.update("insert into authors (id, `name`) values (?, ?)",
//                author.getId(), author.getName());
//    }

    @Override
    public void insert(Author author) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("id", author.getId());
        params.put("name", author.getName());
        npjdbc.update("insert into authors (id, `name`) values (:id, :name )", params);
    }

    @Override
    public Author getById(int id) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return npjdbc.queryForObject(
                "select * from authors where id =:id",
                params, new AuthorMapper()
        );
    }

    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            return new Author(id, name);
        }
    }
}
