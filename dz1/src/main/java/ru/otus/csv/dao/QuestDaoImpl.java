package ru.otus.csv.dao;

import au.com.bytecode.opencsv.CSVReader;
import ru.otus.csv.domain.Quest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestDaoImpl implements QuestDao {
    public Quest findOneTest(int index) {
        String question = "QU";
        ArrayList<String> answers = new ArrayList<>();
        answers.add("ANSWER1");


        CSVReader csvReader = null;
        ClassLoader classLoader = getClass().getClassLoader();

//        try {
//            Reader reader = Files.newBufferedReader(Paths.get("questions.csv"));
//            csvReader = new CSVReader(reader);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
//            File file = new File(classLoader.getResource("/questions.csv").getFile());
            File file = new File(String.valueOf(this.getClass().getResource("/questions.csv")));
            csvReader = new CSVReader(new FileReader(file), ',', '"', 0);

            if (csvReader != null) {
                String[] nextLine;
                while ((nextLine = csvReader.readNext()) != null) {
                    if (nextLine != null) {

                        System.out.println(Arrays.toString(nextLine));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Quest(question, answers);
    }
}
