<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>findFlight</title>
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
<h2>findFlight</h2>
<spring:url value="/flights/findFlight" var="saveURL" />
<form action="${saveURL }"  method="post">
From<input type="text" name="departure">
To<input type="text" name="arrival">
<!-- Departure Date <input type="text" name="departureDate"> -->
<input type="submit" class="btn btn-primary" value="Search Flight ">
</form>
</body>
</html>