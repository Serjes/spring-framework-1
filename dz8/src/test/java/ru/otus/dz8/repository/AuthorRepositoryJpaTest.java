package ru.otus.dz8.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz8.domain.Author;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.junit.Assert.*;

@DataJpaTest
@ComponentScan("ru.otus.dz8.repository")
@RunWith(SpringRunner.class)
public class AuthorRepositoryJpaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AuthorRepositoryJpa authorRepositoryJpa;

    @Test
    public void whenGetByName_thenReturnAuthor(){
        Author author = new Author("Б.Эккель");
        entityManager.persist(author);
        entityManager.flush();

        Author gotAuthor = authorRepositoryJpa.getByName(author.getName());

//        System.out.println(gotAuthor.getName());

        assertThat(gotAuthor.getName())
                .isEqualTo(author.getName());
    }
}