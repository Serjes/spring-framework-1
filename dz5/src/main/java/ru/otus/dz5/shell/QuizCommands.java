package ru.otus.dz5.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.dz5.service.LanguageService;
import ru.otus.dz5.service.QuizService;

@ShellComponent
public class QuizCommands {
    private final LanguageService languageService;
    private final QuizService qService;

    @Autowired
    public QuizCommands(LanguageService languageService, QuizService qService) {
        this.languageService = languageService;
        this.qService = qService;
    }

    @ShellMethod("Begin Quiz")
    public void begin() {
        qService.begin();
        return;
    }

    @ShellMethod("Select language for Quiz")
    public void selectLang(){
        languageService.select();
    }
}
