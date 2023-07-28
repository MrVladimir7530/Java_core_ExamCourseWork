package com.example.examcoursework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/map")
public class MathQuestionController {
    @GetMapping("/add")
    public ResponseEntity addQuestion() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @GetMapping("/remove")
    public ResponseEntity removeQuestion() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @GetMapping()
    public ResponseEntity getAllQuestion() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }
}
