package ru.otus.dz8.repository;

import org.springframework.stereotype.Repository;
import ru.otus.dz8.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@Transactional
@SuppressWarnings("JpaQlInspection")
public class GenreRepositoryJpa implements GenreRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Genre getByName(String name) {
        TypedQuery<Genre> query = entityManager.createQuery("select g from Genre g where g.name = :name", Genre.class);
        query.setParameter("name", name);
        try {
            Genre genre = query.getSingleResult();
            return genre;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void insert(Genre genre) {
        entityManager.persist(genre);
    }
}
