package ru.otus.spring.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.spring.homework.service.MainService;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        var context = SpringApplication.run(Main.class, args);

        var mainService =  context.getBean(MainService.class);

        mainService.run();

    }
}
