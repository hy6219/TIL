package com.example.interceptor.config;

import com.example.interceptor.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //하나의 클래스에서 여러 개의 빈 등록, 관리 or 하나의 클래스 안에서 메서드 등으로 빈 등록
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");
    }
}
