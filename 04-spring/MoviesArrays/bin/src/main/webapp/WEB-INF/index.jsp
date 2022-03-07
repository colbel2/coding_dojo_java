<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movies</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<h1><c:out value = "${movie }"></c:out></h1>
	<p>Released On: <c:out value = "${rd }"></c:out></p>
	<img height ="400px" src = "<c:out value = "${imageurl }"></c:out>">
	
	<p>Cast: <c:out value = "${actors }"></c:out></p>
	
	
	
	<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Age</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="actorObj" items="${actors}">
    <tr>
      <th scope="row">1</th>
      <td>${actorObj.firstName}</td>
      <td>${actorObj.lastName}</td>
      <td>${actorObj.age}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>



</body>
</html>