package com.example.examcoursework.controller;

import com.example.examcoursework.service.QuestionService;
import com.example.examcoursework.storage.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public String addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return "<h1>Question added successfully:</h1>\n" + questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public String removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return "<h1>Question removed successfully:</h1>\n" + questionService.remove(question,answer);
    }
    @GetMapping
    public String getAllQuestions() {
        return "List all question:\n" + questionService.getAll();
    }


}
