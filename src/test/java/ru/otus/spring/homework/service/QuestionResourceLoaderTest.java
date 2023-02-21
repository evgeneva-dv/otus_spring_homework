package ru.otus.spring.homework.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.otus.spring.homework.Main;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RequiredArgsConstructor
@SpringJUnitConfig(Main.class)
class QuestionResourceLoaderTest {

    @Autowired
    private final QuestionResourceLoader questionResourceLoader;

    @Test
    void shouldReturnCorrectFile (QuestionResourceLoader questionResourceLoader) {
        File file = questionResourceLoader.getFile();
        assertEquals(file.getName(),"questions.csv");
        assertNotNull(file);
    }
}