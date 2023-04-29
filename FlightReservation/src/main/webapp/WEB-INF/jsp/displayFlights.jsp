<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Flghts</title>
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>


<div class="container">
  <h2>Flight</h2>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Open</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${flights}" var="flight">
      <tr>
        <td>${flight.flightName}</td>
	<td>${flight.departure}</td>
	<td>${flight.departureDate}</td>
	<td><a href="showCompleteReservation?flightId=${flight.flightId}">Select</a></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>


</body>
</html>