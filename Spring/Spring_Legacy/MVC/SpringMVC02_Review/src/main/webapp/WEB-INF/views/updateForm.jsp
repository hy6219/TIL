<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update.do" method="post">
		<input type="hidden" name="myNo" value="${update.myNo }"/>
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="myTitle" value="${update.myTitle }"/></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="myName" value="${update.myName }"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="30" rows="30" name="myContent">${update.myContent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="수정완료" title="이 버튼을 누르시면 모든 내용이 반영됩니다"/>
				<input type="reset" value="취소" />
				<input type="button" value="목록" onclick="list.do"/>
				</td>
			</tr>			
		</table>
	</form>
</body>
</html>