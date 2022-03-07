<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!-- c:out ; c:forEach ; c:if -->
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!-- Formatting (like dates) -->
        <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <!-- form:form -->
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
                <!-- for rendering errors on PUT routes -->
                <%@ page isErrorPage="true" %>
                    <!DOCTYPE html>
                    <html>

                    <head>
                        <meta charset="UTF-8">
                        <title>Title Here</title>
                        <!-- Bootstrap -->
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                            rel="stylesheet"
                            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                            crossorigin="anonymous">

                    </head>

                    <body>

                        <div class="container">
                            <h1>Expense Details</h1>
                            <!-- Beginning of Container -->
                            <table class="table table-dark">
                                <thead>
                                    <tr>
                                        <th scope="col">Expense</th>
                                        <th scope="col">Vendor</th>
                                        <th scope="col">Description</th>
                                        <th scope="col">Amount</th>
                                        <!-- <th>Actions: </th> -->
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                        <tr>
                                            <td>${expenseItem.expenseName}</td>
                                            <td>${expenseItem.vendorName}</td>
                                            <td> ${expenseItem.description}</td>
                                            <td>${expenseItem.amount}</td>
                                            
                                        </tr>
                                </tbody>
                            </table>




            
                            <a href="http://localhost:8080/expenseitems" class="btn btn-primary btn-lg active"
                                role="button" aria-pressed="true">Go Back</a>




                        </div> <!-- End of Container -->
                    </body>

                    </html>