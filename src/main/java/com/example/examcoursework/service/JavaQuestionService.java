package com.example.examcoursework.service;

import com.example.examcoursework.exceptions.FewQuestionsException;
import com.example.examcoursework.repository.JavaQuestionRepository;
import com.example.examcoursework.storage.Question;
import org.springframework.stereotype.Service;

import java.rmi.NotBoundException;
import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    JavaQuestionRepository questionRepository;

    public JavaQuestionService(JavaQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public boolean add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return questionRepository.add(newQuestion);
    }


    @Override
    public boolean remove(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return questionRepository.remove(newQuestion);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int numberTicket = random.nextInt(questionRepository.getAll().size() - 1);
        int currentIndex = 0;
        for (Question q : questionRepository.getAll()) {
            if (currentIndex == numberTicket) {
                return q;
            }
            currentIndex++;
        }
        throw new FewQuestionsException();
    }
}
