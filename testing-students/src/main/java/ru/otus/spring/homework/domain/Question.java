package ru.otus.spring.homework.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Question implements Serializable {

    @CsvBindByName(column = "id")
    private Integer id;

    @CsvBindByName(column = "question")
    private String textQuestion;

    @CsvBindByName(column = "answers")
    private String variantsAnswer;

    @CsvBindByName(column = "trueAnswer")
    private String trueAnswer;

}
