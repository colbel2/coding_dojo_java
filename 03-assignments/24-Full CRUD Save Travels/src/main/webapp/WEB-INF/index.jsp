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
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
      </head>

      <body>
        <div class="container">

          <h1>Save Travels</h1>

          <table class="table table-dark">
            <thead>
              <tr>
                <th scope="col">#ID</th>
                <th scope="col">Expense</th>
                <th scope="col">Vendor</th>
                <th scope="col">Amount</th>
                <!-- <th>Actions: </th> -->
              </tr>
            </thead>
            <tbody>
              <c:forEach items='${ allExpenseItems }' var='expenseObj'>
                <tr>
                  <th scope="row">${menuObj.id}</th>
                  <td><a href="/expenseitems/${expenseObj.id}">${expenseObj.expenseName}</a></td>
                  <td>${expenseObj.vendorName}</td>
                  <td>${expenseObj.amount}</td>
                  <td>
                    <a href="/expenseitems/edit/${expenseObj.id}">Edit</a> ||
                    <a href="/expenseitems/delete/${expenseObj.id}">Delete</a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
          <hr>
        
        
        
          <form:form action="/expenseitem/create" method="post" modelAttribute="expenseitem">
            <p>
              <form:label path="expenseName">Expense Name: </form:label>
              <form:errors path="expenseName" class="text-danger" />
              <form:input type="text" path="expenseName" class="form-control" />
            </p>
            <p>
              <form:label path="vendorName">Vendor</form:label>
              <form:errors path="vendorName" class="text-danger" />
              <form:input type="text" path="vendorName" class="form-control" />
            </p>
            <p>
              <form:label path="amount">Amount </form:label>
              <form:errors path="amount" class="text-danger" />
              <form:input type="number" path="amount" step="0.01" class="form-control" />
            </p>
            <p>
              <form:label path="description">Description: </form:label>
              <form:errors path="description" class="text-danger" />
              <form:textarea path="description" class="form-control" />
            </p>
            <input type="submit" value="Submit" />
          </form:form>




        </div>
      </body>

      </html>