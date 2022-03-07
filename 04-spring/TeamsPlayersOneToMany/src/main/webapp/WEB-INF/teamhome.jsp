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

                    <h1>Welcome. Please add a team using the form below.</h1>
                    <hr>
                    <a href="/player/add">Add A Player</a>
                        <h1>New Team</h1>
                        <form:form action="/teams/create" method="post" modelAttribute="team">
                            <p>
                                <form:label path="teamName">Team Name</form:label>
                                <form:errors path="teamName" />
                                <form:input path="teamName" />
                            </p>
                        
                        </form:form>








                </div>
            </body>

            </html>