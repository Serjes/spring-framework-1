package ru.otus.csv.dao;

import au.com.bytecode.opencsv.CSVReader;
import ru.otus.csv.domain.Quest;

import java.io.FileReader;
import java.util.ArrayList;

public class QuestDaoImpl implements QuestDao{
    public Quest findOneTest(int index) {
        String question = "QU";
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("ANSWER1");

//        CSVReader reader = new CSVReader(new FileReader("questions.csv"), ',' , '"' , 1);

        return new Quest(question, answers);
    }
}
