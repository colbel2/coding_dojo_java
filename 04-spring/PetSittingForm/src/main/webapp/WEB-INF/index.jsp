<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pet Sitting</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

    <div>
	    <h1> Pet Sitting Arrangement</h1>
        <form action="/process_appointment" method="post">
            <div class="form-group">
                <label for="">Pet Name:</label>
                <input type="text" name="pet_name" id="" class ="form-control">

            </div>
            <div class="form-group">
                <label for="">Age:</label>
                <input type="number" name="age" id="" class ="form-control" style = "width:20%;">

                <div class="form-group">
                    <label for="">Owner Name:</label>
                    <input type="text" name="owner_name" id="" class ="form-control">
    
                </div>

            </div>
            <div class="form-group">
                <label for="">Pet Favorite Activity:</label>
                <input type="text" name="activity" id="" class ="form-control">

            </div>
            <div class="form-group">
                <label for="">Animals to Keep Pet Away From:</label>
                <input type="text" name="away" id="" class ="form-control">

            </div>

            <div class="form-group">
                <label for="">Something Nice About Pet:</label>
                <textarea name ="nice" id="" cols="30" rows="10" class="form-control"></textarea>

            </div>
            <input type="submit" value="Submit" class = "btn btn-success">

        </form>



    </div>
</body>
</html>