package com.example.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
//@Component
@WebFilter(urlPatterns = "/api/user")
public class GlobalFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //전처리
        ContentCachingRequestWrapper httpServletRequest= new ContentCachingRequestWrapper((HttpServletRequest) request);//길이만 초기화
        ContentCachingResponseWrapper httpServletResponse=new ContentCachingResponseWrapper((HttpServletResponse)response);

//        //body읽어오기
//        BufferedReader br=httpServletRequest.getReader();
//
//        br.lines().forEach(line->{
//            log.info("uri: {}, read content: {}",uri,line);
//        });

        chain.doFilter(httpServletRequest, httpServletResponse);
        //후처리
        String uri= httpServletRequest.getRequestURI();
        String reqContent=new String(httpServletRequest.getContentAsByteArray());

        log.info("요청 uri:{}, reqeust body:{}",uri,reqContent);

        String resContent=new String(httpServletResponse.getContentAsByteArray());
        int httpStatusCode=httpServletResponse.getStatus();
        httpServletResponse.copyBodyToResponse();
        log.info("response status:{}, response body:{}",httpStatusCode,resContent);
    }
}
