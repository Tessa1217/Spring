<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script   
src="https://code.jquery.com/jquery-3.6.0.js"   
integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="   
crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
	
/* 	.modal {
		display: none;
		position: absolute;
		width: 100%;
		height: 100%;
		background: rgba(0, 0, 0, 0.8);
		top: 0;
		left: 0;
	}
	
	.modal_body {
		width: 70%;
		height: 70%;
		margin: 10% auto;
		background: white;
		padding: 3%;
	} */
	
	#insertTable {
		width: 100%;
		margin: 10% auto;
		text-align: center;
	}
	
	#insertTable tr td:first-of-type {
		width: 20%;
	}
	
	#insertTable tr td:last-of-type {	
		width: 70%;
	}
	
	table, tr, th, td {
		border: 1px solid #eee;
	}
	
	th, td {
		padding: 3%;
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
<div style="text-align:center;">
<button type="button" id="modalBtn" class="btn btn-primary" 
data-toggle="modal" data-target="#insertModal">댓글 등록</button>
</div>
<div class="modal fade" id="insertModal" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">댓글 등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <table id="insertTable">
					<thead>
						<tr>
							<th colspan="2">댓글 등록</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>작성자:</td>
							<td><input type="text" name="replyer" id="replyerModal"></td>
						</tr>
						<tr>
							<td>댓글:</td>
							<td><textarea name="reply" id="replyModal"></textarea></td>
						</tr>
					</tbody>
				</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="insertModalBtn">댓글 등록</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>
<script>
	$(function() {
		replyList();
		insertReply();
		updateReply();
		deleteReply();
		modalTest();
		insertViaModal();
		
		function makeReply(obj) {		
			let div = $(`<div></div>`);
			$(div).attr("data-rno", `\${obj.rno}`);
			$(div).append([
				$('<span/>').text(`\${obj.replyer}`),
				$('<span/>').text(`\${obj.reply}`),
				$('<span/>').text(`\${obj.replyDate}`),
				$('<span/>').attr("class", "btnReUpd").append($('<button/>').text('수정').attr("type", "button")),
				$('<span/>').attr("class", "btnReDel").append($('<button/>').text('삭제').attr("type", "button"))
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
							console.log(data);
							//location.reload();
						})
				})
			}
		
		function modalTest() {
			$("#modalBtn").on("click", function() {
				$("#insertModal").css('display', 'block');
			})
		}
		
		function updateReply() {
			let url = "http://localhost/mvc/reply";
			$("#replyList").on("click", ".btnReUpd button", function() {
				let reply = $(this).parent().prev().prev();
				let rno = $(this).parent().parent().data("rno");
				let originalTxt = reply.text();
				reply.text("");
				$(reply).append($("<input/>").attr("id", "revise").val(originalTxt))
				.append($("<button/>").text("수정 완료").attr("type", "button")
				.click(function(){
					$.ajax({
						url : url,
						method : 'PUT',
						data : JSON.stringify({rno : rno, reply : $("#revise").val()}),
						contentType: 'application/json'
					})
						.done(function(result) {
							location.reload();
						})
				}));
			})	
		}
		
		
		function deleteReply() {
			$("#replyList").on("click", ".btnReDel button", function() {
				let div = $(this).parent().parent()
				let url = "http://localhost/mvc/reply/" + div.data("rno");
				console.log(this);
				$.ajax({
					url : url,
					method : 'DELETE'
				})
					.done(function(result) {
						div.remove();
					})
			})
		}
		
		function insertViaModal() {
			$("#insertModalBtn").on("click", function() {
				let url = "http://localhost/mvc/reply";
				$.ajax({
					url : url,
					method : 'POST',
					data : {bno : $("#comment").data("bno"),
									reply : $("#replyModal").val(),
									replyer : $("#replyerModal").val()
									}
				})
					.done(function(data) {
						location.reload();
					})
			})
		}
		
	})
</script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" 
crossorigin="anonymous"></script>
</body>
</html>