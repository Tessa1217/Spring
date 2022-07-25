<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#boardDetail {
		width: 80%;
		margin: 0 auto;
		border: 1px solid #eee;
		padding: 7%;
	}
	
	#comment {
		width: 80%;
		margin: 0 auto;
		padding: 5%;
	}
	#header {
		list-style:none;
		float:right;
	}
	
	#header li {
		display: inline-block;
	}
	
	#boardInfo {
		clear: both;
		padding: 3%;
	}
	
	#comment form {
		width: 90%;
		margin: 0 auto;
	}
	
	#replyList {
		width: 100%;
		margin: 3% auto;
	}
	
	#replyList div span {
		display: inline-block;
		border: 1px solid #eee;
	}
	
	#replyList div span:first-of-type {
		width: 15%;
		text-align: center;
	}
	#replyList div span:nth-of-type(2) {
		width: 40%;
	}
	#replyList div span:nth-of-type(3) {
		width: 15%;
		text-align: center;
	}
	#replyList div span:nth-of-type(4),
	#replyList div span:last-of-type {
		width: 10%;
		text-align: center;
	}
	
	form {
		border: 1px solid #eee;
		padding: 5%;
		margin-bottom: 2%;
	}
	
	form input, textarea {
		width: 90%;
	}
	
</style>
</head>
<body>
<div id="boardDetail">
	<div>
	<h3>게시판 상세보기</h3>
	<ul id="header">
		<li>작성자 ${board.writer}</li>
		<li>작성일 ${board.regdate}</li>
	</ul>
	</div>
	<div id="boardInfo">
		<p>${board.title}</p>
		<div>
			${board.content}
		</div>
	</div>
</div>
<div id="comment" data-bno="${board.bno}">
	<form action="/reply" method="POST">
		<div>
			<label for="replyer">작성자: </label><input type="text" id="replyer" name="replyer">
		</div>
		<div>
			<label for="reply">댓글: </label><textarea name="reply" id="reply"></textarea>
		</div>
		<button type="button" id="insertBtn">댓글 등록</button>
	</form>
	<div id="replyList">
		<div>
			<span>작성자</span>
			<span>댓글</span>
			<span>작성 일시</span>
			<span>수정</span>
			<span>삭제</span>
		</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
<script>
	$(function() {
		
		replyList();
		insertReply();
		updateReply();
		//deleteReply();
		
		function makeReply(obj) {		
			let div = $(`<div></div>`);
			$(div).attr("data-rno", `\${obj.rno}`);
			$(div).append([
				$('<span/>').text(`\${obj.replyer}`),
				$('<span/>').text(`\${obj.reply}`),
				$('<span/>').text(`\${obj.replyDate}`),
				$('<span/>').html(`<button type="button">수정</button>`).attr("class", "btnReUpd"),
				$('<span/>').html(`<button type="button">삭제</button>`).attr("class", "btnReDel")
				
			])
			$("#replyList").append(div);
		}
		function replyList() {
			let url = "http://localhost/mvc/reply"
			$.ajax({
				url : url,
				data : {bno : $("#comment").data("bno")},
				dataType : "json"
				})
				.done(function(dataList) {	
					for (let data of dataList) {
						makeReply(data);
					}
				})
		}
		function insertReply() {
			$("#insertBtn").on("click", function() {
				let url = "http://localhost/mvc/reply";
					$.ajax({
						url : url,
						method : 'POST',
						data : {bno : $("#comment").data("bno"),
										reply : $("#reply").val(),
										replyer : $("#replyer").val()
										}
					})
						.done(function(data) {
							location.reload();
						})
				})
			}
		
		function updateReply() {
			$(".btnReUpd").on("click", function() {
				console.log(this);
			})	
		}
		
		function deleteReply() {
			
		}
	})
</script>
</body>
</html>