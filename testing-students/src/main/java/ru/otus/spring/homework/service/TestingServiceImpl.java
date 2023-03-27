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

@Service
@RequiredArgsConstructor
public class TestingServiceImpl implements TestingService{

    private final MessageSource messageSource;
    private final AppProps props;
    private final QuestionServiceImpl questionService;
    private final IOService ioService;


    @Value("${application.countTrueAnswer}")
    private Long rightCountTrueAnswer;

    @Override
    public List<Answer> testing() {

        var questions = questionService.getAllQuestion();
        var answers = new ArrayList<Answer>();
        Answer answer;

        ioService.out(messageSource.getMessage("manual", null, props.getLocale()));

        for (Question question : questions) {
            outputQuestion(question);
            answer = new Answer(question.getId(), ioService.readString());
            answer.setTrueAnswer(checkAnswer(question,answer));
            answers.add(answer);
            ioService.out(String.valueOf(answer.isTrueAnswer()));
        }
        return answers;
    }

    @Override
    public void evaluateResult(List<Answer> answers, User user) {

        Long countTrueAnswer = answers.stream().filter(a->a.isTrueAnswer()).count();
        if (countTrueAnswer>=rightCountTrueAnswer) {
            ioService.out(messageSource.getMessage("success", new String[]{user.getFirstName()}, props.getLocale()));
        }
        else {
            ioService.out(messageSource.getMessage("fail", new String[]{user.getFirstName()}, props.getLocale()));
        }
    }

    private void outputQuestion (Question question) {
        ioService.out(messageSource.getMessage("question", null, props.getLocale()));
        ioService.out(question.getTextQuestion());
        ioService.out(messageSource.getMessage("variants.answer", null, props.getLocale()));
        ioService.out(question.getVariantsAnswer());
    }

    private boolean checkAnswer (Question question, Answer answer) {
        var isTrueAnswer = answer.getAnswer().toUpperCase().equals(question.getTrueAnswer());
        return isTrueAnswer;
    }

}
