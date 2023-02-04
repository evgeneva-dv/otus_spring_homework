package ru.otus.spring.homework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Answer {
    private Integer idQuestion;
    private String answer;
    private boolean isTrueAnswer;

}
