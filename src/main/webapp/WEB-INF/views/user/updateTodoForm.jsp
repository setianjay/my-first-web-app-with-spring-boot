        <%@ include file="../templates/header.jspf" %>

        <title>Update Todo Form</title>
        <style>
            .form-container {
                width: 40%;
                position: absolute;
                left: 50%;
                right: 50%;
                transform: translate(-50%,50%);
            }
        </style>

        <%@ include file="../templates/headerClosed.jspf" %>
        <%@ include file="../templates/navigation.jspf" %>

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

        <%@ include file="../templates/footer.jspf" %>
