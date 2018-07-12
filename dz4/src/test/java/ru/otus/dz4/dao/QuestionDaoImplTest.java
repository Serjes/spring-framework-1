package ru.otus.dz4.dao;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz4.config.ApplicationSettings;
import ru.otus.dz4.domain.Question;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Properties;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionDaoImplTest {

    @MockBean
    private ApplicationSettings applicationSettings;

    @Autowired
    private QuestionDaoImpl questionDao;

//    private static final String PATH_TO_PROPERTIES = "src/test/resources/application.properties";
//    private QuestionDaoImpl questionDao;
//    private Properties prop = new Properties();

//    @Before
//    public void setUp() throws Exception {
//
////        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
////            prop.load(fileInputStream);
////            String testFileName = prop.getProperty("csvfile.url");
////            questionDao = new QuestionDaoImpl(testFileName);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//    }

    @Test
    public void findOneTest() {
        String[] files = new String[]{"testquestions.csv", "testquestions.csv"};
        Mockito.when(this.applicationSettings.getCsvFile()).thenReturn(files);

        questionDao = new QuestionDaoImpl(applicationSettings);
        Question question = questionDao.findOneTest(3);
        HashSet<String> realAnswers = new HashSet<>();
        Collections.addAll(realAnswers, " answer41", " answer42", " answer43", " answer44");
        Assert.assertTrue("Here is the wrong question", question.getQuestion().equals("question4"));
        Assert.assertTrue("Here is the wrong answer", question.getCorrectAnswer().equals(" answer41"));
        Assert.assertTrue("Here is the wrong set of answers", question.getAnswers().containsAll(realAnswers));
    }
}