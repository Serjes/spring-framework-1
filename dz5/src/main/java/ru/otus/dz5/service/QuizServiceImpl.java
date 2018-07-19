package ru.otus.dz5.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.dz5.domain.Person;
import ru.otus.dz5.domain.Question;
import ru.otus.dz5.service.QuestionService;
import ru.otus.dz5.service.QuizService;

import java.util.Locale;
import java.util.Scanner;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuestionService qService;
    private final MessageSource messageSource;
    private Locale locale;

    public QuizServiceImpl(QuestionService qService, MessageSource messageSource) {
        this.qService = qService;
        this.messageSource = messageSource;
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
            if (question == null) {
                printMessage("testing.error");
                System.exit(1);
            }
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
        if (Locale.getDefault().equals(Locale.US)) {
            System.out.println(messageSource.getMessage(mes, null, Locale.US) + ":");
        } else {
            System.out.println(messageSource.getMessage(mes, null, new Locale("ru_RU")) + ":");
        }
    }

}
