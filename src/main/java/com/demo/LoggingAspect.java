package com.demo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.demo.UserService.addUser(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    @After("execution(* del*(..)) || annotatedWithAnnotation()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("logAfter() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }


    @Before("annotatedWithAnnotation()")
    public void logBeforeAnnotatedMethods(JoinPoint joinPoint) {
        System.out.println("logBeforeAnnotatedMethods() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    @Pointcut("@annotation(java.lang.Deprecated)")
    private void annotatedWithAnnotation() {

    }

    @AfterReturning(value = "execution(* *.getUser())", returning = "returnedValue")
    public void logAfterReturning(JoinPoint joinPoint, User returnedValue) {
        System.out.println("In After Returning Advice");
        System.out.println("returned Value::" + returnedValue);

    }


    @AfterThrowing(value = "execution(* *.methodWithException())", throwing = "exception")
    public void logAfterReturning(JoinPoint joinPoint, Throwable exception) {
        System.out.println("In After Throwing Advice");

    }

    @Before("execution(* com.demo.UserService.*(..))")
    public void loggingJoinPointDetails(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());
        System.out.println(joinPoint.getArgs());
    }
}
