package com.demo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {



    @After("execution(* com.demo.UserService.*(..))")
    public void logAfter(JoinPoint joinPoint){
        System.out.println(joinPoint.getArgs());
        System.out.println(joinPoint.getSignature());
        System.out.println("Called After MEthod");
    }


    @Before("execution(* com.demo.UserService.*(..))")
    public void logBefore(){
        System.out.println("Called Before MEthod");
    }


    @AfterThrowing("execution(* com.demo.UserService.*(..))")
    public void logAfterThrowing(){
        System.out.println("Called When Exception Occurs MEthod");
    }


    @Around("execution(* com.demo.UserService.*(..))")
    public void getExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        // Method Exceute
        proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        System.out.println("Exceution time in ms"  + (end -start));
    }


}



