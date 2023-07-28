package com.example.examcoursework.service;

import com.example.examcoursework.repository.JavaQuestionRepository;
import com.example.examcoursework.storage.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JavaQuestionServiceTest {
    private final JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();
    private final QuestionService questionService = new JavaQuestionService(javaQuestionRepository);

    @ParameterizedTest
    @CsvSource({"question1, answer1", "question2, answer2", "question3, answer3"})
    public void shouldReturnTrueWhenAddNewQuestion(String question, String answer) {
        boolean result = questionService.add(question, answer);
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenAddExistingQuestion() {
        questionService.add("question1", "answer1");
        boolean result = questionService.add("question1", "answer1");
        assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource({"question1, answer1", "question2, answer2", "question3, answer3"})
    public void shouldReturnTrueWhenRemoveExistingQuestion(String question, String answer) {
        questionService.add(question, answer);
        boolean result = questionService.remove(question, answer);
        assertTrue(result);

    }

    @Test
    public void shouldReturnFalseWhenRemoveExistingQuestion() {
        boolean result = questionService.remove("question1", "answer1");
        assertFalse(result);
    }

    @Test
    public void shouldReturnCollectionQuestion() {
        Set<Question> setExpected = new HashSet<>();
        Question question1 = new Question("question1", "answer1");
        Question question2 = new Question("question2", "answer2");
        Question question3 = new Question("question3", "answer3");
        setExpected.add(question1);
        setExpected.add(question2);
        setExpected.add(question3);
        questionService.add("question1", "answer1");
        questionService.add("question2", "answer2");
        questionService.add("question3", "answer3");
        assertEquals(setExpected, questionService.getAll());

    }

    @Test
    public void shouldReturn() {
        Question question1 = new Question("question1", "answer1");
        Question question2 = new Question("question2", "answer2");
        Question question3 = new Question("question3", "answer3");
        questionService.add("question1", "answer1");
        questionService.add("question2", "answer2");
        questionService.add("question3", "answer3");
        Question randomQuestion = questionService.getRandomQuestion();
        boolean result = (Objects.equals(randomQuestion, question1) || Objects.equals(randomQuestion, question2) || Objects.equals(randomQuestion, question3));
        assertTrue(result);
    }

}
