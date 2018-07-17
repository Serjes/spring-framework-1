package ru.otus.dz4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz4.config.ApplicationSettings;
import ru.otus.dz4.dao.QuestionDaoImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Dz4ApplicationTests {

    @Autowired
    private ApplicationSettings settings;

    @Autowired
    private QuestionDaoImpl questionDao;

    @Test
    public void testQuestionDao(){
        String[] fileNames = questionDao.getFileName();
        Assert.assertEquals("questions.csv", fileNames[0]);
        Assert.assertEquals("questions_en_US.csv", fileNames[1]);
    }

    @Test
    public void testApplicationSettings(){
        String[] files = settings.getCsvFile();
        Assert.assertEquals("questions.csv", files[0]);
    }
}
