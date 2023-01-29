package ru.otus.spring.homework.service;

import com.opencsv.exceptions.CsvException;
import lombok.AllArgsConstructor;
import ru.otus.spring.homework.dao.QuestionDao;
import ru.otus.spring.homework.domain.Question;

import java.util.List;

@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService{

    private final QuestionDao questionDao;

    @Override
    public List<Question> getAllQuestion() {
        return questionDao.findAll();
    }
}
