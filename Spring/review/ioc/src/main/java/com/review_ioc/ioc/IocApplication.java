package com.review_ioc.ioc;

import com.review_ioc.ioc.dto.ApplicationContextProvider;
import com.review_ioc.ioc.dto.Base64Encoder;
import com.review_ioc.ioc.dto.Encoder;
import com.review_ioc.ioc.dto.UrlEncoder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {

        SpringApplication.run(IocApplication.class, args);

        //0.객체로 관리해주기를 부탁(IoC컨테이너)
        //그러면 컨테이너는 직접 싱글톤으로 관리해주고 객체를 이용할 수 있도록 지원해줌
        //이때 객체를 가져다 사용할 수 있는 방법은 Spring Application Context를 거쳐서
        //사용할 수 있음 ApplicationContextProvider.java 파일 참조(ApplicationContextAware이용)

        //1.ApplicationContext를 이용한 객체 접근 ApplicationContextProvider.java
        //객체 찾기
        ApplicationContext context = ApplicationContextProvider.getContext();
        //빈 찾기-name / class/ name+class로 찾기
        String url ="https://www.naver.com/books/it?page=10&size=20&name=spring-boot";
//        Base64Encoder base64Encoder=context.getBean(Base64Encoder.class);
//        UrlEncoder urlEncoder=context.getBean(UrlEncoder.class);
//        Encoder encoder=new Encoder(base64Encoder);
//
//        String res= encoder.encode(url);

     //   encoder=new Encoder(urlEncoder);
     //   String res2= encoder.encode(url);

//        System.out.println("base64 IoC & DI result:"+res);
       // System.out.println("url IoC & DI result:"+res2);

        //2.아직도 인코더는 개발자가 관리중!
        //객체를 생성받을 수 있는 장소-변수, 생성자, 메서드, setter
        //Encoder에 setter 메서드 추가
        //setter로 객체 주입
//        encoder.setIEncoder(urlEncoder);
//        System.out.println("url IoC & DI result:"+encoder.encode(url));
        //3.인코더도 객체로 등록하기-그러면 이제 ApplicationContext 외의 내용은 우선 주석처리해주어도 무방<-우선으로 할 객체를
        //Encoder.java에서 설정해두었기 때문
      //  Encoder encoder=context.getBean(Encoder.class);
       // System.out.println("Bridge default url, so: "+encoder.encode(url));
        //더이상은 new로 객체를 생성하지 않아도 됨
        //스프링이 객체를 관리하고 있음
        //빈: 스프링 컨테이너에서 관리하는 객체


        //4.그런데 Qualifier를 붙여서 관련 객체 중 하나만
        //사용하지 않고 두개를 모두 사용하고 싶다면?
        //➡Encoder의 Component, Qualifier 어노테이션을 삭제 후
        //application 파일에 빈을 명시하기 위한 클래스 생성
        //이때에는 Component가 아닌, 💛 Configuration어노테이션을 이용해서
        //한 개 이상의 빈을 한 클래스에서 등록할 수 있게 함!
        Encoder encoder= context.getBean("base64",Encoder.class);
        String  base64=encoder.encode(url);
        System.out.println("이제는 Encoder도 new로 관리하지 않을 수 있고, 다형성으로 보다 편하게 객체를 관리!주입도 편하게!-base64: \n"+base64);

        UrlEncoder urlEncoder=(UrlEncoder) context.getBean(UrlEncoder.class);
        //setter로 가져오기 위함
        //"url"로 가져오게 되면 밑에서 Encoder 로 가져오는 것과 충돌할 수 있게 됨
        //Exception in thread "main" java.lang.ClassCastException: com.review_ioc.ioc.dto.Encoder cannot be cast to com.review_ioc.ioc.dto.UrlEncoder
        encoder.setIEncoder(urlEncoder);
        System.out.println("url: "+encoder.encode(url));
    }

}

//4.한 클래스에서 여러개의 빈을 등록
@Configuration
class AppConfig{
    //4-1.Encoder라는 빈이 2개가 생기게 됨
    //따라서 이를 구분하기 위해서 Bean("")로 붙여주기
    //그렇게 되면 기존의 base64Encoder, urlEncoder
    //빈 객체와도 충돌할 일이 없어짐

    //만약 기존 빈 객체와 연결시키고 싶다면
    //4.2 public Encoder encoder(@Qualifier("base64Encoder")~)
    //로 적용해주면 됨!
    @Bean("base64")
    public Encoder encoder(@Qualifier("base64Encoder") Base64Encoder base64Encoder){
        return new Encoder(base64Encoder);
    }

    @Bean("url")
    public Encoder encoder(UrlEncoder urlEncoder){
        return new Encoder(urlEncoder);
    }

}
