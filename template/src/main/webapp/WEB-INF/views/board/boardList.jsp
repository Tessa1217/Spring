<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" rel="stylesheet"/>
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
		
		function goPage(num) {
			searchFrm.pageNum.value = num;
			searchFrm.submit(); 
		}
	</script>
	<div class="container-fluid px-4">
		<form name="searchFrm">
			<div class="card-header">
				<div>
				<input type="hidden" name="pageNum" value="1">
				<label for="type">검색: </label><select id="type" name="type"> 
					<option value="writer">작성자
					<option value="title">제목
					<option value="content">내용
				</select>
				<input name="keyword" type="text">
				</div>
				<button>검색</button>
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
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${boardList}">
						<tr onclick="location.href='boardUpdate?bno=${b.bno}'">
							<td>${b.bno}</td>
							<td>${b.title}</td>
							<td>${b.writer}</td>
							<td><fmt:formatDate value="${b.regdate}"
									pattern="yyyy-MM-dd" /></td>
							<td align="center"><button type="button" class="btn btn-sm btn-secondary"
									onclick="event.stopPropagation(); location.href='boardDetail?bno=${b.bno}'">상세보기</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="pull-right">
				<ul class="pagination">
					<c:if test="${pageMaker.prev}">
						<li class="page-item"><a class="page-link" href="#" onclick="goPage(${pageMaker.startPage-1})">Previous</a></li>
					</c:if>
					<c:forEach var="pageNum" begin="${pageMaker.startPage}"
					end="${pageMaker.endPage}">
						<li class="page-item"><a class="page-link" href="#" onclick="goPage(${pageNum})">${pageNum}</a></li>
					</c:forEach>
					<c:if test="${pageMaker.next}">
						<li class="page-item"><a class="page-link" href="#" onclick="goPage(${pageMaker.endPage + 1})">Next</a></li>
					</c:if>
				</ul>
			</div>
			<div id="btnContainer" align="right">
				<button type="button" class="btn btn-secondary" onclick="location.href='boardInsert'">게시물
					등록</button>
			</div>
		</div>
	</div>
</body>
</html>