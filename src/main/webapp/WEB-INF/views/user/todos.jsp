        <%@ include file="../templates/header.jspf" %>

        <title>Todos Page</title>

        <%@ include file="../templates/headerClosed.jspf" %>
        <%@ include file="../templates/navigation.jspf" %>

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

        <%@ include file="../templates/footer.jspf" %>