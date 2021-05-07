<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean class="com.jisoo.javabeans.ArticleBean" id="article" scope="session"/>
<jsp:setProperty name="article" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 정보 확인하기</title>
</head>
<body>
	<header>
		<h1>입력 완료된 정보</h1>
	</header>
	<section>
		<article>
			작성자: <jsp:getProperty name="article" property="author"/><br>
			비밀번호: <jsp:getProperty name="article" property="pwd"/><br>
			이메일 : <jsp:getProperty name="article" property="email"/><br>
			글제목 : <jsp:getProperty name="article" property="title"/><br>
			글 내용: <jsp:getProperty name="article" property="contents"/><br>
		</article>
	</section>
</body>
</html>
