package ru.otus.dz8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.dz8.domain.Book;
import ru.otus.dz8.domain.Comment;
import ru.otus.dz8.repository.BookRepositoryJpa;
import ru.otus.dz8.repository.CommentRepositoryJpa;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BookRepositoryJpa bookRepositoryJpa;

    @Autowired
    private CommentRepositoryJpa commentRepositoryJpa;

    @Override
    public void add(String content, int bookId) {
        Book book = bookRepositoryJpa.getById(bookId);
        Comment comment = new Comment(content, book);
        commentRepositoryJpa.insert(comment);
    }

    @Override
    public void listByBook(int bookId) {
        Book book = bookRepositoryJpa.getById(bookId);
        List<Comment> comments = commentRepositoryJpa.getAllByBook(book);
        if (comments.isEmpty()) {
            System.out.println("нет комментариев к книге \"" + book.getName() + "\"");
            return;
        }
        System.out.println("Комментарии к книге \"" + book.getName() + "\":");
        int i = 1;
        for (Comment comment : comments) {
            System.out.println(i + ") " + comment.getContent());
            i++;
        }
    }
}
