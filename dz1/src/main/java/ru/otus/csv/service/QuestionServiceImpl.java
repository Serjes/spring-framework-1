package ru.otus.csv.service;

import ru.otus.csv.dao.QuestDao;
import ru.otus.csv.domain.Quest;

public class QuestionServiceImpl implements QuestionService{
    private QuestDao dao;

    public QuestionServiceImpl(QuestDao dao) {
        this.dao = dao;
    }

    public Quest getOneTest(int i) {
        return dao.findOneTest(i);
    }
}
