<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사원 등록</h2>
<form action="empInsert" method="post">
	<label for="firstName">이름</label>
	<input type="text" id="firstName" name="firstName"/>
	<br/>
	<label for="lastName">성</label>
	<input type="text" id="lastName" name="lastName"/>
	<br/>
	<label for="email">이메일</label>
	<input type="email" id="email" name="email"/>
	<br/>
	<label for="hireDate">입사일자</label>
	<input type="date" id="hireDate" name="hireDate"/>
	<br/>
	<label for="jobId">업무</label>
	<input type="text" id="jobId" name="jobId"/>
	<br/>
	<button>등록</button>
</form>
</body>
</html>