package com.fanavard.challenge;

import com.fanavard.challenge.server.ServerApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ServerApplication server = context.getBean(ServerApplication.class);
        server.start(args);
    }
}
