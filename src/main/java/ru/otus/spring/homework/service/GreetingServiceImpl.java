package ru.otus.spring.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.homework.domain.User;

import java.util.Scanner;

@Service
public class GreetingServiceImpl implements GreetingService{
    @Override
    public User greet() {
        User user = new User();
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome. Enter your first name");
        user.setFirstName(in.next());
        System.out.println("Welcome. Enter your last name");
        user.setLastName(in.next());
        return user;
    }
}
