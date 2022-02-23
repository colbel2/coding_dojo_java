<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <h1>Welcome ${loggedInUser.userName} </h1>
    <a href="/logout">Logout</a>
    <div class="container">

        <h1>Books From Everyones Shelves</h1>
        <hr>
        <a href="/book/add">Add A Book</a>
        
        <table class = "table table-dark">
            <thead>
                <tr>
                    <th scope="col">Book Id</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author Name</th>
                    <th scope="col">Posted By</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach  items='${ allBooks }' var='bookObj'>
                <tr>
                    <th scope = "row">${bookObj.id}</th>
                    <td><a href="/book/${bookObj.id}">${bookObj.bookName}</a></td>
                    <td>${bookObj.authorName}</td>
                    <td>${bookObj.postedBy.userName}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        
                









    </div>


</body>
</html>