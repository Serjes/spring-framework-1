package ru.otus.dz4.dao;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.dz4.domain.Question;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Service
public class QuestionDaoImpl implements QuestionDao {

    private final String fileName;

    public QuestionDaoImpl(@Value("${csvfile.url}")String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Question findOneTest(int index) {
        String question = "";
        String correctAnswer = "";
        ArrayList<String> answers = new ArrayList<>();
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        if (resourceAsStream == null) {
            return null;
        }
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(resourceAsStream, "UTF-8"))) {
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
