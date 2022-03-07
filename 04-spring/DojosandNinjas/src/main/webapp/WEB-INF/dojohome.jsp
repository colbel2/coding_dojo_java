<!-- c:out ; c:forEach ; c:if -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- form:form -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Dojos and Ninjas</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
                    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                    crossorigin="anonymous">
            </head>

            <body>
                <div class="container">

                    <h1>Dojos and Ninjas.</h1>
                    <hr>
                    <a href="/ninja/add">Add A Ninja</a>
                        <h1>New Dojo</h1>
                        <form:form action="/dojo/create" method="post" modelAttribute="dojo">
                            <p>
                                <form:label path="dojoName">Name</form:label>
                                <form:errors path="dojoName" />
                                <form:input path="dojoName" />
                            </p>
                            <input type="submit" value="Submit">
                        </form:form>








                </div>
            </body>

            </html>