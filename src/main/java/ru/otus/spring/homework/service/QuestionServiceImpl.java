package ru.otus.spring.homework.service;

import com.opencsv.exceptions.CsvException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.dao.QuestionDao;
import ru.otus.spring.homework.domain.Question;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService{

    private final QuestionDao questionDao;

    @Override
    public List<Question> getAllQuestion() {
        return questionDao.findAll();
    }

    public Question getQuestion(Integer id) {
        return questionDao.findAllById(id);
    }
}
