function getEditForm(imageName, imagePath, imageId) {
	document.getElementById("editForm").style.display = "block";
	document.getElementById("popupBody").style.display = "block";
	document.getElementById("imageName").value = imageName;
	document.getElementById("image").src = imagePath;
	document.getElementById("hidden").value = imageId;
}

function editImage() {
	var name = document.getElementById("imageName").value;
	var imageId = document.getElementById("hidden").value;
	document.getElementById("form").action = "./EditImage?name=" + name
			+ "&imageId=" + imageId;
}

function popupClose() {
	document.getElementById("editForm").style.display = "none";
	document.getElementById("popupBody").style.display = "none";
}

function reload() {
	document.getElementById("image").src = document
			.getElementById("imagetoedit").value;
	var name = document.getElementById("imagetoedit").value.split("\\");
	document.getElementById("imageName").value = name[name.length - 1];
}

function checkFileSize(inputFile) {
	var max = 1024 * 1024; // 1 MB
	var ext = inputFile.value.substring(inputFile.value.lastIndexOf(".") + 1);
	if (inputFile.files[0].size > max) {
		alert("File too large.(File Size can't be > 1 MB)");
		inputFile.value = null; 
		return false;
	} else if (!(ext === "jpg" || ext === "jpeg" || ext === "gif" || ext === "png")) {
		alert("Please Select an Image File");
		inputFile.value = null;
	} else {
		document.getElementById("image").src = document
				.getElementById("imagetoedit").value;
		return true;
	}
}
function checkFilePresence() {
	var inputFile = document.getElementById("upload");
	if (inputFile.value == null || inputFile.files.length == 0) {
		alert("Please select a file");
		return false;
	} else {
		return true;
	}
}