package com.example.examcoursework.service;

import com.example.examcoursework.exceptions.FewQuestionsException;
import com.example.examcoursework.storage.Question;
import org.springframework.stereotype.Service;

import java.rmi.NotBoundException;
import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    Set<Question> questions = new HashSet<>();

    @Override
    public boolean add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return questions.add(newQuestion);
    }


    @Override
    public boolean remove(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return questions.remove(newQuestion);
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int numberTicket = random.nextInt(questions.size() - 1);
        int currentIndex = 0;
        for (Question q : questions) {
            if (currentIndex == numberTicket) {
                return q;
            }
            currentIndex++;
        }
        throw new FewQuestionsException();
    }
}
