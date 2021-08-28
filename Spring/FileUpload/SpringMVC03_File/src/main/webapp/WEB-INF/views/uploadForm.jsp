<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" enctype="multipart/form-data" action="upload" modelAttribute="uploadFile">
		<h3>업로드할 파일 선택</h3>
		파일: <input type="file" name="file"/>
		<p style="color:red; font-weight:bold;">
		<!-- 문제 발생시 에러메시지를 띄울 부분 ! 에러 바인딩!-->
			<form:errors path="file"/>
		</p>
		설명: <br>
		<textarea name="desc" rows="10" cols="40">
		</textarea>
		<input type="submit" value="업로드 완료">
	</form:form>
</body>
</html>