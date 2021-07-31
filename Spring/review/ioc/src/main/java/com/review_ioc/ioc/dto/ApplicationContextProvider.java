package com.review_ioc.ioc.dto;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//1.ApplicationContext를 이용한 객체 접근을 위함
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    //1.ApplicationContext를 이용한 객체 접근을 위함
    //이때 context는 스프링이 주입해줄 것
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }

    //applicationcontext를 반환
    public static ApplicationContext getContext(){
        return context;
    }

}
