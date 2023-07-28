package com.example.examcoursework.service;

import com.example.examcoursework.storage.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {
    @Override
    public boolean add(String question, String answer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(String question, String answer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int number = random.nextInt(4);
        int num1 = getRandomNumber();
        int num2 = getRandomNumber();
        switch (number) {
            case 0:
                return new Question(num1 + " + " + num2 + " = ?", String.valueOf(num1 + num2));
            case 1:
                return new Question(num1 + " - " + num2 + " = ?", String.valueOf(num1 - num2));
            case 2:
                return new Question(num1 + " * " + num2 + " = ?", String.valueOf(num1 * num2));
            case 3:
                return new Question(num1 + " / " + num2 + " = ?", String.valueOf(num1 / (num2+1)));
            default:
                throw new RuntimeException();
        }
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10000);
    }
}
