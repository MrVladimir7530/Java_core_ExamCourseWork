package com.example.examcoursework.service;

import com.example.examcoursework.exceptions.FewQuestionsException;
import com.example.examcoursework.storage.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount)  {
            throw new FewQuestionsException();
        }
        List<Question> questionList = new ArrayList<>();
        int number = 0;
        while (number < amount) {
            Question newQuestion = questionService.getRandomQuestion();
            if(!questionList.contains(newQuestion)){
                questionList.add(newQuestion);
                number++;
            }
        }
        return questionList;
    }
}
