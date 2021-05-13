<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="Login.jsp" method="post">
		<div class="id">
			<label> 아이디:
				<input type="text" name="id" required>
			</label>
		</div>
		<div class="pwd">
			<label> 비밀번호:
				<input type="password" name="pwd" required>
			</label>
		</div>
		<div class="config">
			<label>
				<input type="radio" name="config" value="사용자">사용자
			</label>
			<label>
				<input type="radio" name="config" value="관리자">관리자
			</label>
		</div>
		<input type="submit" value="로그인">
	</form>
</body>
</html>
