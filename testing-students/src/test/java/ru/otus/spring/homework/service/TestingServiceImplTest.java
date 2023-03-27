package ru.otus.spring.homework.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.spring.homework.domain.Answer;
import ru.otus.spring.homework.utils.TestData;

import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestingServiceImplTest {

    @Autowired
    private TestingServiceImpl testingService;

    @MockBean
    private QuestionServiceImpl questionService;

    @MockBean
    private IOServiceStreams ioService;

    @Test
    void ShouldReturnCorrectAnswers () {

        when(questionService.getAllQuestion())
                .thenReturn(TestData.provideQuestion());
        when(ioService.readString())
                .thenReturn(TestData.provideQuestion().get(0).getTrueAnswer(), null);

        List<Answer> answers = testingService.testing();

        assertEquals(answers.get(0), new Answer(TestData.provideQuestion().get(0).getId(),TestData.provideQuestion().get(0).getTrueAnswer()));
    }


}