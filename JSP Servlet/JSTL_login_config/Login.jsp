<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<fmt:requestEncoding value="UTF-8"/>
	<c:set var="id" value="${param.id }" scope="session"></c:set>
	<c:set var="pwd" value="${param.pwd }" scope="session"></c:set>
	<c:set var="config" value="${param.config }" scope="session"></c:set>
	<c:choose>
		<c:when test="${param.config.equals('사용자') }">
			<%-- <c:redirect url="User.jsp"></c:redirect> --%>
			<script type="text/javascript">
				window.open("./User.jsp","_blank","width=600px, height=300px");
			</script>
		</c:when>
		<c:when test="${param.config.equals('관리자') }">
			<%-- <c:redirect url="Admin.jsp"></c:redirect> --%>
			<script type="text/javascript">
				window.open("./Admin.jsp","_blank","width=600px, height=300px");
			</script>
		</c:when>
	</c:choose>
</body>
</html>
