<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean class="com.jisoo.javabeans.ProductBean" id="pr"/>
<jsp:setProperty property="*" name="pr"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 확인하기</title>
</head>
<body>
	<header>
		<h1>입력 완료된 정보</h1>
	</header>
	<section>
		<article>
			<div class="pName">
				<span>상품명: <jsp:getProperty name="pr" property="pName"/></span>
			</div>
			<div class="price">
				<span>가격: <jsp:getProperty name="pr" property="price"/></span>
			</div>
			<div class="exp">
				<span>설명: <jsp:getProperty name="pr" property="exp"/></span>
			</div>
		</article>
	</section>
</body>
</html>
