 <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <!-- form:form -->
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    <!-- for rendering errors on PUT routes -->
  <%@ page isErrorPage="true" %> 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
 
 <!DOCTYPE html>
 <html>
 <head>
 <meta charset="UTF-8">
 <title>Edit My Task</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 </head>
 <body>
     <div class="container">
         <h1>${showToShow.name}</h1>
         <form:form action="/shows/${show.id}/update" method="post" modelAttribute="show">
             <input type="hidden" name="_method" value="put"> 
             <form:input type="hidden" path="uploader" value="${idOfLoggedInUser}" />
             <div> 
                 <form:label path="name">Title</form:label>
                 <form:errors path="name" class = "text-danger"/>
                 <form:input path="name" type="text" class= "form-control"/>
             </div>
             <div>
                 <form:label path="network">Network</form:label>
                 <form:errors path="network" class = "text-danger"/>
                 <form:input path="network" type="text" class= "form-control"/>
             </div>
             <div>
                 <form:label path="description">Description</form:label>
                 <form:errors path="description" class = "text-danger"/>
                 <form:textarea path="description" type="text" class= "form-control"/>
             </div>
             <input type="submit" value="Submit" class= "btn btn-success mt-3"/>
         </form:form>   

         <hr>
         
            <a class=" btn btn-danger" href="/shows/${show.id}/delete">Delete</a>
        
     </div>
 </body>
 </html>