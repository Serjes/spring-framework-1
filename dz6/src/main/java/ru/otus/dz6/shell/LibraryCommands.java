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

    @ShellMethod("Запустить консоль H2DB")
//    @ShellMethod("Running of the DB-console")
    public void runConsole(){
        try {
            Console.main("-browser");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @ShellMethod("Добавить книгу в библиотеку: add book_name --author author_name --genre genre_name")
//    @ShellMethod("Adding a book to the Library: add book_name --author author_name --genre genre_name")
    public void add(
            @ShellOption String bookName,
            @ShellOption String author,
            @ShellOption String genre){

        System.out.println("Добавляем книгу: \"" + bookName + "\" " + author + " " + genre);
        booksService.addBook(bookName, author, genre);
    }

    @ShellMethod("Добавить шаблонную книгу")
//    @ShellMethod("Add one template book")
    public void addt() {
        booksService.addTemplateBook();
        System.out.println("Добавляем книгу: \"Азазель\", Б.Акунин, детектив");
        return;
    }

    @ShellMethod("Показать все книги в библиотеке")
//    @ShellMethod("View all books")
    public void viewAll(){
        booksService.view();
    }

    @ShellMethod("Вывести количество книг в библитеке")
//    @ShellMethod("Count books")
    public void count(){
        booksService.count();
    }

    @ShellMethod("Удалить книгу по номеру ID: dell id_number")
    public void del(
            @ShellOption int id){
        booksService.delBook(id);
    }
}
