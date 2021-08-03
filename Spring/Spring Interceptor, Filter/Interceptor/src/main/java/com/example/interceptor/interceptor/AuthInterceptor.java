package com.example.interceptor.interceptor;

import com.example.interceptor.annotation.Auth;
import com.example.interceptor.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();
        boolean hasAnnotation=checkAnnotation(handler, Auth.class);

        URI u = UriComponentsBuilder.fromUriString(uri)
        .query(request.getQueryString())
        .build()
        .toUri();

        log.info("request uri: {}",uri);
        log.info("uri info: {}",u);
        if(hasAnnotation){
            //권한 검증
            String query=u.getQuery();
            log.info("query: {}",query);
            if(query.equals("name=steve")){

                return true;
            }
          //  return false;
            throw new AuthException();
        }
        //기본은 public
        return true;
    }

    //어노테이션이 달려있는지 볼 것
    //clazz는 class가 예약어이기 때문에 자주 대체재로써 사용되는 이름
    //Class로 어노테이션 확인
    private boolean checkAnnotation(Object handler,
                                    Class clazz){
        //리소스(html,js 등)에 대한 요청은 무조건 통과
        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }

        //어노테이션이 달려있는지
        HandlerMethod handlerMethod=(HandlerMethod) handler;

        if(handlerMethod.getMethodAnnotation(clazz)!=null ||
           handlerMethod.getBeanType().getAnnotation(clazz)!=null){
            //어노테이션을 갖고 있는지 체크
            return true;//auth가 있을 때
        }
        return false;//모든 조건에 부합한 경우

    }
}
