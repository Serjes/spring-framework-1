package ru.otus.dz8.repository;

import ru.otus.dz8.domain.Book;

//import javax.persistence.Query;
import java.util.List;

public interface BookRepository {

    List<Book> getAll();

    long count();

    Book getById(int id);

    void insert(Book b);

    void deleteById(int id);
}
