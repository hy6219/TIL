<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>게시글 번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="4">===작성된 글이 없습니다===</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list }" var="iter">
						<tr>
							<td>${iter.myNo}</td>
							<td>${iter.myName }</td>
							<td><a href="detail.do?myNo=${iter.myNo }">${iter.myTitle }</a></td>
							<td>${iter.myDate }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					<input type="button" value="글 작성" onclick="location.href='insertForm.do';"/>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>