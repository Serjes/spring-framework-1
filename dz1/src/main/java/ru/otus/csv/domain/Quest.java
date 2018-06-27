package ru.otus.csv.domain;

import java.util.ArrayList;

public class Quest {
    private String question;
    private ArrayList<String> answers;

    public Quest(String question, ArrayList<String> answers){
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion(){
        return question;
    }

    public ArrayList<String> getAnswers(){
        return answers;
    }
}
