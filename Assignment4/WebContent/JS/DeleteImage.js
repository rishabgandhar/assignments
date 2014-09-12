function deleteImage() {
	var option = confirm("Are you Sure You Want to Delete this file ?");
	if(option===true) {
		return true;
	} else {
		return false;
	}
}