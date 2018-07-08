package ru.otus.csv.service;

import org.springframework.context.MessageSource;
import ru.otus.csv.domain.Person;
import ru.otus.csv.domain.Question;
import java.util.Locale;
import java.util.Scanner;

public class TestingServiceImpl implements TestingService{

    private QuestionService qService;
    private MessageSource messageSource;
    private Locale local;

    public TestingServiceImpl(QuestionService qService, MessageSource messageSource, Locale local) {
        this.qService = qService;
        this.messageSource = messageSource;
        this.local = local;
    }

    @Override
    public void begin() {
        int score = 0;
        printMessage("user.name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        printMessage("user.surname");
        String surname = scanner.nextLine();
        Person student = new Person(name, surname);
        for (int i = 0; i < 5; i++) {
            Question question = qService.getOneTest(i);
            printMessage("testing.question");
            System.out.printf("#%d %s %n", i + 1, question.getQuestion());
            printMessage("testing.answers");
            int j = 1;
            for (String s : question.getAnswers()) {
                System.out.printf("%d) %s %n", j, s);
                j++;
            }
            int userAnswer = 0;
            do {
                printMessage("user.answer");
                userAnswer = scanner.nextInt();
            } while ((userAnswer < 1) || (userAnswer > 4));
            if (question.getAnswers().get(userAnswer - 1).equals(question.getCorrectAnswer()))
                score++;
        }
        student.setScore(score);
        printMessage("user.student");
        System.out.println(student.getName() + " " + student.getSurname());
        printMessage("user.score");
        System.out.println(student.getScore());
        return;
    }

    void printMessage(String mes) {
        if (local.equals(Locale.getDefault())) {
            System.out.println(messageSource.getMessage(mes, null, Locale.getDefault()) + ":");
        } else {
            System.out.println(messageSource.getMessage(mes, null, Locale.US) + ":");
        }
    }

}
