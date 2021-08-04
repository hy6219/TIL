package com.example.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AppConfig {

    @Bean("async-thread")
    public Executor asyncThread(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor=
                new ThreadPoolTaskExecutor();

        threadPoolTaskExecutor.setMaxPoolSize(100);
        threadPoolTaskExecutor.setCorePoolSize(10);//core pool 10개를 다 쓰게 되면 큐로 넘어감
        //그러다가 큐도 다 차면, core는 인자값으로 넣어준 크기만큼 또 생김
        threadPoolTaskExecutor.setQueueCapacity(10);
        threadPoolTaskExecutor.setThreadNamePrefix("Asnyc-");
        return threadPoolTaskExecutor;
    }
}
