package ru.otus.spring.homework.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.spring.homework.dao.QuestionDaoCsv;
import ru.otus.spring.homework.domain.Question;
import ru.otus.spring.homework.utils.TestData;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class QuestionServiceImplTest {

    @MockBean
    private QuestionDaoCsv questionDaoCsv;

    @Autowired
    private QuestionService questionService;

    @Test
    void shouldReturnCorrectTextQuestionFromCsv() {
        when(questionDaoCsv.findAll())
                .thenReturn(TestData.provideQuestion());

        List<Question> questions = questionService.getAllQuestion();
        assertEquals(questions.get(0).getTextQuestion(),TestData.provideQuestion().get(0).getTextQuestion());
    }
}