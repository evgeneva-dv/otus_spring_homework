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

    @CsvBindByName(column = "question")
    private String textQuestion;

    @CsvBindByName(column = "answer")
    private String variantsAnswer;


}
