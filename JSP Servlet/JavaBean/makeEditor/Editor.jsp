<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="./main.css">
</head>
<body>
	<header>
		<h1>게시판 글쓰기</h1>
	</header>
	<section>
		<article>
			<form action="ArticleInfo.jsp" method="post">
				<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="author"id="author"autocomplete="off"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pwd"id="pwd"><span>(게시물 수정 삭제시 필요합니다)</span>
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email" id="email"></td>
				</tr>
				<tr>
					<th>글 제목</th>
					<td><input type="text" name="title" id="title"></td>
				</tr>
				<tr>
					<th>글 내용</th>
					<td><textarea cols="50" rows="10" name="contents"></textarea></td>
				</tr>
			</table>
			<div class="btn">
				<input type="submit" value="등록">
				<input type="reset" value="다시 작성">
			</div>
			</form>
		</article>
	</section>
</body>
</html>
