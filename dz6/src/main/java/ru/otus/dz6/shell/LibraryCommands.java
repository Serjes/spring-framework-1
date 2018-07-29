package ru.otus.dz6.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.dz6.service.BooksService;

@ShellComponent
public class LibraryCommands {
    private final BooksService booksService;

    public LibraryCommands(BooksService booksService) {
        this.booksService = booksService;
    }

    @ShellMethod("Library start")
    public void start() {
        booksService.start();
        return;
    }
}
