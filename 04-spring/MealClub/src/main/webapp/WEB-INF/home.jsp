<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Welcome ${loggedInUser.userName}</h1>
		<a href="/logout">Logout</a>



		<table class="table table-dark">
			<thead>
			  <tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Uploaded By</th>
				<th scope="col">Actions</th>
			  </tr>
			</thead>
			<tbody>
				<c:forEach items='${ allBooks }' var='book'>
					<tr>
						<th scope="row">${book.id}</th>
						<td><a href="/book/info/${book.id}">${book.name}</a></td>
						<td>${book.uploader.userName}</td>
					</tr>
				</c:forEach>
			 
			</tbody>
		  </table>
		  <hr>
		  <a href="/books/new">Add a new book</a>

	</div>


</body>
</html>