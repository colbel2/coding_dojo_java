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

                    <h1>Welcome. Please add a player using the form below.</h1>
                    <!-- <h1>${allteams}</h1> used for testing-->
                    <form:form action="/player/create" method="post" modelAttribute="player">
                        <div>
                            <form:label path="firstName">First Name</form:label>
                            <form:errors path="firstName" class="text-danger" />
                            <form:input path="firstName" type="text" />
                        </div>
                        <div>
                            <form:label path="lastName">Last Name</form:label>
                            <form:errors path="lastName" class="text-danger" />
                            <form:input path="lastName" type="text" class="" />
                        </div>
                        <div>
                            <form:label path="ppg">Points Per Game</form:label>
                            <form:errors path="ppg" class="text-danger" />
                            <form:input path="ppg" type="number" step=".01" class="" />
                        </div>
                        <div>
                            <form:label path="team">Which Team Does The Player Play For?</form:label>
                            <form:errors path="team" class="text-danger" />
                            <form:select path="team" name="" id="" class="form-select">
                                <c:forEach  items='${ allteams }' var='teamObj'>
                                    <option value="${teamObj.id}" class="">${teamObj.teamName}</option>
                                </c:forEach>
                                
                            </form:select>
                        </div>


                        
                        <input type="submit" value="Submit">
                    </form:form>







                </div>
            </body>

            </html>