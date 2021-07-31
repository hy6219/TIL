package com.review_aop.aop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {
//post에만 적용
    //@Pointcut("execution(* com.review_aop.aop.controller..post(..))")
    //모든 메서드에 적용
    @Pointcut("execution(* com.review_aop.aop.controller..*.*(..))")
    public void cut(){

    }

    //cut메서드 전에!그리고 cut은 controller의 모든 메서드에 적용!
    @Before("cut()")
    public void before(JoinPoint joinPoint){
        Object[] args= joinPoint.getArgs();
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Class returnType=methodSignature.getReturnType();

        for(Object obj:args){
            System.out.println("argument type: "+obj.getClass().getSimpleName());
            System.out.println("value: "+obj);
        }
        System.out.println("method: "+method.getName());
        System.out.println("return: "+returnType);

    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturning(JoinPoint joinPoint, Object returnObj){

        System.out.println("return obj:"+returnObj);
    }
}
