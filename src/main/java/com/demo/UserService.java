package com.demo;


import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserService {


    public void addUser(User user) {

        System.out.println("Adding New User");
    }


    public void deleteUser() {

        System.out.println("Removing existing User");
    }


    public User getUser() throws InterruptedException {
        System.out.println("Get User");
        Thread.sleep(3000);
        return new User("A", "B");
    }

    @Deprecated
    public void methodWIthAnnotation() {

    }


    public void methodWithException() throws IOException {

        // After Throwing advice wont be called in this case
        /*try {*/

            throw new IOException();
        /*} catch (Exception e) {
            e.printStackTrace();
        }*/

    }

}
