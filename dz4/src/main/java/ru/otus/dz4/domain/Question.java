package ru.otus.dz4.domain;

import java.util.ArrayList;

public class Question {

    private String question;
    private ArrayList<String> answers;
    private String correctAnswer;

    public Question(String question, ArrayList<String> answers, String correctAnswer){
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion(){
        return question;
    }

    public ArrayList<String> getAnswers(){
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
