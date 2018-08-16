package ru.otus.dz8.repository;

import org.springframework.stereotype.Repository;
import ru.otus.dz8.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@SuppressWarnings("JpaQlInspection")
public class AuthorRepositoryJpa implements AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Author getByName(String name) {
        TypedQuery<Author> query = entityManager.createQuery("select a from Author a where a.name = :name", Author.class);
        query.setParameter("name", name);
        try {
            Author author = query.getSingleResult();
            return author;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void insert(Author author) {
        entityManager.persist(author);
    }

    @Override
    public List<Author> getAll() {
        TypedQuery<Author> query = entityManager.createQuery(
                "select a from Author a",
                Author.class);
        return query.getResultList();
    }
}
