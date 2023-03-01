<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Todos Page</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>Your Todos</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is It Done?</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="todo" items="${todos}" varStatus="loop">
                      <tr>
                        <td>${loop.index + 1}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>
                            <c:choose>
                                <c:when test = "${todo.done}">
                                    Yes
                                </c:when>

                                <c:otherwise>
                                    No
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td><a href="/todos/delete?id=${todo.id}" class="btn btn-warning">Delete</a>
                        <td><a href="/todos/update?id=${todo.id}" class="btn btn-success">Update</a>
                      </tr>
                    </c:forEach>
                </tbody>
            </table>

            <a href="/todos/create" class="btn btn-success">Create Todo</a>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.3.slim.js" integrity="sha256-DKU1CmJ8kBuEwumaLuh9Tl/6ZB6jzGOBV/5YpNE2BWc=" crossorigin="anonymous"></script>
    </body>
</html>