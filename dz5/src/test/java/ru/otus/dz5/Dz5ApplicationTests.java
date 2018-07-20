package ru.otus.dz5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz5.config.ApplicationSettings;
import ru.otus.dz5.dao.QuestionDaoImpl;

//@SpringBootApplication
@RunWith(SpringRunner.class)
@SpringBootTest
public class Dz5ApplicationTests {

//    @Configuration
//    static class TestContextConfiguration {
//
//        @Bean
//        public ApplicationSettings settings(){
//            return new ApplicationSettings();
//        }
//
//    }

    @Autowired
    private ApplicationSettings settings;

//    @Autowired
//    private QuestionDaoImpl questionDao;

//    @Test
//    public void testQuestionDao(){
//        String[] fileNames = questionDao.getFileName();
//        Assert.assertEquals("questions.csv", fileNames[0]);
//        Assert.assertEquals("questions_en_US.csv", fileNames[1]);
//    }

    @Test
    public void testApplicationSettings(){
        String[] files = settings.getCsvFile();
        Assert.assertEquals("questions.csv", files[0]);
    }
}
