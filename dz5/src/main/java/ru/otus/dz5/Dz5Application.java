package ru.otus.dz5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.dz5.service.QuizService;

@SpringBootApplication
public class Dz5Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Dz5Application.class, args);

        QuizService quiz = context.getBean(QuizService.class);
        quiz.begin();
    }
}
