<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page import="ua.scarick.bicycles.entity.*"%>

<!-- Get attributes from EditController -->
<c:set var="bicycleID" value="${bicycleID}"/>
<c:set var="bicycleEntity" value="${bicycle}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/WEB-INF/jsp/res.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add item</title>
</head>
<body>
	<div id="wrapper">
		<c:if test="${bicycleID == null}"><h2>Add a new bicycle</h2></c:if>
		<c:if test="${bicycleID != null}"><h2>Change the bicycle</h2></c:if>
	
	<table>
		<tr>
			<td>					
				<form name="mainForm" method="post" action="${location}/add" onsubmit=" return validateAddForm();">
					<table class="table-form">
						<tr>
							
							<input type="hidden" name="id" value="${bicycleEntity.id}"/>			
						</tr>						
						<tr>
							<td>${bicycleID == null ? 'Enter' : 'Edit'} Manufacturer</td>
							<td><input id="manufacturer" type="text" name="manufacturer"  value="${bicycleEntity.manufacturer}"/></td>			
						</tr>
						<tr>
							<td>${bicycleID == null ? 'Enter' : 'Edit'} Model:</td>
							<td><input id="model" type="text" name="model" value="${bicycleEntity.model}"/></td>
						</tr>
						<tr>
							<td>${bicycleID == null ? 'Enter' : 'Edit'} Gender:</td>
							<td><select name="gender">
						    	<option value="M" <c:if test="${bicycleEntity.gender == 'M'}">selected='selected'</c:if>>Man</option>
						    	<option value="W" <c:if test="${bicycleEntity.gender == 'W'}">selected='selected'</c:if>>Woman</option>
						    	<option value="B" <c:if test="${bicycleEntity.gender == 'B'}">selected='selected'</c:if>>Both</option>    	  	    	    	
				   				</select>
				   			</td> 			
						</tr>
						<tr>
							<td>${bicycleID == null ? 'Enter' : 'Edit'} Amount:</td>
							<td><input id="amount" type="text" name="amount" value="${bicycleEntity.amount}"/></td>
						</tr>
						<tr>
							<td>${bicycleID == null ? 'Choose' : 'Edit'} date of last check (year-month-day):</td>
							<td><input type="text" id="lastCheck" name="lastCheck" value="${bicycleEntity.lastCheck}"/></td>
						</tr>		
					</table> 
				
					<table class="table-buttons">
						<tr>
							<td><input class="button" id="addButton" name="add" type="submit" value= "${bicycleID == null ? 'Add' : 'Save'}"></td>
							<td><input class="button" id="cancelButton" name="cancel" type="button" value="Cancel" onclick="back();"></td>			
						</tr>
					</table>
				</form>	
			</td>			
			<td valign="top">	
				<div id="inner-table">				
					<table width="250px">		
						<tr class="warning-cell">								
							<td><span style="display:none; color:#F00; font-size:12px" id="warningManufacture">*field must not be empty</span></td>
						</tr>
						<tr class="warning-cell">
							<td><span style="display:none; color:#F00; font-size:12px" id="warningModel">*field must not be empty</span></td>			
						</tr>
						<tr class="warning-cell">
							<td></td>					
						</tr>
						<tr class="warning-cell">
							<td><span style="display:none; color:#F00; font-size:12px" id="warningAmount">*field is empty or not a number</span></td>			
						</tr>
						<tr class="warning-cell">
							<td><span style="display:none; color:#F00; font-size:12px" id="warningLastCheck">*field is empty or wrong date format</span></td>			
						</tr>		
					</table>
				</div>					
			</td>
		</tr>
	</table>
	
	
	
</div> <!-- end of div wrapper -->
</body>
</html>