/**
 * 
 */

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
	// Refresh table (truely page)
	function refreshTab() {	
		var location = "/" + getLocation() + "/bicycles";		
		window.location.href = location;
	}
	
	function getLocation() {
		var pathArray = window.location.pathname.split('/');
		return pathArray[1];		
	}	
	
	function back() {
		window.history.back(-1);
	}
	
//	$(function(){
//		  $.datepicker.setDefaults(
//		        $.extend($.datepicker.regional["ru"])
//		  );
//		  $("#datepicker").datepicker();
//		});