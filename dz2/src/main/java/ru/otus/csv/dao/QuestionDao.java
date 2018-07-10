package ru.otus.csv.dao;

import ru.otus.csv.domain.Question;

public interface QuestionDao {

    Question findOneTest(int index);
}
