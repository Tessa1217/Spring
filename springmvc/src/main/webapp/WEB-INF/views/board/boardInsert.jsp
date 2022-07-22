<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시물 작성</h3>
<form action="boardInsert" method="post">
	<div>
	<label for="title">게시물 제목</label>
	<input type="text" name="title">
	</div>
	<div>
	<label for="content">게시물 내용</label>
	<input type="text" name="content">
	</div>
	<div>
	<label for="writer">게시물 작성자</label>
	<input type="text" name="writer">
	</div>
	<button>게시물 등록</button>
</form>
</body>
</html>