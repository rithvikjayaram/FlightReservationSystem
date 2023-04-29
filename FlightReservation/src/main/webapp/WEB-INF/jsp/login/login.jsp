<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
  <form action="/login" method="post">
  <h1>Login:</h1>
  	<pre>
  	 User Name:-<input class="form-group" type="text" name="email" required="required">
  	 Password:-<input class="form-group" type="password" name="password" required="required">
  	 <input type="submit" class="btn btn-primary" value="login">
  	 ${msg}
  	</pre>
  </form>
</body>
</html>