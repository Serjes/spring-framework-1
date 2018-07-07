package ru.otus.csv.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.csv.domain.Question;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Properties;

public class QuestionDaoImplTest {
    private static final String PATH_TO_PROPERTIES = "src/test/resources/application.properties";
    private QuestionDaoImpl questionDao;
    private Properties prop = new Properties();

    @Before
    public void setUp() throws Exception {
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            prop.load(fileInputStream);
            String testFileName = prop.getProperty("testcsvfile.url");
            questionDao = new QuestionDaoImpl(testFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
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