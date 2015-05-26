<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page import="java.util.*,ua.scarick.bicycles.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/WEB-INF/jsp/res.jsp" %>	
	<title>Bicycle Storage</title>	
</head>
<body>
  <div id="wrapper">
  
  	<h2>Bicycle Storage Tab</h2>
  
  <form name="mainForm" method="post" action="${location}/edit" onsubmit=" return validateForm('checkedBicycle');">	 
	<table class="simple-little-table" cellspacing="0">
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
	<table class="table-buttons">
		<tr>
			<td><input class="button" id="refreshButton" name="refresh" type="button" value="Refresh" onclick="refreshTab()"></td>
			<td><input class="button" id="editButton" name="edit" type="submit" value="Edit"></td>
			<td><input class="button" id="deleteButton" name="delete" type="button" value="Delete" onclick="return deleteChecked('checkedBicycle')"></td>
		</tr>
	</table>
	</form>	
	</div>	
</body>
</html>