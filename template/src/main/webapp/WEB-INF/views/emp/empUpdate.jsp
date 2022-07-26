<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사원 등록</h2>
<form action="../empUpdate" method="post">
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%-- <form action="${pageContext.request.contextPath}" method="post"> --%>
	<input type="hidden" id="pathCheck" value="${path}"/>
	<input type="hidden" name="employeeId" value="${emp.employeeId}"/>
	<label for="firstName">이름</label>
	<input type="text" id="firstName" name="firstName" value="${emp.firstName}"/>
	<br/>
	<label for="lastName">성</label>
	<input type="text" id="lastName" name="lastName" value="${emp.lastName}"/>
	<br/>
	<label for="email">이메일</label>
	<input type="email" id="email" name="email" value="${emp.email}"/>
	<br/>
	<label for="hireDate">입사일자</label>
	<input type="date" id="hireDate" name="hireDate" value='<fmt:formatDate  value="${emp.hireDate}" pattern="yyyy-MM-dd"/>'/>
	<br/>
	<label for="jobId">업무</label>
	<input type="text" id="jobId" name="jobId" value="${emp.jobId}"/>
	<br/>
	<button>등록</button>
	<button type="button" id="btnDelete">삭제</button>
</form>
<script>
	btnDelete.addEventListener("click", function() {
		location.href="${path}/empDelete?employeeId=${emp.employeeId}";
	})
</script>
</body>
</html>