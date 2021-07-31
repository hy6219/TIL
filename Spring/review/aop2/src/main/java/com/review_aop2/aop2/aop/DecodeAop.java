package com.review_aop2.aop2.aop;

import com.review_aop2.aop2.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

//decode aop는 암호화 혹은 특정 파트너사만의 요청에 대응할 수 있음
@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.review_aop2.aop2.controller..*.*(..))")
    public void cut(){

    }

    @Pointcut("@annotation(com.review_aop2.aop2.annotation.Decode)")
    public void enableDecode(){

    }
    //전은 디코딩, 후는 인코딩할 것
    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {

        Object[] args= joinPoint.getArgs();

        for(Object obj:args){
            if(obj instanceof User){
                User user= User.class.cast(obj);
                String base64Email=user.getEmail();
                //decode
                String decoded = new String(Base64.getDecoder().decode(base64Email.getBytes()),"utf-8");
                user.setEmail(decoded);
            }
        }

    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        //인코딩
        if(returnObj instanceof User){
            User user = User.class.cast(returnObj);
            String email=user.getEmail();
            //인코딩
            String encoded=Base64.getEncoder().encodeToString(email.getBytes());
            user.setEmail(encoded);
        }
    }
}
