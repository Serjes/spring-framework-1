package ru.otus.csv.service;

import org.springframework.context.MessageSource;
import ru.otus.csv.domain.Person;
import ru.otus.csv.domain.Question;

import java.util.Locale;
import java.util.Scanner;

public class TestingServiceImpl implements TestingService{

    private QuestionService qService;
    private MessageSource messageSource;

    public TestingServiceImpl(QuestionService qService, MessageSource messageSource) {
        this.qService = qService;
        this.messageSource = messageSource;
    }

    @Override
    public Person begin() {
        int score = 0;
//        System.out.println("Enter your name:");
        System.out.println(messageSource.getMessage("user.name", null, Locale.US) +":");
        System.out.println(messageSource.getMessage("user.name", null, null) +":");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter your surname:");
        String surname = scanner.nextLine();
        Person student = new Person(name, surname);
//        System.out.println("Testing began");
        for (int i = 0; i < 5; i++) {
            Question question = qService.getOneTest(i);
            System.out.printf("Question #%d: %s %n", i + 1, question.getQuestion());
            System.out.println("Answers: ");
            int j = 1;
            for (String s : question.getAnswers()) {
                System.out.printf("%d) %s %n", j, s);
                j++;
            }
            int userAnswer = 0;
            do {
                System.out.println("Enter the number of answer: ");
                userAnswer = scanner.nextInt();
            } while ((userAnswer < 1) || (userAnswer > 4));
            if (question.getAnswers().get(userAnswer - 1).equals(question.getCorrectAnswer()))
                score++;
        }
        student.setScore(score);
        return student;
    }

}
