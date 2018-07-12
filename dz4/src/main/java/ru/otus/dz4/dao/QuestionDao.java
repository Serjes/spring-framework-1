package ru.otus.dz4.dao;

import ru.otus.dz4.domain.Question;

public interface QuestionDao {

    Question findOneTest(int index);
}
