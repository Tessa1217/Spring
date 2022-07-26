<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style>
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
</style> -->
</head>
<body>
	<div class="container-fluid px-4">
		<h1 class="mt-4">사원 정보</h1>
		<div class="card mb-4">
			<div class="card-body">
				<form>
					<label for="employeeId">사번</label><input type="text"
						id="employeeId" name="employeeId">
						<br/>
					<label for="depts">부서</label>
					<input type="checkbox" name="depts" value="10">10 <input
						type="checkbox" name="depts" value="20">20 <input
						type="checkbox" name="depts" value="30">30
						<br/>
					<label for="jobId">직무</label>
					<select name="jobId">
						<option value="">Choose Job
						<option value="AC_ACCOUNT">AC_ACCOUNT
						<option value="AC_MGR">AC_MGR
						<option value="AD_ASST">AD_ASST
						<option value="AD_PRES">AD_PRES
						<option value="IT_PROG">IT_PROG
					</select>
					<br/>
					<p>
						입사 일자 <input type="date" name="sdt">~<input type="date"
							name="edt">
					</p>
					<button class="btn btn-secondary btn-sm">검색</button>
				</form>
			</div>
		</div>
		<div class="card mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-dark">
					<i class="fas fa-table me-1"></i>Employee Table
				</h6>
			</div>
			<div class="card-body">
				<table class="table table-striped table-bordered table-hover" id="dataTablesSimple">
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
								<td><fmt:formatDate value="${emp.hireDate}" pattern="yyyy-MM-dd"/></td>
								<td>${emp.jobId}</td>
								<td>${emp.departmentId}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>