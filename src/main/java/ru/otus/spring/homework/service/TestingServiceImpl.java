package ru.otus.spring.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.domain.Answer;
import ru.otus.spring.homework.domain.Question;
import ru.otus.spring.homework.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class TestingServiceImpl implements TestingService{

    private final QuestionServiceImpl questionService;
    @Value("${countTrueAnswer}")
    private Long rightCountTrueAnswer;

    @Override
    public List<Answer> testing() {

        List<Question> questions = questionService.getAllQuestion();
        List<Answer> answers = new ArrayList<>();
        String inputAnswerString;
        Answer answer;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter one variants of answer");

        for (Question question : questions) {
            System.out.println("Question: " + question.getTextQuestion());
            System.out.println("Variants of answer: " + question.getVariantsAnswer());
            inputAnswerString = in.next();
            answer = new Answer(question.getId(), inputAnswerString, inputAnswerString.toUpperCase().equals(question.getTrueAnswer()));
            answers.add(answer);
            System.out.println(answer.isTrueAnswer());
        }
        in.close();
        return answers;
    }

    @Override
    public void evaluateResult(List<Answer> answers, User user) {

        Long countTrueAnswer = answers.stream().filter(a->a.isTrueAnswer()).count();
        if (countTrueAnswer>=rightCountTrueAnswer) {
            System.out.println(user.getFirstName() +", you have successfully passed the test");
        }
        else {
            System.out.println(user.getFirstName() +", you failed the test");
        }
    }

}
