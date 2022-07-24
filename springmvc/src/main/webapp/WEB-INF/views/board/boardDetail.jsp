<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	ul {
		list-style:none;
		float:right;
	}
</style>
</head>
<body>
<div>
	<div>
	<h3>게시판 상세보기</h3>
	<ul>
		<li>작성자 ${board.writer}</li>
		<li>작성일 ${board.regdate}</li>
	</ul>
	</div>
	<div>
		<p>${board.title}</p>
		<div>
			${board.content}
		</div>
	</div>
</div>
</body>
</html>