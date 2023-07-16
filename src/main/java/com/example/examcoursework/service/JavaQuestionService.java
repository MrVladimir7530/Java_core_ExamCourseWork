package com.example.examcoursework.service;

import com.example.examcoursework.storage.Question;
import org.springframework.stereotype.Service;

import java.rmi.NotBoundException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService{
    Set<Question> questions;

    public JavaQuestionService(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
     public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.remove(newQuestion);
        return newQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int numberTicket = random.nextInt(questions.size()-1);
        int currentIndex = 0;
        for (Question q: questions) {
            if (currentIndex == numberTicket) {
                return q;
            }
            currentIndex++;
        }
        throw new RuntimeException("Question is not found");
    }
}
