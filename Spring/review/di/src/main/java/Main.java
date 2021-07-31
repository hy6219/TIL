import java.net.URLEncoder;

public class Main {
    public static void main(String[] args){

        String url = "https://www.naver.com/books/it?page=10&size=20&name=spring-boot";

        //0.디자인패턴 미적용시
        //Base 64 encoder
//        Base64Encoder base64Encoder=new Base64Encoder();
//        String base64Encoded=base64Encoder.encode(url);
//        System.out.println("Base 64 Encoding result: "+base64Encoded);

        //URL encoding 조건 추가!->클래스 만들기
//        UrlEncoder urlEncoder = new UrlEncoder();
//        String urlEncoded= urlEncoder.encode(url);
//        System.out.println("URL Encoding result: "+urlEncoded);
        //이러면 계속해서 인코더를 조건에 따라 만들어줘야 함
        //1.그래서 추상화를 시켜주기 위해서 인터페이스를 만들기 IEncoder
//        IEncoder base64Encoder=new Base64Encoder();
//        String base64Encoded=base64Encoder.encode(url);
//        System.out.println("Base 64 Encoding result: "+base64Encoded);
//
//        IEncoder urlEncoder = new UrlEncoder();
//        String urlEncoded= urlEncoder.encode(url);
//        System.out.println("URL Encoding result: "+urlEncoded);

        //2.DI를 이용해서 객체 관리를 바꿔주기 Encoder 클래스에서
        Encoder encoder=new Encoder(new Base64Encoder());
        String base64=encoder.encode(url);
        System.out.println("Dependency Injection from main class(base64): "+base64);

        //이제는 Encoder생성자 인자값만 바꿔주면 됨
        encoder=new Encoder(new UrlEncoder());
        String urlE=encoder.encode(url);
        System.out.println("Dependency Injection from main class(url): "+urlE);
        //만약 여기에 Base32와 같은 새로운 인코더를 넣고 싶다면
        //IEncoder를 상속받는 클래스를 만들기만 하면
        //다형성에 의해 객체를 관리하는 Encoder클래스로 해당 객체를 접근할 수 있게 됨

        //3.그런데 아직도 UrlEncoder와 Base64Encoder는 개발자가 관리하고 있음
        //이러한 자식 클래스를 관리하기 위해서 IoC 컨테이너의 도움이 필요하다!
        //새로운 프로젝트 ioc를 만들기로 하자

    }
}
