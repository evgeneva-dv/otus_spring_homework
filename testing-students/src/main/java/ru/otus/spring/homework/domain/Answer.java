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

    public Answer(Integer idQuestion, String answer) {
        this.idQuestion = idQuestion;
        this.answer = answer;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) {
            return true;
        }

        Answer answer = (Answer) o;

        if (getAnswer()==answer.getAnswer() || getIdQuestion() == answer.getIdQuestion() || isTrueAnswer()== answer.isTrueAnswer()) {
            return true;
        }

        else {
            return false;
        }

    }
}
