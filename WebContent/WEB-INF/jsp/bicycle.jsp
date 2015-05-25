<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page import="java.util.*,ua.scarick.bicycles.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	// Return array of checked items
	function getChecked(checkedBicycle) {
		var checkboxes = document.getElementsByName(checkedBicycle);
		var checkboxesChecked = [];
		for (var i = 0; i < checkboxes.length; i++ ) {
			if (checkboxes[i].checked) {
				checkboxesChecked.push(checkboxes[i].value)					
			}
		}
		return checkboxesChecked;
	}
	// If more than one items checked popup
	function validateForm(checkedBicycle) {
		var checkboxesChecked = getChecked(checkedBicycle);
		if (checkboxesChecked.length > 1) {
			alert("Please, select just one row to be edited.");
			return false;
		}	
	}
	// Delete checked items
	function deleteChecked(checkedBicycle) {
		var checkboxesChecked = getChecked(checkedBicycle);
		var locationSend = "/" + getLocation() + "/delete";
		if (checkboxesChecked != "") {
			var jsonCheckboxesChecked = {jsonCheckboxesChecked : JSON.stringify(checkboxesChecked)};
			if (confirm("Do you really want remove it?")) {				
				$.post(locationSend, jsonCheckboxesChecked, function(response) {		   		 
				location.reload();
		   		 });
			}
		}
	}
	
	function refreshTab() {	
		var location = "/" + getLocation() + "/bicycles";		
		window.location.href = location;
	}
	
	function getLocation() {
		var pathArray = window.location.pathname.split('/');
		return pathArray[1];		
	}
	</script>
	<title>Bicycle Storage</title>	
</head>
<body>
<form name="mainForm" method="post" action="${location}/edit" onsubmit=" return validateForm('checkedBicycle');">	 
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
			<td><input id="refreshButton" name="refresh" type="button" value="Refresh" onclick="refreshTab()"></td>
			<td><input id="editButton" name="edit" type="submit" value="Edit"></td>
			<td><input id="deleteButton" name="delete" type="button" value="Delete" onclick="return deleteChecked('checkedBicycle')"></td>
		</tr>
	</table>
</form>
</body>
</html>