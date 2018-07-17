package ru.otus.dz4.service;

import org.springframework.stereotype.Service;
import ru.otus.dz4.dao.QuestionDao;
import ru.otus.dz4.domain.Question;

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
