package com.spring.coursework3.service;

import com.spring.coursework3.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;


public interface QuestionService {
    public Question add(Question question);

    public Question add(String question, String answer);

    public Question remove(Question question);

    public Collection<Question> getAll();

    public Question getRandomQuestion(Collection<Question> questions);

}
