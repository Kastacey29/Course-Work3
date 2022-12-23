package com.spring.coursework3.service;

import com.spring.coursework3.exception.BadRequestException;
import com.spring.coursework3.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {


    private final QuestionService questionService;


    public ExaminerServiceImpl( QuestionService questionService) {
        this.questionService = questionService;
            }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new BadRequestException("Введите корректное значение!");
        }
        Set<Question> questionSet = new HashSet<>();
        while (questionSet.size() < amount) {
            questionSet.add(questionService.getRandomQuestion(questionService.getAll()));
        }
        return questionSet;
    }
}
