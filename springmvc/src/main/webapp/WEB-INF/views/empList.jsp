<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div>
		<h3>사원 정보</h3>
		<c:forEach var="employee" items="${empList}">
			<ul>
				<li>${employee.firstName} ${employee.lastName}: ${employee.jobId}</li>
			</ul>
			</c:forEach>
		</div>
</body>
</html>