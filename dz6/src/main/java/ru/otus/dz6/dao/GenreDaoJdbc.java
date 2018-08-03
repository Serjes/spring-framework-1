package ru.otus.dz6.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.dz6.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Repository
public class GenreDaoJdbc implements GenreDao {
//    private final JdbcOperations jdbc;
    private final NamedParameterJdbcOperations npjdbc;

//    public GenreDaoJdbc(JdbcOperations jdbc, NamedParameterJdbcOperations npjdbc) {
    public GenreDaoJdbc(NamedParameterJdbcOperations npjdbc) {
//        this.jdbc = jdbc;
        this.npjdbc = npjdbc;
    }

    @Override
    public void insert(Genre genre) {
        final HashMap<String, Object> params = new HashMap<>(1);
//        params.put("id", genre.getId());
        params.put("name", genre.getName());
//        npjdbc.update("insert into genres (id, `name`) values (:id, :name)", params);
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

    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            return new Genre(id, name);
        }
    }
}
