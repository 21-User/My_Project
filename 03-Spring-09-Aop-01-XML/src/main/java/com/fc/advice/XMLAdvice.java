package com.fc.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class XMLAdvice {
    public void before() {
        System.out.println("前置通知，目标方法调用之前执行");
    }

    public void afterReturning() {
        System.out.println("后置通知，目标方法运行之后调用（如果出现异常不会调用）");
    }

    public void afterThrowing() {
        System.out.println("异常通知，出现异常调用");
    }

    public void after() {
        System.out.println("最终通知，在目标方法运行之后调用（无论是否出现异常）");
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("环绕通知，目标方法之前会调用(ProceedingJoinPoint对象 -->> 调用proceed方法)");

        Object proceed = joinPoint.proceed();

        System.out.println("环绕通知，目标方法之后会调用(ProceedingJoinPoint对象 -->> 调用proceed方法)");

        return proceed;
    }

}
