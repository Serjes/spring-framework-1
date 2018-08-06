package ru.otus.dz6.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz6.dao.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

@Ignore
//@SpringBootApplication
//@ComponentScan({"ru.otus.dz6.dao","ru.otus.dz6.service"})
@ContextConfiguration(classes={BookDaoJdbc.class,GenreDaoJdbc.class,AuthorDaoJdbc.class})
//@SpringBootTest(properties={
//        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
//        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
//})
@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:schema.sql","classpath:data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class BooksServiceImplTest2 {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private GenreDao genreDao;

//    @Autowired
//    private BooksServiceImpl booksService;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void addBook() {
    }

    @Test
    public void addTemplateBook() {
    }

    @Test
    public void view() {
        BooksService booksService = new BooksServiceImpl(bookDao, authorDao, genreDao);
        booksService.view();
        assertEquals("ID:1 название: \"Азазель\", автор: Б.Акунин, жанр: детектив\r\n", outContent.toString());
    }

    @Test
    public void count() {
    }

    @Test
    public void delBook() {
    }
}