<%@ page import="java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>EL 내장객체</h3>
<% 
	request.setAttribute("name", "리퀘스트");
	session.setAttribute("name", "세션");
	application.setAttribute("name", "어플리케이션");
	request.setAttribute("list", Arrays.asList("a", "b", "c")); 
%>
<ul>
	<li>파라미터</li>
	<ul>
		<li><%= request.getParameter("id") %></li>
		<li>${param.id}</li>
		<li>${param["id"]}</li>
	</ul>
	<li>속성</li>
	<ul>
		<li>${requestScope.name}</li>
		<li>${sessionScope.name}</li>
		<li>${applicationScope.name}</li>
	</ul>
	<li>헤더</li>
	<ul>
		<li><%= request.getHeader("User-Agent") %></li>
		<li>${header["User-Agent"]}</li>
	</ul>
	<li>쿠키</li>
	<ul>
		<li>${cookie.openYn.value}</li>
	</ul>
	<li>컨텍스트 파라미터</li>
	<ul>
		<li><%= application.getInitParameter("contextConfigLocation") %></li>
		<li>${initParam.contextConfigLocation}</li>
	</ul>
	<li>함수</li>
	<ul>
		<li>${fn:length(list)}</li>
		<li>${fn:startsWith(name, "리")}</li>
		<li>${fn:contains(list, a)}</li>
	</ul>
	<li>Escape XML</li>
	<ul>
		<li><c:out escapeXml="true" value="<h2>헤헷</h2>"></c:out></li>
		<li><c:out escapeXml="false" value="<h2>헤헷</h2>"></c:out></li>
	</ul>
</ul>
</body>
</html>