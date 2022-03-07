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

                    <h1>Add a book to your shelf!</h1>

                    
                    <form:form action="/book/create" method="post" modelAttribute="book">
                        <p>
                            <form:label path="bookName">Title</form:label>
                            <form:errors path="bookName" class="text-danger"/>
                            <form:input path="bookName"  type="text"/>
                        </p>
                        <p>
                            <form:label path="authorName">Author Name</form:label>
                            <form:errors path="authorName" class="text-danger"/>
                            <form:input path="authorName" type="text"/>
                        </p>

                        <p>
                            <form:label path="description">My Thoughts</form:label>
                            <form:errors path="description" class="text-danger"/>
                            <form:textarea path="description" type="text"/>
                        </p>
                        <input type="submit" value="Submit" />
                    </form:form>







                </div>
            </body>

            </html>