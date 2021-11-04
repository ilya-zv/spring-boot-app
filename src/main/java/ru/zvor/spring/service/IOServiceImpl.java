package ru.zvor.spring.service;

import org.springframework.stereotype.Component;

@Component
public class IOServiceImpl implements IOService {
    @Override
    public void read() {

    }

    @Override
    public void whrite(String text) {
        System.out.println(text);
    }
}
