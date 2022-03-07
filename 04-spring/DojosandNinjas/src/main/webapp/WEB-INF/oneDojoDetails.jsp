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

                    <h1>Welcome. Info about dojo: ${dojoToShow.dojoName} </h1>
                    <!-- <h2>${teamToShow.players}</h2> for testing purposes -->
                    <table class = "table table-dark">
                        <thead>
                            <tr>
                                <th scope="col">Ninja Id</th>
                                <th scope="col">First</th>
                                <th scope="col">Last</th>
                                <th scope="col">Age</th>
                                <th scope="col">Current Dojo</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach  items='${ dojoToShow.ninjas }' var='ninjaObj'>
                            <tr>
                                <th scope = "row">${ninjaObj.id}</th>
                                <td>${ninjaObj.firstName}</td>
                                <td>${ninjaObj.lastName}</td>
                                <td>${ninjaObj.age}</td>
                                <td>${ninjaObj.dojo.dojoName}</td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>



                </div>
            </body>

            </html>