package com.example.examcoursework.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MathQuestionService  {

    public String getRandomQuestion() {
        Random random = new Random();
        int number = random.nextInt(4);
        int num1 = getRandomNumber();
        int num2 = getRandomNumber();
        switch (number) {
            case 0:
                return num1 + " + " + num2 + " = ?";
            case 1:
                return num1 + " - " + num2 + " = ?";
            case 2:
                return num1 + " * " + num2 + " = ?";
            case 3:
                return num1 + " / " + num2 + " = ?";
            default:
                throw new RuntimeException();
        }
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10000);
    }
}
