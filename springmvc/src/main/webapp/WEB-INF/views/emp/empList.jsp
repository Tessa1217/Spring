<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		width: 100%;
		border-collapse: collapse;
		text-align: center;
	}
	
	tr, th, td {
		border : 1px solid #eee;
	}
	
	th, td {
		padding: 1%;
	}
	
	tr:hover {
		background: beige;
		cursor: pointer;
		font-weight: bold;
	}
</style>
</head>
<body>
		<div>
		<h3>사원 정보</h3>
		<form>
			<label for="employeeId">사번</label><input type="text" id="employeeId" name="employeeId">
			<p>부서</p>
			<c:forEach var="dept" items="${deptList}">
				<input type="checkbox" name="depts" value="${dept.departmentId}">${dept.departmentName}
			</c:forEach>
			<p>직무</p>
			<select name="jobId">
				<option value="">Choose Job
				<%-- <c:forEach var="job" items="#{jobList}">
					<option value="#{job.jobId}">#{job.jobId}
				</c:forEach> --%>
				<option value="AC_ACCOUNT">AC_ACCOUNT
				<option value="AC_MGR">AC_MGR
				<option value="AD_ASST">AD_ASST
				<option value="AD_PRES">AD_PRES
				<option value="IT_PROG">IT_PROG
			</select>
			<p>입사 일자  <input type="date" name="sdt">~<input type="date" name="edt"></p>
			<button>검색</button>
		</form>
		<table>
			<thead>
				<tr>
					<th>Employee Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Hire Date</th>
					<th>Job Id</th>
					<th>Department Id</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="emp" items="${empList}">
					<tr onclick="location.href='empUpdate/${emp.employeeId}'">
						<td>${emp.employeeId}</td>
						<td>${emp.firstName}</td>
						<td>${emp.lastName}</td>
						<td>${emp.email}</td>
						<td>${emp.hireDate}</td>
						<td>${emp.jobId}</td>
						<td>${emp.departmentId}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
</body>
</html>