// Return array of checked items
function getChecked(checkedBicycle) {
	var checkboxes = document.getElementsByName(checkedBicycle);
	var checkboxesChecked = [];
	for (var i = 0; i < checkboxes.length; i++ ) {
		if (checkboxes[i].checked) {
			checkboxesChecked.push(checkboxes[i])
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
	var jsonCheckboxesChecked = JSON.stringify(checkboxesChecked);
}