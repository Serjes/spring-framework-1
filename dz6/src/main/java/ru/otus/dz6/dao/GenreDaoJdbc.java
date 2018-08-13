package ru.otus.dz6.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.dz6.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Repository
public class GenreDaoJdbc implements GenreDao {

    private final NamedParameterJdbcOperations npjdbc;

    public GenreDaoJdbc(NamedParameterJdbcOperations npjdbc) {
        this.npjdbc = npjdbc;
    }

    @Override
    public void insert(Genre genre) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("name", genre.getName());
        npjdbc.update("insert into genres (`name`) values (:name)", params);
    }

    @Override
    public Genre getById(int id) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return npjdbc.queryForObject(
                "select * from genres where id =:id",
                params, new GenreDaoJdbc.GenreMapper()
        );
    }

    @Override
    public int getByName(String genreName) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("name", genreName);
        try {
            Genre genre = npjdbc.queryForObject("select * from genres where name = :name", params, new GenreMapper());
            return genre.getId();
        } catch (EmptyResultDataAccessException e) {
            insert(new Genre(1, genreName));
            try {
                Genre createdGenre = npjdbc.queryForObject("select * from genres where name = :name", params, new GenreMapper());
                return createdGenre.getId();
            }catch (EmptyResultDataAccessException ex) {
                return 0;
            }
        }
    }

    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            return new Genre(id, name);
        }
    }
}
