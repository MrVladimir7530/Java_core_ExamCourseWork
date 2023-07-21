package com.example.examcoursework.service;

import com.example.examcoursework.storage.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface QuestionService {
    boolean add(String question, String answer);
    boolean remove(String question, String answer);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
