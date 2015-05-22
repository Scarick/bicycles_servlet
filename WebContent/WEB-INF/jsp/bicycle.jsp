<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@page import="java.util.*,ua.scarick.bicycles_servlet.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bisyscle Storage</title>
</head>
<body>
<form name="mainForm" method="post" action=>	 
	<table border="1">		
		<tr>
			<th></th>
			<th>ID</th>
			<th>Manufacturer</th>
			<th>Model</th>
			<th>Gender</th>
			<th>Amount</th>
			<th>Last check date</th>
		</tr>
	<c:forEach var="bicycles" items="${bicycleStorageList}">
		<tr>
			<td><input type="checkbox" name="bicycleId" value="${bicycles.id}"></td>
			<td>${bicycles.id}</td>
			<td>${bicycles.manufacturer}</td>
			<td>${bicycles.model}</td>
			<td>${bicycles.gender}</td>
			<td>${bicycles.amount}</td>
			<td>${bicycles.lastCheck}</td>
		</tr>
	</c:forEach>
	</table> 
	
</form>
</body>
</html>