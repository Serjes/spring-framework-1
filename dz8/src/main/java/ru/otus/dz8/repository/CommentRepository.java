package ru.otus.dz8.repository;

import ru.otus.dz8.domain.Book;
import ru.otus.dz8.domain.Comment;

import java.util.List;

public interface CommentRepository {

    void insert(Comment c);

    List<Comment> getAllByBook(Book book);
}
