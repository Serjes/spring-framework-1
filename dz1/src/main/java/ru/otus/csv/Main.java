package ru.otus.csv;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.csv.domain.Quest;
import ru.otus.csv.service.QuestionService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int[] userAnswers = new int[5];
        ArrayList<Integer> userAnswers = new ArrayList<Integer>();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        QuestionService service = context.getBean(QuestionService.class);

        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter your surname:");
        String surname = scanner.nextLine();
        System.out.println("The test began:");

        for (int i = 0; i < 5; i++) {
            Quest quest = service.getOneTest(i);
            System.out.println("Question: " + quest.getQuestion());
            System.out.println("Select the answer: " + quest.getAnswers());
//            userAnswers[i] = scanner.nextInt();
            userAnswers.add(scanner.nextInt());
        }

        System.out.println("Results: " + userAnswers);

//        Person ivan = service.getByName("Ivan");
//        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
    }
}
