package ru.otus.csv.service;

import ru.otus.csv.dao.QuestionDao;
import ru.otus.csv.domain.Question;

public class QuestionServiceImpl implements QuestionService{
    private QuestionDao dao;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    public Question getOneTest(int i) {
        return dao.findOneTest(i);
    }
}
