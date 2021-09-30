package com.webapp6.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class LogAspect {

    public void before(JoinPoint joinPoint){
        System.out.println("method " + joinPoint.getSignature());
    }
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object o = proceedingJoinPoint.proceed();
        long stop = System.currentTimeMillis();
        System.out.println("method " + proceedingJoinPoint.getSignature() + "time " + (stop-start) );
        return o;
    }
}
