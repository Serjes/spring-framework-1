package ru.otus.dz8.repository;

import org.springframework.stereotype.Repository;
import ru.otus.dz8.domain.Book;
import ru.otus.dz8.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@SuppressWarnings("JpaQlInspection")
public class CommentRepositoryJpa implements CommentRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(Comment c) {
        entityManager.persist(c);
    }

    @Override
    public List<Comment> getAllByBook(Book book) {
        TypedQuery<Comment> query = entityManager.createQuery(
                "select c from Comment c where c.book.id = :id", Comment.class);
        query.setParameter("id", book.getId());
//        return query.getResultList();
        try {
            List<Comment> comments = query.getResultList();
            return comments;
        } catch (NoResultException e) {
            return null;
        }
    }
}
