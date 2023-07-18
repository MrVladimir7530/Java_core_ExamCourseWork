package com.example.examcoursework.controller;

import com.example.examcoursework.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/java/random")
    public String getQuestions(@RequestParam("amount") int amount) {
        return "list questions: " + examinerService.getQuestions(amount);
    }
}
