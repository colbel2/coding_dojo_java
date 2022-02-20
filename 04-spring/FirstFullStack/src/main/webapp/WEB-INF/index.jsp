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
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">

          </head>

          <body>

            <div class="container">
              <!-- Beginning of Container -->
              <h1>All The Menu Items</h1>
              <!-- ${allMenuItems} -->
              <!-- <c:out value="${allMenuItems}"/> this line and the one above it do the same thing -->



              <table class="table table-dark">
                <thead>
                  <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Type of Dish</th>
                    <th scope="col">Price</th>
                    <th scope="col">#ID</th>
                  </tr>
                  </head>
                  <tbody>
                    <c:forEach items='${allMenuItems}' var = 'menuObj'>
                      <tr>
                    <td scope="col">${menuObj.name}</td>
                    <td scope="col">${menuObj.dishType}</td>
                    <td scope="col">${menuObj.price}</td>
                    <td scope="col">${menuObj.id}</td>
                    </tr>
                    </c:forEach>
                </tbody>
              </table>
            </div> <!-- End of Container -->
          </body>

          </html>