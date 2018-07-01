package ru.otus.csv;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.csv.domain.Question;
import ru.otus.csv.service.QuestionService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int score = 0;

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        QuestionService service = context.getBean(QuestionService.class);

        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter your surname:");
        String surname = scanner.nextLine();
        System.out.println("Testing began");
        for (int i = 0; i < 5; i++) {
            Question question = service.getOneTest(i);
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
        System.out.println("Student: " + name + " " + surname);
        System.out.println("Result: " + score);
    }
}
