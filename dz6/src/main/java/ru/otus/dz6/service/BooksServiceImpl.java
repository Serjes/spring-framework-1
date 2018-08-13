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
    public void addBook(String name, String authorName, String genreName) {
        int authorId = authorDao.getByName(authorName);
        if (authorId == 0) {
            System.out.println("Возникли проблемы с базой при добавлении новой книги");
            return;
        }
        int genreId = genreDao.getByName(genreName);
        if (genreId == 0) {
            System.out.println("Возникли проблемы с базой при добавлении новой книги");
            return;
        }
        bookDao.insert(new Book(1, name, authorId, genreId));
    }

    @Override
    public void addTemplateBook() {
        addBook("Азазель", "Б.Акунин", "детектив");
    }

    @Override
    public void view() {
        List<Book> allBooks = bookDao.getAll();
        for (Book book : allBooks) {
            System.out.println("ID:" + book.getId() + " название: \"" + book.getName() + "\", автор: " + book.getAuthorName() + ", жанр: " + book.getGenreName());
        }
    }

    @Override
    public void count() {
        System.out.println("Количество книг в библиотеке: " + bookDao.count());
    }

    @Override
    public void delBook(int id) {
        bookDao.deleteById(id);
    }

}
