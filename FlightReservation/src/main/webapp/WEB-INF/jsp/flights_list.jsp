<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
  <h2>Flights Details</h2>
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope="row">Flight Id</th>
     <th scope="row">Flight Name</th>
     <th scope="row">Departure</th>
     <th scope="row">Arrival</th>
     <th scope="row">DepartureDate</th>
     <th scope="row">ArrivalDate</th>
     <th scope="row">Edit</th>
     <th scope="row">Delete</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach items="${flightsList}" var="flight" >
     <tr>
      <td>${flight.flightId }</td>
      <td>${flight.flightName }</td>
      <td>${flight.departure }</td>
      <td>${flight.arrival }</td>
      <td>${flight.departureDate }</td>
      <td>${flight.arrivalDate }</td>
      <td>
       <spring:url value="/flights/update/${flight.flightId }" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
      </td>
      <td>
       <spring:url value="/flights/delete/${flight.flightId  }" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/flights/add" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button">Add New Flight</a>
 </div>
</body>
</html>