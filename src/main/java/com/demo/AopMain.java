package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {


    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");

        System.out.println(userService);
        userService.testMethod("Test");

    }


}
