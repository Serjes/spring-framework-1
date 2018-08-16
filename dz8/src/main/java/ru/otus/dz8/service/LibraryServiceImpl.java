package ru.otus.dz8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import ru.otus.dz8.dao.AuthorDao;
//import ru.otus.dz8.dao.BookDao;
//import ru.otus.dz8.dao.GenreDao;
import ru.otus.dz8.domain.Author;
import ru.otus.dz8.domain.Book;
import ru.otus.dz8.domain.Genre;
import ru.otus.dz8.repository.AuthorRepositoryJpa;
import ru.otus.dz8.repository.BookRepositoryJpa;
import ru.otus.dz8.repository.GenreRepositoryJpa;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BookRepositoryJpa bookRepositoryJpa;

    @Autowired
    private GenreRepositoryJpa genreRepositoryJpa;

    @Autowired
    private AuthorRepositoryJpa authorRepositoryJpa;


    @Override
    public void addTemplateBook() {
        addBook("Азазель", "Б.Акунин", "детектив");
    }

    @Override
    public void addBook(String name, String authorName, String genreName) {
        Author author = authorRepositoryJpa.getByName(authorName);
        if (author == null) {
            author = new Author(authorName);
            authorRepositoryJpa.insert(author);
        }
        Genre genre = genreRepositoryJpa.getByName(genreName);
        if (genre == null) {
            genre = new Genre(genreName);
            genreRepositoryJpa.insert(genre);
        }
//        Genre genre = new Genre(genreName);
        Book book = new Book(name, author, genre);
        bookRepositoryJpa.insert(book);
    }

    @Override
    public void listBooks() {
        List<Book> books = bookRepositoryJpa.getAll();
        for (Book book : books) {
            System.out.println("ID:" + book.getId() + " название: \"" + book.getName() + "\", автор: "
                    + book.getAuthor().getName() + ", жанр: " + book.getGenre().getName());
        }
    }

    @Override
    public void count() {
        System.out.println(bookRepositoryJpa.count());
    }

    @Override
    public void delBook(int id) {
        bookRepositoryJpa.deleteById(id);
    }

    @Override
    public void printAuthorId(String name) {
        System.out.println("id: " + authorRepositoryJpa.getByName(name).getId());
    }

    @Override
    public void listAuthors() {
        List<Author> authors = authorRepositoryJpa.getAll();
        for (Author author : authors) {
            System.out.println("ID:" + author.getId() + " автор: " + author.getName());
        }
    }

//    private final BookDao bookDao;
//    private final AuthorDao authorDao;
//    private final GenreDao genreDao;
//
//    public LibraryServiceImpl(BookDao bookDao, AuthorDao authorDao, GenreDao genreDao) {
//        this.bookDao = bookDao;
//        this.authorDao = authorDao;
//        this.genreDao = genreDao;
//    }
//
//    @Override
//    public void addBook(String name, String authorName, String genreName) {
//        int authorId = authorDao.getByName(authorName);
//        if (authorId == 0) {
//            System.out.println("Возникли проблемы с базой при добавлении новой книги");
//            return;
//        }
//        int genreId = genreDao.getByName(genreName);
//        if (genreId == 0) {
//            System.out.println("Возникли проблемы с базой при добавлении новой книги");
//            return;
//        }
//        bookDao.add(new Book(1, name, authorId, genreId));
//    }
//
//    @Override
//    public void addTemplateBook() {
//        addBook("Азазель", "Б.Акунин", "детектив");
//    }
//
//    @Override
//    public void listBooks() {
//        List<Book> allBooks = bookDao.getAll();
//        for (Book book : allBooks) {
//            System.out.println("ID:" + book.getId() + " название: \"" + book.getName() + "\", автор: " + book.getAuthorName() + ", жанр: " + book.getGenreName());
//        }
//    }
//
//    @Override
//    public void count() {
//        System.out.println("Количество книг в библиотеке: " + bookDao.count());
//    }
//
//    @Override
//    public void delBook(int id) {
//        bookDao.deleteById(id);
//    }

}
