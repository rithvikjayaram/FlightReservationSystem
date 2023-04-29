<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Reservation</title>
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<h2>Reservation Details</h2>
				<table class="table table-striped">

					<tr>
						<td scope="row">Flight Number</td>
						<td>${flight.flightId }</td>
					</tr>
					<tr>
						<td scope="row">Operating Airline</td>
						<td>${flight.flightName }</td>
					</tr>
					<tr>
						<td scope="row">Departure</td>
						<td>${flight.departure }</td>
					</tr>
					<tr>
						<td scope="row">Arrival</td>
						<td>${flight.arrival }</td>
					</tr>
					<tr>
						<td scope="row">DepartureDate</td>
						<td>${flight.departureDate }</td>
					</tr>
					<tr>
						<td scope="row">ArrivalDate</td>
						<td>${flight.arrivalDate }</td>
					</tr>
					<!-- Reservation Details -->
					<tr>
						<td scope="row">Reservation Number</td>
						<td>${reservation_user.id }</td>
					</tr>
					<!--Passenger Details -->
					<tr>
						<td scope="row">First Name</td>
						<td>${passenger_user.firstName }</td>
					</tr>
					<tr>
						<td scope="row">Last Name</td>
						<td>${passenger_user.lastName }</td>
					</tr>
					<tr>
						<td scope="row">MiddleName</td>
						<td>${passenger_user.middleName }</td>
					</tr>
					<tr>
						<td scope="row">Email</td>
						<td>${passenger_user.email }</td>
					</tr>
					<tr>
						<td scope="row">Phone</td>
						<td>${passenger_user.phone }</td>
					</tr>
					</tbody>
				</table>
			</div>
			<div class="col-sm-2">
			<a href="reservationCancel?reservationId=${reservation_user.id }">Cancel</a>
			</div>
		</div>

	</div>
</body>
</html>