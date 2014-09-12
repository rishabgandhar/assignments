<%@page import="com.nagarro.model.Image"%>
<%@page import="java.util.Set"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/CustomTagLib.tld" prefix="ct"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./CSS/Popup.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./JS/EditImage.js"></script>
<script type="text/javascript" src="./JS/DeleteImage.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body
	style="margin-left: 20%; margin-right: 20%; border-style: solid; border-width: 1px">
	<div align="center">
		<h2>Image Management Utility</h2>
	</div>
	<hr>
	<c:if test="${MAX_FILE_SIZE eq 'true'}">
		<div style="color: red">File Size of Image cannot exceed 1 MB</div>
	</c:if>
	<c:if test="${MAX_IMAGE_SIZE eq 'true'}">
		<div style="color: red">Total Image Size cannot exceed 10 MB</div>
	</c:if>
	<c:if test="${INVALID_IMAGE eq 'true'}">
		<div style="color: red">Please Upload a valid Image File</div>
	</c:if>
	<c:if test="${INVALID_FILE eq 'true'}">
		<div style="color: red">Please select a File to Upload</div>
	</c:if>
	<div class="popupBody" id="popupBody"></div>
	<div>
		<h3>Please Select an Image File to Upload(Max Size 1 MB) :</h3>
		<br>
		<form action="./ImageUpload" method="post"
			enctype="multipart/form-data">
			<div align="right" style="margin-right: 20px">
				<input type="file" name="file" id="upload"
					onchange="return checkFileSize(this)" /> <input type="submit"
					value="Submit" style="margin-left: 50%;"
					onclick="return checkFilePresence()" /> <input align="right"
					type="reset" value="Cancel" />
			</div>
		</form>
	</div>
	<div align="center" style="margin-top: 40px">
		<h3>Uploaded Images :</h3>
		<table class="table" border="1px">
			<tr>
				<th>S.No.</th>
				<th>Image Name</th>
				<th>Image Size</th>
				<th>Image Preview</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="image" items="${requestScope.imageList}"
				varStatus="loopCount">
				<tr>
					<td>${loopCount.count}</td>
					<td>${image.name}</td>
					<td><c:out value="${image.size/1024 }"></c:out> KB</td>
					<td><center>
							<img alt="${image.path}" src="${image.path}" width="80px"
								height="100px" />
						</center></td>
					<td>
						<div align="center">
							<form action="./DeleteImage" method="post"
								onsubmit="return deleteImage()" style="display: inline">
								<input type="hidden" name="imageid" value="${image.id}" /> <input
									type="image" src="./IMAGES/delete.png" width="30px"
									height="30px" value="Delete" />
							</form>
							&nbsp <input type="image" value="Edit" src="./IMAGES/edit.png"
								width="30px" height="30px"
								onclick="getEditForm('<c:out value='${image.name}'/>', '<c:out value='${image.path}'/>', '<c:out value='${image.id}'/>');" />
						</div>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5"><h5 align="center">Total Size :
						${requestScope.imageSize}</h5></td>
			</tr>
		</table>
	</div>
	<div class="popupTable" id="editForm" align="center">
		<form action="" method="post" enctype="multipart/form-data"
			onsubmit="return editImage();" id="form">
			<table style="margin: 20px; border-style: solid; border-width: 1px">
				<tr>
					<td>Image Name:</td>
					<td><input type="text" name="name" id="imageName" /></td>
					<td><input type="hidden" id="hidden" /></td>
				</tr>
				<tr>
					<td>Image Path:</td>
					<td><input type="file" name="file" id="imagetoedit"
						onchange="reload()" /></td>
					<td><img src="" id="image" alt="" width="100" height="100" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Edit Image Details" /></td>
					<td><input type="button" value="Cancel" onclick="popupClose()" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>