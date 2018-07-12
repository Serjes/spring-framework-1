package ru.otus.dz4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.dz4.service.QuizService;

@SpringBootApplication
public class Dz4Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Dz4Application.class, args);
        QuizService quiz = context.getBean(QuizService.class);
        quiz.begin();
    }
}
