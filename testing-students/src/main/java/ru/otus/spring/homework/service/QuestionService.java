package ru.otus.spring.homework.service;

import com.opencsv.exceptions.CsvException;
import ru.otus.spring.homework.domain.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionService {

    List<Question> getAllQuestion();
}
