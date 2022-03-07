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
    <div class="container">
        <h1>Welcome, ${loggedInUser.userName} </h1>
        <a href="/logout">Logout</a>
        <h2>View Workouts</h2>
        
        <table class="table table-dark">
            <thead>
              <tr>
                <th scope="col">ID#</th>
                <th scope="col">Workout</th>
                <th scope="col">Date</th>


              </tr>
            </thead>
            <tbody>
                <c:forEach items='${ allWorkouts }' var='workoutObj'>
                
                    <tr>
                        <th scope="row">${workoutObj.id}</th>
                        <td><a href="/workout/${workoutObj.id}/details">${workoutObj.workoutName}</a></td>
                        <td>${workoutObj.createdAt}</td>
                    </tr>
                </c:forEach>
              
            </tbody>
          </table>
          <a class = "btn btn-primary" href="/workout/new">Add a Workout</a>
    </div>
   
</body>
</html>