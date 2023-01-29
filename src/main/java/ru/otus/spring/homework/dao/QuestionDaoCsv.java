package ru.otus.spring.homework.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import ru.otus.spring.homework.domain.Question;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class QuestionDaoCsv implements QuestionDao, ResourceLoaderAware {

    private ResourceLoader resourceLoader;
    private final String resourcePath;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public List<Question> findAll() {

        try {
            File file = resourceLoader.getResource(resourcePath).getFile();
            List<Question> questions = new CsvToBeanBuilder(new FileReader(file)).withType(Question.class).build().parse();
            return questions;

        } catch (IOException e) {
            System.out.println("Fail");
            return null;
        }
    }

}
