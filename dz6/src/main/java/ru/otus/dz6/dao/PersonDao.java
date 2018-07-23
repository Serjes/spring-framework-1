package ru.otus.dz6.dao;

import ru.otus.dz6.domain.Person;

import java.util.List;

public interface PersonDao {

    int count();

    void insert(Person person);

    Person getById(int id);

    List<Person> getAll();
}
