package ru.otus.dz4.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.dz4.domain.Person;
import ru.otus.dz4.domain.Question;

import java.util.Locale;
import java.util.Scanner;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuestionService qService;
    private final MessageSource messageSource;
    private Locale locale;// = Locale.getDefault();
//    private Locale locale = Locale.getDefault();

    public QuizServiceImpl(QuestionService qService, MessageSource messageSource) {
//    public QuizServiceImpl(QuestionService qService, MessageSource messageSource, @Value("${local}")Locale local) {
        this.qService = qService;
        this.messageSource = messageSource;
//        this.local = local;
    }

    @Override
    public void begin() {
        int score = 0;
        languageSelect();
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

    private void languageSelect() {
        System.out.println("Выберете язык\\Choose language:\n 1 - Русский\n 2 - English");
        System.out.print(">");
        Scanner sc = new Scanner(System.in);
        int userSelection = sc.nextInt();
        switch (userSelection) {
            case 2:
                locale = Locale.US;
                break;
            case 1:
            default:
                locale = Locale.getDefault(); //RU
//                break;
        }
        Locale.setDefault(locale);
        return;

    }

    void printMessage(String mes) {
//        if (locale.equals(Locale.getDefault())) {
//            System.out.println(messageSource.getMessage(mes, null, Locale.getDefault()) + ":");
//        } else {
//            System.out.println(messageSource.getMessage(mes, null, Locale.US) + ":");
//        }
        if (Locale.getDefault().equals(Locale.US)) {
            System.out.println(messageSource.getMessage(mes, null, Locale.US) + ":");
        } else {
            System.out.println(messageSource.getMessage(mes, null, new Locale("ru_RU")) + ":");
        }
    }

}
