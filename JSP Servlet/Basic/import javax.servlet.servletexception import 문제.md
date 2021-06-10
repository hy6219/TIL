# import javax.servlet.servletexception import 문제

Oracle12와 11을 사용하다가 충돌이 나면서 두 버전을 모두 삭제하고 다시 11버전을 설치하면서 

멘붕이었는데.. "import javax.servlet.servletexception import" 문제가 발생했다.. 서블릿 전체에

빨간 밑줄이 생겼다 . 찾아보니, 톰캣 서버를 빌드하는 과정 중 식별이 잘 되지 않은 것 같았다

프로젝트에서 우클릭-properties-targetted runtime을 눌러서, 사용하는 톰캣서버 버전을 체크해주자!

https://atoz-develop.tistory.com/entry/The-import-javaxservlet-cannot-be-resolved-%EC%97%90%EB%9F%AC-%ED%95%B4%EA%B2%B0-%EB%B0%A9%EB%B2%95
