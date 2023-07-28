package com.example.examcoursework.service;

import com.example.examcoursework.storage.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathQuestionServiceTest {
    private final MathQuestionService mathQuestionService = new MathQuestionService();

    @Test
    public void addTest() {
        assertThrows(UnsupportedOperationException.class, () -> mathQuestionService.add("question", "answer"));
    }

    @Test
    public void removeTest() {
        assertThrows(UnsupportedOperationException.class, () -> mathQuestionService.remove("question", "answer"));
    }

    @Test
    public void getAllTest() {
        assertThrows(UnsupportedOperationException.class, () -> mathQuestionService.getAll());
    }

    @Test
    public void getRandomQuestionTest() {
        assertEquals(Question.class, mathQuestionService.getRandomQuestion().getClass());
    }

}
