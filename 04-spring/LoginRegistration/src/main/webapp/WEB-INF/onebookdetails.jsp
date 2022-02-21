<!-- c:out ; c:forEach ; c:if -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- form:form -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Insert title here</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
                    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                    crossorigin="anonymous">
            </head>

            <body>
                <div class="container">

                    <h1> ${bookObj.bookName} </h1>
                    <h2>${bookObj.postedBy.userName}</h2>
                    
                    <p>Here are ${bookObj.postedBy.userName}'s thoughts:</p>

                    <p>${bookObj.description}</p>



                </div>
            </body>

            </html>