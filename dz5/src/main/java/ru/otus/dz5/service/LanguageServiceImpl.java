package ru.otus.dz5.service;

import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

@Service
public class LanguageServiceImpl implements LanguageService {
    private Locale locale;
    @Override
    public void select() {
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
        }
        Locale.setDefault(locale);
        return;
    }
}
