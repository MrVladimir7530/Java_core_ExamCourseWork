package com.example.examcoursework.repository;

import com.example.examcoursework.storage.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository {
    private Set<Question> questions = new HashSet<>();

    public boolean add(Question question) {
        return questions.add(question);
    }

    public boolean remove(Question question) {
        return questions.remove(question);
    }

    public Collection<Question> getAll() {
        return questions;
    }
}
