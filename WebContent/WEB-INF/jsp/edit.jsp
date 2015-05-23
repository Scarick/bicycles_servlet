<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@page import="ua.scarick.bicycles.entity.*"%>
<c:set var="bicycleID" value="${bicycleID}"/>
<c:set var="bicycleEntity" value="${bicycle}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function back() {
	document.location.href = "/bicycles_servlet";	
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add item</title>
</head>
<body>
	<form name="mainForm" method="post" action="/bicycles_servlet/add">
	<table>
		<tr>
			<td>Enter Manufacturer:</td>
			<td><input type="text" name="manufacturer"  value=""/></td>
		</tr>
		<tr>
			<td>Enter Model:</td>
			<td><input type="text" name="model" value=""/></td>
		</tr>
		<tr>
			<td>Enter Gender(M, W or B):</td>
			<td><input type="text" name="gender"/></td>
		</tr>
		<tr>
			<td>Enter Amount:</td>
			<td><input type="text" name="amount"/></td>
		</tr>
		<tr>
			<td>Choose date of last check:</td>
			<td><input type="text" name="date"/></td>
		</tr>		
	</table> 
	
	<table>
		<tr>
			<td><input id="saveButton" name="save" type="submit" value= "${bicycleID == null ? 'Add' : 'Save'}" onclick=""></td>
			<td><input id="cancelButton" name="cancel" type="button" value="Cancel" onclick="back();"></td>			
		</tr>
	</table>
</form>
</body>
</html>