<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movies</title>
</head>
<body>
	<h1><c:out value = "${movie }"></c:out></h1>
	<p>Released On: <c:out value = "${rd }"></c:out></p>
	<img height ="400px" src = "<c:out value = "${imageurl }"></c:out>">
	
	
	
	



</body>
</html>