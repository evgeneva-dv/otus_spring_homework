package ru.otus.spring.homework.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.spring.homework.dao.QuestionDaoCsv;
import ru.otus.spring.homework.domain.Question;
import ru.otus.spring.homework.utils.TestData;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionServiceImplTest {

    private QuestionDaoCsv questionDaoCsv =Mockito.mock(QuestionDaoCsv.class);

    QuestionService questionService = new QuestionServiceImpl(questionDaoCsv);

    @Test
    void shouldReturnCorrectDaoCsv () {
        Mockito.when(questionDaoCsv.findAll())
                .thenReturn(TestData.provideQuestion());

        List<Question> questions = questionService.getAllQuestion();
        assertEquals(questions.get(0).getTextQuestion(),TestData.provideQuestion().get(0).getTextQuestion());
    }
}