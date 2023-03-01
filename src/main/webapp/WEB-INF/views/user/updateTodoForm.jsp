<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Todos Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <style>
            .form-container{
                width: 40%;
                position: absolute;
                left: 50%;
                right: 50%;
                transform: translate(-50%,50%);
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="form-container">
                <h1>Update Todo</h1>
                <hr>
                <div>
                    <form:form method="post" cssClass="form-control" modelAttribute="todo">
                        <div class="mb-3 row">
                            <form:label path="description" cssClass="col-sm-3 col-form-label">Description</form:label>
                            <div class="col-sm-9">
                                <form:input cssClass="form-control" path="description" required="required" />
                                <c:if test="${not empty errorMessage}">
                                    <pre class="text-danger">${errorMessage}.</pre>
                                </c:if>
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <form:label path="targetDate" cssClass="col-sm-3 col-form-label">Target Date </form:label>
                            <div class="col-sm-9">
                                <form:input path="targetDate" type="date" cssClass="form-control"  required="required"/>
                            </div>
                        </div>

                        <div class="mb-3 row align-items-center">
                            <form:label path="done" cssClass="col-sm-3 col-form-label">Todo is done? </form:label>
                            <div class="col-sm-9">
                                <div class="form-check form-check-inline">
                                    <form:radiobutton path="done" value="true" label="Yes" cssClass="form-check-input"/>
                                </div>
                                <div class="form-check form-check-inline">
                                    <form:radiobutton path="done" value="false" label="No" cssClass="form-check-input"/>
                                </div>
                            </div>
                        </div>

                        <form:input type="hidden" cssClass="form-control" path="id" />
                        <form:input type="hidden" cssClass="form-control" path="username" />

                        <div class="d-flex justify-content-end">
                            <button type="submit" class="btn btn-success">Create</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.3.slim.js" integrity="sha256-DKU1CmJ8kBuEwumaLuh9Tl/6ZB6jzGOBV/5YpNE2BWc=" crossorigin="anonymous"></script>
    </body>
</html>