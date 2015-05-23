<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@page import="java.util.*,ua.scarick.bicycles_servlet.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
function validateForm(form) {
	alert()
	
}
</script>
<title>Bisyscle Storage</title>
</head>
<body>
<form name="mainForm" method="post" action="/bicycles_servlet/edit" onsubmit="return confirm("Are you sure?");">	 
	<table border="1" id="bicycles">
		<thead>		
		<tr>
			<th></th>
			<th>ID</th>
			<th>Manufacturer</th>
			<th>Model</th>
			<th>Gender</th>
			<th>Amount</th>
			<th>Last check date</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="bicycles" items="${bicycleStorageList}">
				<tr>
					<td><input type="checkbox" name="checkedBicycle" value="${bicycles.id}"></td>
					<td>${bicycles.id}</td>
					<td>${bicycles.manufacturer}</td>
					<td>${bicycles.model}</td>
					<td>${bicycles.gender}</td>
					<td>${bicycles.amount}</td>
					<td>${bicycles.lastCheck}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table> 
	<table>
		<tr>
			<td><input id="refreshButton" name="refresh" type="button" value="Refresh" onclick=""></td>
			<td><input id="editButton" name="edit" type="submit" value="Edit"></td>
			<td><input id="deleteButton" name="delete" type="button" value="Delete"></td>
		</tr>
	</table>
</form>
</body>
</html>