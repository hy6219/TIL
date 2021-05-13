<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자페이지</title>
</head>
<body>
	<fmt:requestEncoding value="UTF-8"/>
	<c:out value="${id }님 ${config }로 로그인하셨습니다"></c:out>
	<c:out value="5초 후 네이버로 이동합니다"></c:out>
	<script src="./user.js"></script>
</body>
</html>
