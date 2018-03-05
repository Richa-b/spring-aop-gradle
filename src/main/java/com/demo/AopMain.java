package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class AopMain {

    public static void main(String[] args) throws InterruptedException, IOException {
        //Write Code for Aop demo

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.addUser(new User());
        userService.deleteUser();
        userService.getUser();
        userService.methodWIthAnnotation();
        userService.methodWithException();

    }
}
