package com.fanavard.challenge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ClientApplication client = context.getBean(ClientApplication.class);
        System.out.println(client);
    }
}
