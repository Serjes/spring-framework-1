package ru.otus.dz8.shell;

//import org.h2.tools.Console;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.dz8.service.LibraryService;

@ShellComponent
public class LibraryCommands {
    private final LibraryService libraryService;

    public LibraryCommands(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

//    @ShellMethod("Запустить консоль H2DB")
////    @ShellMethod("Running of the DB-console")
//    public void runConsole(){
//        try {
//            Console.main("-browser");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @ShellMethod("Добавить книгу в библиотеку: add book_name --author author_name --genre genre_name")
//    @ShellMethod("Adding a book to the Library: add book_name --author author_name --genre genre_name")
    public void add(
            @ShellOption String bookName,
            @ShellOption String author,
            @ShellOption String genre){

        System.out.println("Добавляем книгу: \"" + bookName + "\" " + author + " " + genre);
        libraryService.addBook(bookName, author, genre);
    }

    @ShellMethod("Добавить шаблонную книгу")
//    @ShellMethod("Add one template book")
    public void addt() {
        libraryService.addTemplateBook();
        System.out.println("Добавляем книгу: \"Азазель\", Б.Акунин, детектив");
        return;
    }

    @ShellMethod("Показать все книги в библиотеке")
//    @ShellMethod("View all books")
    public void viewAll(){
        libraryService.view();
    }

    @ShellMethod("Вывести количество книг в библитеке")
//    @ShellMethod("Count books")
    public void count(){
        libraryService.count();
    }

    @ShellMethod("Удалить книгу по номеру ID: del id_number")
    public void del(
            @ShellOption int id){
        libraryService.delBook(id);
    }

    @ShellMethod("показать id автора по имени")
    public void showAuthor(
            @ShellOption String name
    ){
        libraryService.printAuthorId(name);
    }
}
