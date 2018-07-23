package ru.otus.dz5.dao;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz5.config.ApplicationSettings;
import ru.otus.dz5.domain.Question;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Properties;

import static org.junit.Assert.*;

@SpringBootApplication
@RunWith(SpringRunner.class)
public class QuestionDaoImplTest {

    @MockBean
    private ApplicationSettings applicationSettings;

    @Autowired
    private QuestionDaoImpl questionDao;

    @Test
    public void findOneTest() {
        String[] files = new String[]{"testquestions.csv", "testquestions.csv"};
        Mockito.when(this.applicationSettings.getCsvFile()).thenReturn(files);

        questionDao = new QuestionDaoImpl(applicationSettings);
        Question question = questionDao.findOneTest(3);
        HashSet<String> realAnswers = new HashSet<>();
        Collections.addAll(realAnswers, " answer41", " answer42", " answer43", " answer44");
        assertTrue("Here is the wrong question", question.getQuestion().equals("question4"));
        assertTrue("Here is the wrong answer", question.getCorrectAnswer().equals(" answer41"));
        assertTrue("Here is the wrong set of answers", question.getAnswers().containsAll(realAnswers));
    }
}