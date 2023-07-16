package com.example.examcoursework.service;

import com.example.examcoursework.storage.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
