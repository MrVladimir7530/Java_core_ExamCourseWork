package com.example.examcoursework.service;

import com.example.examcoursework.repository.JavaQuestionRepository;
import com.example.examcoursework.storage.Question;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ExaminerServiceImplTest {
    private final JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();
    private final QuestionService questionService = new JavaQuestionService(javaQuestionRepository);
    private final ExaminerService examinerService = new ExaminerServiceImpl(questionService);

    @Test
    public void shouldReturnTrueWhenGetRandomCollectionQuestions() {
        questionService.add("question1", "answer1");
        questionService.add("question2", "answer2");
        questionService.add("question3", "answer3");
        questionService.add("question4", "answer4");
        questionService.add("question5", "answer5");
        Collection<Question> questionSet =  questionService.getAll();
        Collection<Question> setExpectedRandom =  examinerService.getQuestions(2);
        for (Question q : setExpectedRandom) {
            boolean s = questionSet.contains(q);
            assertTrue(s);
        }
    }
}
