## JSP/SERVLET 설정 방법

1. 새 프로젝트 생성
2. 왼쪽 윈도우의 프로젝트 바에서 프로젝트명 우클릭
3. Add Framework Support 선택
4. Java EE- Web Services 선택
5. Version-Apache 선택
6. 후에 있을 톰캣서버 디렉토리 입력을 위해 디렉토리를 파일 익스플로러에서 복사
7. OK 누르고 플러그인 설치는 NO누르기
8. 상단에 뜨는 도구바에(혹시 이전에 다른 설정 관련해서 configuration 설정을 한 적이 있다면, 망치모양 옆의 드롭다운 메뉴를 눌러서 edit configuration) add configuration 선택
9. Server 탭에서는 다른 것은 건드리지 않고, http 프로토콜을 위한 포트번호만 설정
10. 하단의 fix 버튼 클릭
11. 그러면 Run/Debug Configurations 윈도우가 보임
12. 거기에서 왼쪽 섹션에 있는 +를 클릭
13. Tomcat Server-local 선택
14. 하단에 컨텍스트 패스를 설정하기 위한 application context를 수정하고 싶다면, 수정
15. OK 누르기
16. 최상단 네비게이션바에서 File- Project Structure-Libraries
17. 세 개의 섹션 중 두번째 섹션의 + 누르기
18. Java 선택
19. 톰캣서버가 설치된 디렉토리를 입력
20. 아직 다음으로 넘어가지 말고, 하위 디렉토리인 lib 클릭
21. servlet-api.jar 선택
22. OK 
23. web.xml 파일 내용을 아래와 같이 수정

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0"
         metadata-complete="false">

</web-app>
```