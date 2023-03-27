package ru.otus.spring.homework.utils;

import lombok.experimental.UtilityClass;
import ru.otus.spring.homework.domain.Question;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class TestData {

    public List<Question> provideQuestion () {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(1,"textQuestion", "variantsAnswer", "trueAnswer"));
        return questions;
    }
}
