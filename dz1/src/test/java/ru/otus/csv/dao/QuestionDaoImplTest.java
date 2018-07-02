package ru.otus.csv.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.csv.domain.Question;

import java.util.Collections;
import java.util.HashSet;

public class QuestionDaoImplTest {
    private static final String TEST_FILE_NAME = "testquestions.csv";
    private QuestionDaoImpl questionDao;

    @Before
    public void setUp() throws Exception {
        questionDao = new QuestionDaoImpl(TEST_FILE_NAME);
    }

    @Test
    public void findOneTest() {
        Question question = questionDao.findOneTest(3);
        HashSet<String> realAnswers = new HashSet<>();
        Collections.addAll(realAnswers, " answer41", " answer42", " answer43", " answer44");
        Assert.assertTrue("Here is the wrong question", question.getQuestion().equals("question4"));
        Assert.assertTrue("Here is the wrong answer", question.getCorrectAnswer().equals(" answer41"));
        Assert.assertTrue("Here is the wrong set of answers", question.getAnswers().containsAll(realAnswers));
    }
}