package ru.otus.spring.homework.service;

import ru.otus.spring.homework.domain.Answer;
import ru.otus.spring.homework.domain.User;

import java.util.List;

public interface TestingService {

    List<Answer> testing();

    void evaluateResult(List<Answer> answers, User user);
}
