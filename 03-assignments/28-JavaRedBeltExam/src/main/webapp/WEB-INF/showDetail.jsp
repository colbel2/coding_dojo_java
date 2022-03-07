<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show One Show</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>${showToShow.name}</h1>
        <a class = "btn btn-primary" href="/home">Back to Dashboard</a>
        <p>Posted by: ${showToShow.uploader.userName}</p>
        <p>Network ${showToShow.network}</p>
        <p>Description:  ${showToShow.description}</p>
            <a class = "btn btn-success" href="/shows/${showToShow.id}/edit">Edit</a>
            


    </div>
</body>
</html>