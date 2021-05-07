<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean class="com.mission.javabeans.MovieBean" id="movie"/>
<jsp:setProperty name="movie" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 처리 페이지</title>
</head>
<body>
	<header>
		<h1>입력 완료된 정보</h1>
	</header>
	<section>
		<article>
			<table>
				<tr>
					<th>제목</th>
					<td><jsp:getProperty name="movie" property="title"/></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><jsp:getProperty name="movie" property="price"/>원</td>
				</tr>
				<tr>
					<th>감독</th>
					<td><jsp:getProperty name="movie" property="director"/></td>
				</tr>
				<tr>
					<th>시놉시스</th>
					<td>
						<textarea cols="50" rows="10">
							<jsp:getProperty name="movie" property="synopsis"/>
						</textarea>
					</td>
				</tr>
				<tr>
					<th>장르</th>
					<td><jsp:getProperty name="movie" property="genre"/></td>
				</tr>
			</table>
		</article>
	</section>
</body>
</html>
