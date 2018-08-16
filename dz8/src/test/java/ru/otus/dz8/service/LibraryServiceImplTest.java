package ru.otus.dz8.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import ru.otus.dz8.dao.BookDao;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@SpringBootTest
//@SpringBootTest(properties={
//        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
//        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
//})
@RunWith(SpringRunner.class)
public class LibraryServiceImplTest {

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

//    @MockBean
//    private BookDao bookDao;

    @Autowired
    private LibraryServiceImpl booksService;

    @Test
    public void view() {
//        List<Book> books = new ArrayList<>();
//        books.add(new Book(1,"Азазель", "Б.Акунин", "детектив"));
//        Mockito.when(this.bookDao.getAll()).thenReturn(books);
//        booksService.listBooks();
//        assertEquals("ID:1 название: \"Азазель\", автор: Б.Акунин, жанр: детектив\r\n", outContent.toString());
    }
}