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
<a href="/dashboard">Dashboard</a>
	<h1>${bookobj.name}</h1>
	<h2> ${bookobj.uploader.userName} read ${bookobj.name } by ${bookobj.author}</h2>
	
	<h2> Here are ${bookobj.uploader.userName} thoughts: </h2>
	<p>Description: ${bookobj.description}</p>
	


</body>
</html>