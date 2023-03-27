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
    private final IOService ioService;

    @Override
    public User greet() {
        User user = new User();
        ioService.out(messageSource.getMessage("name.first",null, props.getLocale()));
        user.setFirstName(ioService.readString());
        ioService.out(messageSource.getMessage("name.last",null, props.getLocale()));
        user.setLastName(ioService.readString());
        return user;
    }
}
