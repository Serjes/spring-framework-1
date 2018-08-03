package ru.otus.dz6.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz6.dao.BookDao;
import ru.otus.dz6.domain.Book;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootApplication
@RunWith(SpringRunner.class)
public class BooksServiceImplTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @MockBean
    private BookDao bookDao;

    @Test
    public void addTemplateBook() {
    }

    @Test
    public void addBook() {
    }

    @Test
    public void view() {
//        List<Book> books = new ArrayList<>();
//        books.add(new Book());
//        Mockito.when(this.bookDao.getAll()).thenReturn(new List<Book>() {
//        });
//        assertEquals("1) Книга: Азазель, автор: Б.Акунин, жанр: детектив",
//                outContent.toString());
    }

    @Test
    public void count() {
    }
}