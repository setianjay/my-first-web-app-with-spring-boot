<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Todos Page</title>
        <style>
                 table {
                    width: 800px;
                    font-size: 18px;
                    text-align: left;
                    border-collapse: collapse;
                 }

                  thead tr {
                    background-color: #087f5b;
                    color: white;
                  }

                  th,
                  td {
                    padding: 16px 24px;
                  }

                  tbody tr:nth-child(odd) {
                    background-color: #f8f9fa;
                  }

                  tbody tr:nth-child(even) {
                    background-color: #e9ecef;
                  }

                  tbody tr:hover {
                    cursor: pointer;
                    background-color: #20c997;
                  }
        </style>
    </head>
    <body>
        <h2>Welcome on Todos Page ${username}!</h3>
        <hr>
        <h1>Your Todos</h1>
        <table>
            <thead>
                <tr>
                    <th>No</th>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is It Done?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="todo" items="${todos}" varStatus="loop">
                  <tr>
                    <td>${loop.index + 1}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                  </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>