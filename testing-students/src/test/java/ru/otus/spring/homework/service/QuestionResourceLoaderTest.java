package ru.otus.spring.homework.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = QuestionResourceLoader.class)
class QuestionResourceLoaderTest {

    @Autowired
    private QuestionResourceLoader questionResourceLoader;

    @Value("${application.path}")
    private String pathFile;

    @Test
    void shouldReturnCorrectFile () {
        File file = questionResourceLoader.getFile();
        assertEquals(file.getName(),pathFile);
        assertNotNull(file);
    }
}