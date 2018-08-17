package ru.otus.dz8.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz8.domain.Author;
import ru.otus.dz8.domain.Genre;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@DataJpaTest
@ComponentScan("ru.otus.dz8.repository")
@RunWith(SpringRunner.class)
public class GenreRepositoryJpaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GenreRepositoryJpa genreRepositoryJpa;

    @Test
    public void whenGetByName_thenReturnGenre(){
        Genre genre = new Genre("Информационные технологии");
        entityManager.persist(genre);
        entityManager.flush();

        Genre gotGenre = genreRepositoryJpa.getByName(genre.getName());

        assertThat(gotGenre.getName())
                .isEqualTo(genre.getName());
    }

}