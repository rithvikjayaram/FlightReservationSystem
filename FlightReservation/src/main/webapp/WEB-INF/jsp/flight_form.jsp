<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights</title>
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<spring:url value="/flights/save" var="saveURL" />
		<h2>Employee</h2>
		<%-- <form:form modelAttribute="flightForm" method="post"
			action="${saveURL }" class="form">
			<form:hidden path="flightId" />
			<div class="form-group">
				<lable for="flightName">Flight Name</lable>
				<form:input path="flightName" class="form-control"
					id="flightName" />
			</div>
			<div class="form-group">
				<lable for="departure">departure</lable>
				<form:input path="departure" class="form-control" id="departure" />
			</div>
			<div class="form-group">
				<lable for="arrival">arrival</lable>
				<form:input path="arrival" class="form-control" id="arrival" />
			</div>
			<div class="form-group">
				<lable for="arrival">departureDate</lable>
				<form:input path="departureDate" class="form-control"
					id="departureDate" />
			</div>
			<div class="form-group">
				<lable for="arrivalDate">arrivalDate</lable>
				<form:input path="arrivalDate" class="form-control"
					id="arrivalDate" />
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form:form> --%>
		
		<form method="post"
			action="${saveURL }" class="form-group">
			<div class="form-group">
				<lable for="flightName">Flight Name</lable>
				<input type="text" name="flightName" class="form-control" required="required"
					id="flightName" />
			</div>
			<div class="form-group">
				<lable  for="departure">departure</lable>
				<input type="text" name="departure" class="form-control" required="required" id="departure" />
			</div>
			<div class="form-group">
				<lable for="arrival">arrival</lable>
				<input type="text" name="arrival"  required="required" class="form-control" id="arrival" />
			</div>
			<div class="form-group">
				<lable for="arrival">departureDate</lable>
				<input type="date" name="departureDate"  required="required" class="form-control"
					id="departureDate" />
			</div>
			<div class="form-group">
				<lable for="arrivalDate">arrivalDate</lable>
				<input type="date" name="arrivalDate" class="form-control"
					id="arrivalDate" />
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form>
	</div>
</body>
</html>