package ru.otus.spring.homework;

import com.opencsv.exceptions.CsvException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import ru.otus.spring.homework.domain.Question;
import ru.otus.spring.homework.service.QuestionService;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        var context = new ClassPathXmlApplicationContext("/spring-context.xml");

        var questionService =  context.getBean(QuestionService.class);

        List<Question> questions = questionService.getAllQuestion();

        questions.forEach(x -> System.out.println("Question: " + x.getTextQuestion() + " Variants of answer: " + x.getVariantsAnswer()));

    }
}
