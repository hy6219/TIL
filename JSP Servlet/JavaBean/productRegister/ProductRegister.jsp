<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 입력 폼</title>
</head>
<body>
	<header>
		<h1>정보 입력 폼</h1>
	</header>
	<section>
		<article>
			<form action="ProductInfo.jsp" method="post">
				<table>
					<tr>
						<th>상품명</th>
						<td>
							<input type="text" name="pName" id="pName"autocomplete="off">
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>
							<input type="text" name="price" id="price"autocomplete="off">
						</td>
					</tr>
					<tr>
						<th>설명</th>
						<td>
							<textarea cols="50" rows="10"name="exp"></textarea>
						</td>
					</tr>
				</table>
				<div class="btn">
					<input type="submit" value="전송">
					<input type="reset" value="취소">
				</div>
			</form>
		</article>
	</section>
</body>
</html>
