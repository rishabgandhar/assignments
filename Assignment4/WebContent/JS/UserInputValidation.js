function validation() {
	var valid = false;
	var us = document.getElementById("us");
	var pass = document.getElementById("pass");
	if (us != "" && pass != "") {
		valid = true;
	} else {
		valid = false;
	}
	 return valid;
}