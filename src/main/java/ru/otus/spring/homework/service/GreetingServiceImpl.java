package ru.otus.spring.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.configs.AppProps;
import ru.otus.spring.homework.domain.User;

import java.util.Scanner;

@RequiredArgsConstructor
@Service
public class GreetingServiceImpl implements GreetingService{

    private final MessageSource messageSource;
    private final AppProps props;

    @Override
    public User greet() {
        User user = new User();
        Scanner in = new Scanner(System.in);
        System.out.println(messageSource.getMessage("name.first",null, props.getLocale()));
        user.setFirstName(in.next());
        System.out.println(messageSource.getMessage("name.last",null, props.getLocale()));
        user.setLastName(in.next());
        return user;
    }
}
