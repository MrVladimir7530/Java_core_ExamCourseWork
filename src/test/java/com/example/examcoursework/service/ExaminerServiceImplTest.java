package com.example.examcoursework.service;

import com.example.examcoursework.storage.Question;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExaminerServiceImplTest {
    private final QuestionService questionService = Mockito.mock(QuestionService.class);
    private final List<QuestionService> questionServiceList = List.of(questionService);
    private final ExaminerService examinerService = new ExaminerServiceImpl(questionServiceList);

    @Test
    public void shouldReturnTrueWhenGetRandomCollectionQuestions() {
        Mockito.when(questionService.getRandomQuestion()).thenReturn(new Question("question1", "answer1"))
                .thenReturn(new Question("question2", "answer2"))
                .thenReturn(new Question("question3", "answer3"));
        Collection<Question> setExpectedRandom =  examinerService.getQuestions(3);
        Question questionResult = new Question("question2", "answer2");
        assertTrue(setExpectedRandom.contains(questionResult));
    }
}
