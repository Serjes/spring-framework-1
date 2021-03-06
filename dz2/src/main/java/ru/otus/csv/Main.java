package ru.otus.csv;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.csv.config.AppConfig;
import ru.otus.csv.domain.Person;
import ru.otus.csv.service.TestingService;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        TestingService testingService = context.getBean(TestingService.class);
        testingService.begin();
    }
}
