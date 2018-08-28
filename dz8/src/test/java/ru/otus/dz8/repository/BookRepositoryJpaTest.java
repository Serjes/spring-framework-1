package ru.otus.dz8.repository;

import org.h2.tools.Console;
import org.junit.After;
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
import ru.otus.dz8.domain.Book;
import ru.otus.dz8.domain.Genre;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.*;

@DataJpaTest
@ComponentScan("ru.otus.dz8")
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@RunWith(SpringRunner.class)
public class BookRepositoryJpaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepositoryJpa bookRepositoryJpa;

    @Autowired
    private GenreRepositoryJpa genreRepositoryJpa;

    @Autowired
    private AuthorRepositoryJpa authorRepositoryJpa;

    @Test
    public void whenGetById_thenReturnBook(){

        Author author = new Author("Б.Эккель");
        authorRepositoryJpa.insert(author);
//        entityManager.persist(author);
        Genre genre = new Genre("Информационные технологии");
        genreRepositoryJpa.insert(genre);
//        entityManager.persist(genre);

        Book book = new Book("Филиософия Java", author, genre);
        entityManager.persist(book);
        entityManager.flush();

        Book gotBook = bookRepositoryJpa.getById(1);
//        Book gotBook = bookRepositoryJpa.getByName(book.getName());
        System.out.println(gotBook.getName());

        assertEquals(gotBook.getName(), book.getName());
//        assertThat(gotBook.getName())
//                .isEqualTo(book.getName());

    }

}