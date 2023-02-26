<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <h1>Add Todo</h1>
                <hr>
                <div>
                    <form method="post" class="form-control">
                        <div class="mb-3 row">
                            <label class="col-sm-3 col-form-label" for="description">Description</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="description" required />
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label class="col-sm-3 col-form-label" for="targetDate">Target Date</label>
                            <div class="col-sm-9">
                                <input type="date" class="form-control" name="targetDate" required />
                            </div>
                        </div>
                        <div class="d-flex justify-content-end">
                            <button type="submit" class="btn btn-success">Create</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.3.slim.js" integrity="sha256-DKU1CmJ8kBuEwumaLuh9Tl/6ZB6jzGOBV/5YpNE2BWc=" crossorigin="anonymous"></script>
    </body>
</html>