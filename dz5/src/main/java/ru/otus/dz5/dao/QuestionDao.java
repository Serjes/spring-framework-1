package ru.otus.dz5.dao;

import ru.otus.dz5.domain.Question;

public interface QuestionDao {

    Question findOneTest(int index);
}
