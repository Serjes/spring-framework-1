package ru.otus.dz6.service;

import org.springframework.stereotype.Service;
import ru.otus.dz6.dao.AuthorDao;
import ru.otus.dz6.dao.BookDao;
import ru.otus.dz6.dao.GenreDao;
import ru.otus.dz6.domain.Author;
import ru.otus.dz6.domain.Book;
import ru.otus.dz6.domain.Genre;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;

    public BooksServiceImpl(BookDao bookDao, AuthorDao authorDao, GenreDao genreDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.genreDao = genreDao;
    }

    @Override
    public void start() {
        bookDao.insert(new Book(1, "Азазель", 1, 1));
        System.out.println("Book have been inserted");
    }

    @Override
    public void addBook(String name, String genre, String author) {
        authorDao.insert(new Author(2, author));
        genreDao.insert(new Genre(2, genre));
        bookDao.insert(new Book(2, name, 2, 2));
    }

    @Override
    public void view() {
        List<Book> allBooks = bookDao.getAll();
        int i = 1;
        for (Book book : allBooks) {
//            int idAuthor = book.getIdAuthor();
            Author author = authorDao.getById(book.getIdAuthor());
            Genre genre = genreDao.getById(book.getIdGenre());
            System.out.printf("%d) ",i);
            System.out.println("Книга: " + book.getName() + ", автор: " + author.getName() + ", жанр: " + genre.getName());
            i++;
        }
    }

    @Override
    public void count() {
        System.out.println("Количество книг в библиотеке: " + bookDao.count());
    }

}
