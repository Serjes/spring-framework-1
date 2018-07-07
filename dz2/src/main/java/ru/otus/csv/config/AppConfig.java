package ru.otus.csv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
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
//    @Value("#{ systemProperties['user.region'] }")
//    private Locale currentLocale;
//
//    public Locale getCurrentLocale() {
//        return currentLocale;
//    }

    @Bean
    MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    QuestionDao questionDao(@Value("${csvfile.url}") String fileName) {
        return new QuestionDaoImpl(fileName);
    }

    @Bean
    QuestionService questionService(QuestionDao dao) {
        return new QuestionServiceImpl(dao);
    }

    @Bean
    TestingService testingService(QuestionService qService, MessageSource messageSource){
        return new TestingServiceImpl(qService, messageSource);
    }
}
