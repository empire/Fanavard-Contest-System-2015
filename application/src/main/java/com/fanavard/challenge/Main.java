package com.fanavard.challenge;

import com.fanavard.challenge.client.ClientApplication;
import com.fanavard.challenge.server.ServerApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        runApplication(args, getApplicationContext());
    }

    private static ApplicationContext getApplicationContext() {
        return new ClassPathXmlApplicationContext("spring-config.xml");
    }

    private static void runApplication(String[] args, ApplicationContext context) {
        getApplication(args, context).run();
    }

    private static Runnable getApplication(String[] args, ApplicationContext context) {
        return context.getBean(getApplicationClass(args));
    }

    private static Class<? extends Runnable> getApplicationClass(String[] args) {
        return isServerSelected(args) ?
                getServerApplicationClass() :
                getClientApplicationClass();
    }

    private static Class<ClientApplication> getClientApplicationClass() {
        return ClientApplication.class;
    }

    private static Class<ServerApplication> getServerApplicationClass() {
        return ServerApplication.class;
    }

    private static boolean isServerSelected(String[] args) {
        return args.length != 0;
    }
}
