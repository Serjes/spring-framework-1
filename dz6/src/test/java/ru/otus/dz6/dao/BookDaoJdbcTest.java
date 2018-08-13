package ru.otus.dz6.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz6.domain.Book;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootApplication
@ContextConfiguration(classes=BookDaoJdbc.class)
@Sql(scripts = {"classpath:schema.sql","classpath:data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@RunWith(SpringRunner.class)
public class BookDaoJdbcTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void insert() {
        bookDao.insert(new Book(1, "Турецкий гамбит", 1, 1));
        List<Book> books = bookDao.getAll();
        assertEquals("Азазель", books.get(0).getName());
        assertEquals("Турецкий гамбит", books.get(1).getName());
    }

    @Test
    public void getAll() {
        List<Book> allBooks = bookDao.getAll();
        Book book = allBooks.get(0);
        assertEquals("ID:1 название: \"Азазель\", автор: Б.Акунин, жанр: детектив",
                "ID:" + book.getId() + " название: \"" + book.getName() + "\", автор: " + book.getAuthorName() + ", жанр: " + book.getGenreName());
    }

    @Test
    public void count() {
        assertEquals(1, bookDao.count());
    }

    @Test
    public void deleteById() {
        bookDao.deleteById(1);
        assertEquals(0, bookDao.count());
    }
}