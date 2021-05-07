<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>정보 등록</h1>
	</header>
	<section>
		<article>
			<form action="movieWrite.jsp" method="post">
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" id="title"autocomplete="off"></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="text" name="price" id="price"autocomplete="off"><span>원</span></td>
					</tr>
					<tr>
						<th>감독</th>
						<td><input type="text" name="director" id="director"autocomplete="off"></td>
					</tr>
					<tr>
						<th>시놉시스</th>
						<td>
							<textarea cols="50"rows="10"name="synopsis"></textarea>
						</td>
					</tr>
					<tr>
						<th>장르</th>
						<td>
							<select name="genre">
								<option value="액션">액션</option>
								<option value="스릴러">스릴러</option>
								<option value="코미디">코미디</option>
								<option value="애니메이션">애니메이션</option>
								<option value="로맨스">로맨스</option>
								<option value="미스터리">미스터리</option>
							</select>
							<input type="submit" value="확인">
							<input type="reset" value="취소" title="누르시면 모든 입력값이 지워집니다">
						</td>
					</tr>
				</table>
			</form>
		</article>
	</section>
</body>
</html>
