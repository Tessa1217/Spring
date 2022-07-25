<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form {
		width: 80%;
		margin: 3% auto;
	}
</style>
</head>
<body>
<h3>게시물 수정</h3>
<form action="boardUpdate" method="post">
	<input type="hidden" name="bno" value="${board.bno}"/>
	<div>
	<label for="title">게시물 제목</label>
	<input type="text" name="title" value="${board.title}">
	</div>
	<div>
	<label for="content">게시물 내용</label>
	<input type="text" name="content" value="${board.content}">
	</div>
	<div>
	<label for="writer">게시물 작성자</label>
	<input type="text" name="writer" value="${board.writer}" readonly>
	</div>
	<button>게시물 등록</button>
	<button type="button" onclick="location.href='boardDelete?bno=${board.bno}'">게시물 삭제</button>
</form>
</body>
</html>