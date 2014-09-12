<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="./JS/UserInputValidation.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Image Management Utility</title>
</head>
<body>
	<div align="center" style="margin-top: 150px;">
		<c:if test="${WRONG_USER eq 'true'}">
			<h2 style="color: red">Wrong Username/Password</h2>
		</c:if>
		<c:if test="${LOGIN_FIRST eq 'true'}">
			<h2 style="color: red">Your Session Has Expired, Please Login Again</h2>
		</c:if>
		<form action="./UserLogin" method="post"
			onsubmit="return validation()">
			<table cellpadding="10">
				<tr>
					<td
						style="border-style: solid; border-left-color: aliceblue; border-right-color: aliceblue; background-color: aliceblue; border-bottom-color: lightskyblue; border-top-color: lightskyblue;"><h2
							style="margin: 0px; color: slateblue;">
							<b>Login:</b>
						</h2></td>
				</tr>
				<tr>
					<td style="background-color: aliceblue;">
						<table>
							<tr>
								<td style="width: 200px; padding: 10px;">Username</td>
								<td><h3 style="color: red; display: inline;">*</h3> <input
									type="text" name="username" id="us" /></td>
							</tr>
							<tr>
								<td style="width: 200px; padding: 10px;">Password</td>
								<td><h3 style="color: red; display: inline;">*</h3> <input
									type="password" name="password" id="pass" /></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td
						style="text-align: right; margin-right: 10px; text-align: right; margin-right: 10px; background-color: aliceblue; border-style: solid; border-top-color: lightskyblue; border-bottom-color: lightskyblue; border-left-color: aliceblue; border-right-color: aliceblue;"><input
						type="submit" value="Login>>" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>