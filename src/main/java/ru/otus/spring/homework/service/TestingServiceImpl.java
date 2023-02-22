package ru.otus.spring.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.configs.AppProps;
import ru.otus.spring.homework.domain.Answer;
import ru.otus.spring.homework.domain.Question;
import ru.otus.spring.homework.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class TestingServiceImpl implements TestingService{

    private final MessageSource messageSource;
    private final AppProps props;
    private final QuestionServiceImpl questionService;
    @Value("${application.countTrueAnswer}")
    private Long rightCountTrueAnswer;

    @Override
    public List<Answer> testing() {

        var questions = questionService.getAllQuestion();
        var answers = new ArrayList<Answer>();
        Answer answer;
        var userInput = new Scanner(System.in);

        System.out.println(messageSource.getMessage("manual", null, props.getLocale()));

        for (Question question : questions) {
            outputQuestion(question);
            answer = new Answer(question.getId(), userInput.nextLine());
            answer.setTrueAnswer(checkAnswer(question,answer));
            answers.add(answer);
            System.out.println(answer.isTrueAnswer());
        }
        userInput.close();
        return answers;
    }

    @Override
    public void evaluateResult(List<Answer> answers, User user) {

        Long countTrueAnswer = answers.stream().filter(a->a.isTrueAnswer()).count();
        if (countTrueAnswer>=rightCountTrueAnswer) {
            System.out.println(messageSource.getMessage("success", new String[]{user.getFirstName()}, props.getLocale()));
        }
        else {
            System.out.println(messageSource.getMessage("fail", new String[]{user.getFirstName()}, props.getLocale()));
        }
    }

    private void outputQuestion (Question question) {
        System.out.println(messageSource.getMessage("question", null, props.getLocale()));
        System.out.println(question.getTextQuestion());
        System.out.println(messageSource.getMessage("variants.answer", null, props.getLocale()));
        System.out.println(question.getVariantsAnswer());
    }

    private boolean checkAnswer (Question question, Answer answer) {
        var isTrueAnswer = answer.getAnswer().toUpperCase().equals(question.getTrueAnswer());
        return isTrueAnswer;
    }

}
