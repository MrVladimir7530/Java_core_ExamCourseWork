package com.example.examcoursework.service;


import com.example.examcoursework.storage.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    List<QuestionService> questionService;

    public ExaminerServiceImpl(List<QuestionService> questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            Random random = new Random();
            Question newQuestion = questionService.get(random.nextInt(1)).getRandomQuestion();
            questions.add(newQuestion);
        }
        return questions;
    }
}
