package com.demo;


import org.springframework.stereotype.Component;

@Component
public class UserService {


    public void testMethod(String user) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        testMethod1(user);
        System.out.println("==== TEst MEthod Called =====");
    }

    public void testMethod1(String user) {
        System.out.println("==== TEst MEthod 1 Called =====");
    }
}
