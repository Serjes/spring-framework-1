package ru.otus.dz6.dao;

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
//        params.put("id", author.getId());
        params.put("name", author.getName());
//        npjdbc.update("insert into authors (id, `name`) values (:id, :name )", params);
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

    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            return new Author(id, name);
        }
    }
}
