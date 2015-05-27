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
	// If more than one items checked then popup
	function validateForm(checkedBicycle) {
		var checkboxesChecked = getChecked(checkedBicycle);
		if (checkboxesChecked.length > 1) {
			alert("Please, select just one row to be edited.");
			return false;
		}		
	}
	
	function verifyManufacturer() {
		var manufacturer = document.getElementById('manufacturer');
		var warning = document.getElementById("warningManufacture");
		if (manufacturer.value != "") {
			warning.style.display = "none";
			return true;
		} else {
			warning.style.display = "inline";
			return false;
		}
	}
	function verifyModel() {
		var model = document.getElementById('model');
		var warning = document.getElementById("warningModel");
		if (model.value != "") {
			warning.style.display = "none";
			return true;
		} else {
			warning.style.display = "inline";
			return false;
		}
	}
	function verifyAmount() {
		var amount = document.getElementById('amount');
		var warning = document.getElementById("warningAmount");
		var amountVerify = /\d/;
		if (amount.value != "" && amountVerify.test(amount.value)) {
			warning.style.display = "none";
			return true;
		} else {
			warning.style.display = "inline";
			return false;
		}
	}
	
	function verifyLastCheck() {
		var lastCheck = document.getElementById('lastCheck');
		var warning = document.getElementById("warningLastCheck");
		var lastCheckVerify = /\d{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])/;
		if (lastCheck.value != "" && LastCheckVerify.test(lastCheck.value)) {
			warning.style.display = "none";
			return true;
		} else {
			warning.style.display = "inline";
			return false;
		}
	}
	// Form entered data validation
	function validateAddForm() {					
		if (verifyManufacturer() && verifyModel() && verifyAmount() && verifyLastCheck()) {
			return true;
		} else {
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