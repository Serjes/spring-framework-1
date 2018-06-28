package ru.otus.csv.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.csv.domain.Quest;

import java.util.Collections;
import java.util.HashSet;

public class QuestDaoImplTest {
    public static final String TEST_FILE_NAME = "testquestions.csv";
    QuestDaoImpl questDao;

    @Before
    public void setUp() throws Exception {
        questDao = new QuestDaoImpl(TEST_FILE_NAME);
    }

    @Test
    public void findOneTest() {
        Quest quest = questDao.findOneTest(3);
        HashSet<String> realAnswers = new HashSet<>();
        Collections.addAll(realAnswers, " answer41", " answer42", " answer43", " answer44");
        Assert.assertTrue("Here is the wrong question", quest.getQuestion().equals("question4"));
        Assert.assertTrue("Here is the wrong answer", quest.getCorrectAnswer().equals(" answer41"));
        Assert.assertTrue("Here is the wrong set of answers", quest.getAnswers().containsAll(realAnswers));
    }
}