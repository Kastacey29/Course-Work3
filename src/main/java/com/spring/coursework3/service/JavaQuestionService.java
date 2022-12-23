package com.spring.coursework3.service;

import com.spring.coursework3.exception.BadRequestException;
import com.spring.coursework3.exception.NotFoundException;
import com.spring.coursework3.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {
    Set<Question> questions = new HashSet<>();
    private Random random;

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getRandom(int bound) {
        return random.nextInt(bound);
    }



    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new BadRequestException("Введите значение!");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question add(String question, String answer) {
        if (question == null || question.isEmpty()) {
            throw new BadRequestException("Введите значение!");
        }
        if (answer == null || answer.isEmpty()) {
            throw new BadRequestException("Введите значение!");
        }
        return add(new Question(question, answer));
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new NotFoundException("Значение не найдено");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion(Collection<Question> questions) {
        int questionNumber = getRandom(questions.size());
        List<Question> questionList = questions.stream().toList();
        return questionList.get(questionNumber);
    }
    }
