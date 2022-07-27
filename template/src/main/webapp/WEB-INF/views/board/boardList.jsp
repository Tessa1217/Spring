<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"
	rel="stylesheet" />
<script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<script>
/* 		$(function() {
			$("#boardTable").DataTable({
				paging: true,
				searching: false,
				ordering: true
			});
		}) */
		
		$(function() {
			// select option
			$('[name="type"]').val('${cri.type}');
			
			// 모달 객체
			const myModal = new bootstrap.Modal('#myModal', {});
			// 모달 찾기
			const modal = document.getElementById("myModal");
			// 수정 또는 삭제에 성공할 경우
			let result = "<c:out value='${result}'/>";
			if (result != '') {
				myModal.show(modal);
				$('#message').html(result);
			}			
		})
		
		// 페이지 이동
		function goPage(num) {
			$('#type').val('${cri.type}').prop("selected", true);
			searchFrm.pageNum.value = num;
			searchFrm.submit(); 
		}
		
		// 값 초기화
		function removeVal() {
			$('input[name=keyword]').val('');
			$('[name="type"]').val("");
		}
		
	</script>
	<!-- 요청 결과 Modal -->
	<div class="modal fade" id="myModal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="myModalLabel">요청 결과</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p id="message"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Understood</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 게시판 -->
	<div class="card">
		<div class="card-header container-fluid px-4">
			<form name="searchFrm">
				<div>
					<input type="hidden" name="pageNum" value="1"> <select
						id="type" name="type">
						<option value="">조건 선택
						<option value="writer">작성자
						<option value="title">제목
						<option value="content">내용
					</select> <input name="keyword" type="text" placeholder="Search Option"
						value="${cri.keyword}">
					<button class="btn btn-sm btn-secondary">검색</button>
					<button class="btn btn-sm btn-secondary" type="button"
						onclick="removeVal()">초기화</button>
				</div>
			</form>
		</div>
		<div class="container-fluid px-4">
			<h1 class="mt-4">게시판 리스트</h1>
			<div class="card-body">
				<table class="table table-striped table-bordered table-hover"
					id="boardTable" data-order='[[0, "desc"]]' data-page-length='10'>
					<thead>
						<tr>
							<th>게시물 번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일시</th>
							<th>상세보기</th>
							<th>수정</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="b" items="${boardList}">
							<tr>
								<td>${b.bno}</td>
								<td>${b.title}</td>
								<td>${b.writer}</td>
								<td><fmt:formatDate value="${b.regdate}"
										pattern="yyyy-MM-dd" /></td>
								<td align="center"><button type="button"
										class="btn btn-sm btn-secondary"
										onclick="location.href='boardDetail?bno=${b.bno}'">상세보기</button></td>
								<td align="center"><button type="button"
										class="btn btn-sm btn-secondary"
										onclick="location.href='boardUpdate?bno=${b.bno}'">수정</button></td>
								<td align="center"><button type="button"
										class="btn btn-sm btn-secondary"
										onclick="location.href='boardDelete?bno=${b.bno}'">삭제</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="pull-right">
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="page-item bg-dark"><a
								class="page-link bg-secondary text-white" href="#"
								onclick="goPage(${pageMaker.startPage-1})">Previous</a></li>
						</c:if>
						<c:forEach var="pageNum" begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}">
							<li class="page-item bg-dark"><a
								class="page-link bg-secondary text-white" href="#"
								onclick="goPage(${pageNum})" data-pageNum="${pageNum}">${pageNum}</a></li>
						</c:forEach>
						<c:if test="${pageMaker.next}">
							<li class="page-item bg-dark"><a
								class="page-link bg-secondary text-white" href="#"
								onclick="goPage(${pageMaker.endPage + 1})">Next</a></li>
						</c:if>
					</ul>
				</div>
				<div id="btnContainer" align="right">
					<button type="button" class="btn btn-secondary"
						onclick="location.href='boardInsert'">게시물 등록</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>