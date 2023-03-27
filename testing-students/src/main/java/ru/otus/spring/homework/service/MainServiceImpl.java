package ru.otus.spring.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.domain.Answer;
import ru.otus.spring.homework.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService{

    private final GreetingService greetingService;
    private final TestingService testingService;


    @Override
    public void run() {
        User user = greetingService.greet();
        List<Answer> answers = testingService.testing();
        testingService.evaluateResult(answers,user);
    }
}
