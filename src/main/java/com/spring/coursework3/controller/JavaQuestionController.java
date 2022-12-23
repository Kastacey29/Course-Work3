package com.spring.coursework3.controller;

import com.spring.coursework3.model.Question;
import com.spring.coursework3.service.JavaQuestionService;
import com.spring.coursework3.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService javaQuestionService) {
        this.questionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return this.questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return this.questionService.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return this.questionService.getAll();
    }
}
