package com.spring.coursework3.service;

import com.spring.coursework3.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    public void setUp() {
        this.javaQuestionService = new JavaQuestionService();
        Question question1 = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");
        Question question3 = new Question("Question3", "Answer3");
        Question question4 = new Question("Question4", "Answer4");
        Question question5 = new Question("Question5", "Answer5");
        javaQuestionService.questions.add(question1);
        javaQuestionService.questions.add(question2);
        javaQuestionService.questions.add(question3);
        javaQuestionService.questions.add(question4);
        javaQuestionService.questions.add(question5);
    }

    @Test
    public void add() {
        Question question6 = javaQuestionService.add(new Question("Question6", "Answer6"));
        org.junit.jupiter.api.Assertions.assertEquals(question6.getQuestion(), "Question6");
        org.junit.jupiter.api.Assertions.assertEquals(question6.getAnswer(), "Answer6");
        Assertions.assertThat(javaQuestionService.questions.contains(question6));
        Assertions.assertThat(javaQuestionService.questions).hasSize(6);
    }


    @Test
    public void remove() {
        Question result = javaQuestionService.remove(new Question("Question3", "Answer3"));
        org.junit.jupiter.api.Assertions.assertEquals(result.getQuestion(), "Question3");
        org.junit.jupiter.api.Assertions.assertEquals(result.getAnswer(), "Answer3");
        Assertions.assertThat(!javaQuestionService.questions.contains(result));
        Assertions.assertThat(javaQuestionService.questions).hasSize(4);

    }


    @Test
    public void getAll() {
        Question question1 = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");
        Question question3 = new Question("Question3", "Answer3");
        Question question4 = new Question("Question4", "Answer4");
        Question question5 = new Question("Question5", "Answer5");
        Collection<Question> result = javaQuestionService.getAll();
        Assertions.assertThat(result).hasSize(5);
        Assertions.assertThat(result).contains(question1, question2, question3, question4, question5);

    }
}