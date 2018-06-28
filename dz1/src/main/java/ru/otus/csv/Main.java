package ru.otus.csv;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.csv.domain.Quest;
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
            Quest quest = service.getOneTest(i);
            System.out.printf("Question #%d: %s %n", i+1, quest.getQuestion());
            System.out.println("Select the answer: ");
            int j = 1;
            for (String s : quest.getAnswers()){
                System.out.printf("%d) %s %n",j,s);
                j++;
            }
            int userAnswer = scanner.nextInt();
            if (quest.getAnswers().get(userAnswer - 1).equals(quest.getCorrectAnswer())) {
                score ++;
            }
        }
        System.out.println("Student: " + name + " " + surname);
        System.out.println("Result: " + score);
    }
}
