<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page import="ua.scarick.bicycles.entity.*"%>

<!-- Get attributes from EditController -->
<c:set var="bicycleID" value="${bicycleID}"/>
<c:set var="bicycleEntity" value="${bicycle}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function back() {
	window.history.back(-1);
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add item</title>
</head>
<body>
	<form name="mainForm" method="post" action="${location}/add">
	<table>
		<tr>
			<td></td>
			<td><input type="hidden" name="id" value="${bicycleEntity.id}"/></td>
		</tr>
		<tr>
			<td>${bicycleID == null ? 'Enter' : 'Edit'} Manufacturer</td>
			<td><input type="text" name="manufacturer"  value="${bicycleEntity.manufacturer}"/></td>
		</tr>
		<tr>
			<td>${bicycleID == null ? 'Enter' : 'Edit'} Model:</td>
			<td><input type="text" name="model" value="${bicycleEntity.model}"/></td>
		</tr>
		<tr>
			<td>${bicycleID == null ? 'Enter' : 'Edit'} Gender:</td>
			<td><select name="gender">
		    	<option value="M">Man</option>
		    	<option value="W">Woman</option>
		    	<option value="B">Both</option>    	  	    	    	
   				</select>
   			</td>
<%-- 			<td><input type="text" name="gender" value="${bicycleEntity.gender}"/></td> --%>
		</tr>
		<tr>
			<td>${bicycleID == null ? 'Enter' : 'Edit'} Amount:</td>
			<td><input type="text" name="amount" value="${bicycleEntity.amount}"/></td>
		</tr>
		<tr>
			<td>${bicycleID == null ? 'Choose' : 'Edit'} date of last check (year-month-day):</td>
			<td><input type="text" name="lastCheck" value="${bicycleEntity.lastCheck}"/></td>
		</tr>		
	</table> 
	
	<table>
		<tr>
			<td><input id="saveButton" name="save" type="submit" value= "${bicycleID == null ? 'Add' : 'Save'}"></td>
			<td><input id="cancelButton" name="cancel" type="button" value="Cancel" onclick="back();"></td>			
		</tr>
	</table>
</form>
</body>
</html>