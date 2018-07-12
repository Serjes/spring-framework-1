package ru.otus.dz4.dao;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.otus.dz4.config.ApplicationSettings;
import ru.otus.dz4.domain.Question;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

@Service
public class QuestionDaoImpl implements QuestionDao {

    private final String[] fileName;

    public QuestionDaoImpl(ApplicationSettings settings) {
//    public QuestionDaoImpl(@Value("${application.csvfile}")String fileName) {
        this.fileName = settings.getCsvFile();
    }

    @Override
    public Question findOneTest(int index) {
        String question = "";
        String correctAnswer = "";
        ArrayList<String> answers = new ArrayList<>();
        String file;
        if (Locale.getDefault().equals(Locale.US)){
            file = fileName[1];
        } else {
            file = fileName[0];
        }
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(file);
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
