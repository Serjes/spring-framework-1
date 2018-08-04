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

    @ShellMethod("Add one template book")
    public void init() {
        booksService.addTemplateBook();
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

    @ShellMethod("Adding a book to the Library: add book_name --author author_name --genre genre_name")
    public void add(
            @ShellOption String bookName,
            @ShellOption String author,
            @ShellOption String genre){

        System.out.println("Добавляем книгу: " + bookName + " " + author + " " + genre);
        booksService.addBook(bookName, genre, author);
    }

    @ShellMethod("View all books")
    public void viewAll(){
        booksService.view();
    }

    @ShellMethod("Count books")
    public void count(){
        booksService.count();
    }
}
