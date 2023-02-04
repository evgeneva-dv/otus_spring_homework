package ru.otus.spring.homework.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.spring.homework.domain.Question;
import ru.otus.spring.homework.service.QuestionResourceLoader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionDaoCsv implements QuestionDao {

    private final QuestionResourceLoader questionResourceLoader;

    @Override
    public List<Question> findAll() {

        try {
            File file = questionResourceLoader.getFile();
            List<Question> questions = new CsvToBeanBuilder(new FileReader(file)).withType(Question.class).build().parse();
            return questions;

        } catch (IOException e) {
            System.out.println("Fail");
            return null;
        }
    }

    @Override
    public Question findAllById(Integer id) {
        List<Question> questions = findAll();
        Question question = questions.stream().filter(q -> id.equals(q.getId())).findFirst().orElse(null);
        return question;
    }

}
