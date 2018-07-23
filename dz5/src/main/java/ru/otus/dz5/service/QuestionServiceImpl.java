package ru.otus.dz5.service;

import org.springframework.stereotype.Service;
import ru.otus.dz5.dao.QuestionDao;
import ru.otus.dz5.domain.Question;

@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionDao dao;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public Question getOneTest(int i) {
        return dao.findOneTest(i);
    }
}
