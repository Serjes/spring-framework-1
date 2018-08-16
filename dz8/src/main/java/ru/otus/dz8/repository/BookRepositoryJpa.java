package ru.otus.dz8.repository;

import org.springframework.stereotype.Repository;
import ru.otus.dz8.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@SuppressWarnings("JpaQlInspection")
public class BookRepositoryJpa implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = entityManager.createQuery(
                "select b from Book b",
                Book.class);
        return query.getResultList();
    }

    @Override
    public long count() {
        return (long)entityManager.createQuery("select count(b.id) from Book b").getSingleResult();
    }

    @Override
    public Book getById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void insert(Book b) {
        entityManager.persist(b);
    }

    @Override
    public Book getByName(String name) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Book.class, id));
    }
}
