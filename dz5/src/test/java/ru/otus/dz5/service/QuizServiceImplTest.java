package ru.otus.dz5.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz5.domain.Question;

import java.util.Locale;

import static org.junit.Assert.*;

@SpringBootApplication
@RunWith(SpringRunner.class)
public class QuizServiceImplTest {

    @MockBean
    private QuestionService qService;

    @MockBean
    private MessageSource messageSource;

//    @Autowired
//    private QuizServiceImpl quizService;

    @Test
    public void printMessage() {
        Mockito.when(this.messageSource.getMessage("user.name", null, Locale.US)).thenReturn("Enter your name");
        Mockito.when(this.messageSource.getMessage("user.name", null, new Locale("ru_RU"))).thenReturn("Введите свое имя");

        QuizService quizService = new QuizServiceImpl(qService,messageSource);
        assertEquals("Here is the wrong message", "Введите свое имя:", quizService.printMessage("user.name"));
        Locale.setDefault(Locale.US);
        assertEquals("Here is the wrong message", "Enter your name:", quizService.printMessage("user.name"));
    }
}