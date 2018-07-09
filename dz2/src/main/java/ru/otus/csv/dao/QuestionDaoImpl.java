package ru.otus.csv.dao;

import au.com.bytecode.opencsv.CSVReader;
import ru.otus.csv.domain.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class QuestionDaoImpl implements QuestionDao {

    private String fileName;

    public QuestionDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Question findOneTest(int index) {
        String question = "";
        String correctAnswer = "";
        ArrayList<String> answers = new ArrayList<>();
//        File file  = new File(this.getClass().getResource("classpath:/" + fileName).getFile());
//        File file  = new File(this.getClass().getResource("/" + fileName).getFile());
        String fileNameResource = "";
//        try{
//            //работает
////            fileNameResource = this.getClass().getClassLoader().getResource("questions.csv").getFile();
//            fileNameResource = this.getClass().getClassLoader().getResource("questions.csv").getFile();
////            fileNameResource = this.getClass().getResource("/questions.csv").getFile();
//        } catch (Exception e) {
//            System.out.println("Troubles with getResource");
//            e.printStackTrace();
//        }
        InputStream resourceAsStream = null;
        try {
            //мешал classpathPrefix lib/
//            resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("questions.csv");
            resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        } catch (Exception e) {
            System.out.println("Troubles with resourceAsStream");
            e.printStackTrace();
        }
        if (resourceAsStream == null) {
            System.out.println("TROUBLES with Resource");
            return null;
        }
//        if (fileNameResource.isEmpty()) return null;
//        File file  = new File(fileNameResource);
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(resourceAsStream, "UTF-8"))) {
//        try (CSVReader csvReader = new CSVReader(new FileReader(file), ',', '"', 0)) {
            String[] nextLine;
            int i = 0;
            while ((nextLine = csvReader.readNext()) != null) {
                if (i == index) {
                    question = nextLine[0];
                    answers.addAll(Arrays.asList(nextLine[1], nextLine[2], nextLine[3], nextLine[4]));
                    correctAnswer = nextLine[1];
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(answers);
        return new Question(question, answers, correctAnswer);
    }
}
