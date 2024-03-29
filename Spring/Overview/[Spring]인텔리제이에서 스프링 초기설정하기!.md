# 인텔리제이 초기 환경 설정

나는 먼저 기존에 진행하는 플젝에서 Amazon Corretto 8을 jdk로 사용하고 있어서, 버전충돌이 일어나지 않을까 (환경변수 편집을 할때마다 해야할 것 같아서) 걱정되어서 jdk8을 이용했다

하지만 나중에는 jdk11을 이용해볼 것인데, 그 이유는 11을 이용할때 코드작성이 보다 간결해질 수 있다는 말을 들었기 때문에 테스트해보고 싶어서이다!

우선 jdk가 설치되어 있지 않다면 설치부터 해야한다!(최소 8부터 지원되는 듯하다)

1. 그다음에는 spring initializer를 누르고!(여기서부터 중요하다!)
2. lombok과 spring web을 체크하고
3. gradle, java language, jar, 폴더위치를 꼼꼼히 확인하고 체크한다!
4. 그리고 이건 swagger가 잘 작동하는지 보기 위함인데
- 구글에 maven repository를 검색
-[https://mvnrepository.com](https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter/3.0.0) 에서 mavenfox검색
-Springfox Boot Starter 선택
-3.0.0  누르고-gradle 탭 선택 시 나오는 값을 복사
-build.gradle에 내용 붙여넣기

```java
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    // https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter
    implementation group: 'io.springfox', name: 'springfox-boot-starter', version: '3.0.0'
}
```

그러면 위의 파일에서 롬복과 swagger를 설정해준 것을 확인해볼 수 있다

5. gradle 새로고침 해주기(코드창에 공룡모양이 나타난다! 귀여워..!!)

그러면 우측 메뉴의 gradle에 dependency가 잘 설정되었는지 확인해볼 수 있다!

![https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/Spring/Overview/gradle%20%EC%B4%88%EA%B8%B0%20%EC%84%A4%EC%A0%95%20%ED%99%95%EC%9D%B8.PNG?raw=true](https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/Spring/Overview/gradle%20%EC%B4%88%EA%B8%B0%20%EC%84%A4%EC%A0%95%20%ED%99%95%EC%9D%B8.PNG?raw=true)

spring gradle dependency 설정 확인

6. 진짜 잘 붙여진건지 확인해보자

src/main/~Application.java 를 실행시키고,

[http://localhost:(설정한 포트번호)/swagger-ui/](http://localhost:8085/swagger-ui/) 

를 브라우저에 입력해주자!

반드시 swagger-ui뒤에 /를 붙여주어야 한다!!

아래의 화면이 보인다면, 성공!

![https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/Spring/Overview/%EC%9D%B8%ED%85%94%EB%A6%AC%EC%A0%9C%EC%9D%B4%20%EC%8A%A4%ED%94%84%EB%A7%81%20%EC%B4%88%EA%B8%B0%EC%84%B8%ED%8C%85%20-%20swagger.PNG?raw=true](https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/Spring/Overview/%EC%9D%B8%ED%85%94%EB%A6%AC%EC%A0%9C%EC%9D%B4%20%EC%8A%A4%ED%94%84%EB%A7%81%20%EC%B4%88%EA%B8%B0%EC%84%B8%ED%8C%85%20-%20swagger.PNG?raw=true)

spring 초기환경 설정- swagger

그리고 컨트롤러 및 dto 객체와 관련해서 APIController가 위에서 확인되는데, try-it- out을 누르고 값을 입력해보고, execute해본 다음에 200 코드와 함께 값을 잘 받아옴을 확인해볼 수 있었다!

![https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/Spring/Overview/spring%20%EC%B4%88%EA%B8%B0%ED%99%98%EA%B2%BD%EC%84%A4%EC%A0%95-swagger%20test.gif?raw=true](https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/Spring/Overview/spring%20%EC%B4%88%EA%B8%B0%ED%99%98%EA%B2%BD%EC%84%A4%EC%A0%95-swagger%20test.gif?raw=true)

🌟 포트 설정 방법

[https://ekgoddldi.tistory.com/36](https://ekgoddldi.tistory.com/36)

방법 1.  src/main/resources의 application.properties에

server.port=포트번호

기입해주기

방법 2. 네비게이션 메뉴에서 run- edit configurations 선택

Configuration 탭에서 environment 토글- environment variables 옆의 input 란에 server.port=포트번호를 입력!!
