<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.0.0/jquery.min.js"></script>
<script>
	/* function validateForm() {
		var x = document.forms["myForm"]["firstName"].value;
		if (x == "") {
			alert("Name must be filled out");
			return false;
		}
	} */
</script>
</head>
<body>
	<div class="container">
		<h2>RegisterUser</h2>
		<form name="myForm" action="/registerUser" method="post">
		
		<div class="form-group">
		
			<lable for="firstName">firstName</lable>
			<input type=text class="form-control" name="firstName" required />
</div>
			<div class="form-group">

				<input type=text class="form-control" name="lastName" required />
			</div>
			<div class="form-group">
				<lable for="email">email</lable>
				<input type=email class="form-control" name="email" required />
			</div>
			<div class="form-group">
				<lable for="password">password</lable>
				<input type="password" class="form-control" name="password" required />
			</div>
			<div class="form-group">
				<lable for="confirmpassword"> Confirm password</lable>
				<input type="password" class="form-control" name="confirmpassword"
					required />
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Submit">
			</div>
			</form>
	</div>
</body>
</html>