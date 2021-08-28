<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert.do" method="post">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="myName"/></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="myTitle"/></td>
			</tr>	
			<tr>
				<th>내용</th>
				<td>
					<textarea cols="30" rows="30" name="myContent"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글 등록"/>
					<input type="reset" value="취소" title="작성하신 내용이 모두 지워집니다"/>
					<input type="button" value="목록" onclick="location.href='list.do';">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>