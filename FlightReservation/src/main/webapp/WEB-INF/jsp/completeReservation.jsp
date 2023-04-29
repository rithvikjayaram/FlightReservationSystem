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
<title>Complete Reservation</title>
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">


				<div class="jumbotron jumbotron-fluid">
					<div class="container">
						<h2>Complete Reservation</h2>
						<table class="table table-borderless">
							<thead>
								<tr>
									<th>Operating Airline:</th>
									<th>Departure :</th>
									<th>Arrival :</th>
								</tr>
							</thead>
							<tbody>

								<tr>
									<td>${flight.flightName}</td>
									<td>${flight.departure}</td>
									<td>${flight.arrival}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="jumbotron jumbotron-fluid">
					<div class="container">
						<spring:url value="/flights/conf" var="saveURL" />
						<form action="${saveURL }" method="post">
							<h2>Passenger Details</h2>
							<div class="form-group">
								<lable>first Name</lable>
								<input class="form-control" type="text" name="passenerFirstName"
									required="required" />
							</div>
							
							<div class="form-group">
								<lable>Last Name</lable>
								<input class="form-control" type="text" name="passenerLastName"
									required="required" />
							</div>
							<div class="form-group">
								<lable>Email</lable>
								<input class="form-control" type="text" name="passeneremail"
									id="email" />
							</div>
							<div class="form-group">
								<lable>Phone Number</lable>
								<input class="form-control" type="text" name="passenerPhone"
									required="required" />
							</div>
							<h2>Card Details</h2>
							<div class="form-group">
								<lable>Name on the Card</lable>
								<input class="form-control" type="text" name="nameOnTheCard"
									required="required" />
							</div>
							<div class="form-group">
								<lable>Card No</lable>
								<input class="form-control" type="text" name="cardNo"
									required="required" />
							</div>
							<div class="form-group">
								<lable>Expiry Date</lable>
								<input class="form-control" type="date" name="expiryDate" />
							</div>
							<div class="form-group">
								<lable>CVV Number</lable>
								<input class="form-control" type="text" maxlength="3"
									name="securityCode" />
							</div>
							<input type="hidden" name="flightId" value="${flight.flightId}" />
							<button type="submit" class="btn btn-primary">Confirm</button>
						</form>
					</div>
				</div>

			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>


</body>
</html>