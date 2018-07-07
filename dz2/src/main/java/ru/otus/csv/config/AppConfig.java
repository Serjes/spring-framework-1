package ru.otus.csv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.csv.dao.QuestionDao;
import ru.otus.csv.dao.QuestionDaoImpl;
import ru.otus.csv.service.QuestionService;
import ru.otus.csv.service.QuestionServiceImpl;
import ru.otus.csv.service.TestingService;
import ru.otus.csv.service.TestingServiceImpl;

import java.util.Locale;

@PropertySource("classpath:application.properties")
@Configuration
public class AppConfig {
    @Value("#{ systemProperties['user.region'] }")
    private Locale currentLocale;

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    @Bean
//    QuestionDao questionDao(@Value("questions.csv") String fileName) {
    QuestionDao questionDao(@Value("${csvfile.url}") String fileName) {
        return new QuestionDaoImpl(fileName);
    }

    @Bean
    QuestionService questionService(QuestionDao dao) {
        return new QuestionServiceImpl(dao);
    }

    @Bean
    TestingService testingService(QuestionService qService){
        return new TestingServiceImpl(qService);
    }
}
