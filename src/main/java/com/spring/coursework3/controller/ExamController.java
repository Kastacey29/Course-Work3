package com.spring.coursework3.controller;

import com.spring.coursework3.model.Question;
import com.spring.coursework3.service.ExaminerService;
import com.spring.coursework3.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") Integer amount) {
        return this.examinerService.getQuestions(amount);
    }
}
