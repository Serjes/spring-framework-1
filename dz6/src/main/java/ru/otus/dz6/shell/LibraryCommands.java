package ru.otus.dz6.shell;

import org.h2.tools.Console;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.dz6.service.BooksService;

import java.sql.SQLException;

@ShellComponent
public class LibraryCommands {
    private final BooksService booksService;

    public LibraryCommands(BooksService booksService) {
        this.booksService = booksService;
    }

    @ShellMethod("minimal Library initialization")
    public void init() {
        booksService.start();
        return;
    }

    @ShellMethod("Running of the DB-console")
    public void runConsole(){
        try {
            Console.main("-browser");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @ShellMethod("Adding a book to the Library: add book_name --genre genre_name --author author_name")
    public void add(
            @ShellOption String bookName,
            @ShellOption String genre,
            @ShellOption String author){

        System.out.println("Книга: " + bookName + " " + genre + " " + author);
    }
}
