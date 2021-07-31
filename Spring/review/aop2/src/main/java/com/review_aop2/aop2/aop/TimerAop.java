package com.review_aop2.aop2.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

@Aspect
@Component//빈은 클래스에 붙일 수 없고, 컴포넌트&configuration만이 클래스에 붙일 수 있음
//configuration은 하나의 클래스에 여러개의 빈을 등록
public class TimerAop {

    @Pointcut("execution(* com.review_aop2.aop2.controller..*.*(..))")
    public void cut(){

    }

    //timer 어노테이션을 적용한 경우에 대해서 적용
    @Pointcut("@annotation(com.review_aop2.aop2.annotation.Timer)")
    public void enableTimer(){

    }

    //전과 후가 따로 있으면 time을 공유할 수 없기 때문에
    //around를 사용(전,후 사이 정보 공유)
    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object res=proceedingJoinPoint.proceed();//실질적인 메서드가 실행되고, object가 반환되는데
        //반환값도 object에 들어가게 됨
        stopWatch.stop();

        System.out.println("total elapsed time: "+stopWatch.getTotalTimeSeconds()+" s");

        MethodSignature methodSignature=(MethodSignature) proceedingJoinPoint.getSignature();
        Method method=methodSignature.getMethod();
        String methodName=method.getName();
        Class returnType=methodSignature.getReturnType();
        Object[] args= proceedingJoinPoint.getArgs();

        for(Object obj:args){
            System.out.println("parameter type: "+obj.getClass().getSimpleName());
            System.out.println("value: "+obj);
        }
        System.out.println("parameter info-args length: "+args.length);
        System.out.println("method: name-"+methodName+", returnType: "+returnType);


    }

}
