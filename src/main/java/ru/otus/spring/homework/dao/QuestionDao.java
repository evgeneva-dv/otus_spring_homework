package ru.otus.spring.homework.dao;

import ru.otus.spring.homework.domain.Question;
import java.util.List;

public interface QuestionDao {
    List<Question> findAll();
    Question findAllById(Integer Id);
}
