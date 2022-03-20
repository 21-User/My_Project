package com.fc.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//注解声明一个切面类
@Aspect
@Component
public class AnnotationAspect {
    @Pointcut("execution(* com.fc.service.impl.*ServiceImpl.*(..))")
    public static void pointcut() {}

    @Before("AnnotationAspect.pointcut()")
    public void before() {
        System.out.println("前置通知，目标方法调用之前执行");
    }

    @AfterReturning("AnnotationAspect.pointcut()")
    public void afterReturning() {
        System.out.println("后置通知，目标方法运行之后调用（如果出现异常不会调用）");
    }

    @AfterThrowing("AnnotationAspect.pointcut()")
    public void afterThrowing() {
        System.out.println("异常通知，出现异常调用");
    }

    @After("AnnotationAspect.pointcut()")
    public void after() {
        System.out.println("最终通知，在目标方法运行之后调用（无论是否出现异常）");
    }

    @Around("AnnotationAspect.pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("环绕通知，目标方法之前会调用(ProceedingJoinPoint对象 -->> 调用proceed方法)");

        Object proceed = joinPoint.proceed();

        System.out.println("环绕通知，目标方法之后会调用(ProceedingJoinPoint对象 -->> 调用proceed方法)");

        return proceed;
    }

}
