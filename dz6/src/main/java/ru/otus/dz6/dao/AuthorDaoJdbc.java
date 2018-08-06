package ru.otus.dz6.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.dz6.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations npjdbc;

    public AuthorDaoJdbc(NamedParameterJdbcOperations npjdbc) {
        this.npjdbc = npjdbc;
    }

    @Override
    public void insert(Author author) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("name", author.getName());
        npjdbc.update("insert into authors (`name`) values (:name )", params);
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

    @Override
    public int getByName(String authorName) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("name", authorName);
        try {
            Author author = npjdbc.queryForObject("select * from authors where name = :name", params, new AuthorMapper());
            return author.getId();
        } catch (EmptyResultDataAccessException e) {
            insert(new Author(1, authorName));
            try {
                Author createdAuthor = npjdbc.queryForObject("select * from authors where name = :name", params, new AuthorMapper());
                return createdAuthor.getId();
            }catch (EmptyResultDataAccessException ex) {
                return 0;
            }
        }
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
