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
        String question = "";
        ArrayList<String> answers = new ArrayList<>();
//        answers.add("ANSWER1");
        CSVReader csvReader = null;
//        ClassLoader classLoader = getClass().getClassLoader();
        try {
//            File file = new File(classLoader.getResource("/questions.csv").getFile());
//            File file = new File(String.valueOf(this.getClass().getResource("/questions.csv")));
//            File file = new File("/questions.csv");
//            File file = ResourceUtils.getFile(this.getClass().getResource("/some_file.txt"));
            File file = new File(this.getClass().getResource("/questions.csv").getFile());
//            FileReader fileReader = new FileReader(file);
            csvReader = new CSVReader( new FileReader(file), ',', '"', 0);

            if (csvReader != null) {
                String[] nextLine;
                int i = 0;
                while ((nextLine = csvReader.readNext()) != null) {
                    if ((nextLine != null) && (i == index)) {
//                        System.out.println(Arrays.toString(nextLine));
                        question = nextLine[0];
                        answers.addAll(Arrays.asList(nextLine[1],nextLine[2],nextLine[3],nextLine[4]));
                    }
                    i++;
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
