<%-- Before we use jspl tags, we must import it to jsp file --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Login Page</title>
        <style>
            html {
                font-size: 62.5%;
            }

            body {
                font-family: "Rubik", sans-serif;
                font-weight: 400;
                line-height: 1;
                color: #555;
            }

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            .login-container {
                position: absolute;
                left: 50%;
                top: 50%;
                transform: translate(-50%, -50%);
                width: 40rem;
            }

            .info-box {
                padding: 1.2rem;
                margin-bottom: 0.8rem;
            }

            .error-box {
                background-color: #FFB3BB;
            }

            .message {
                font-size: 1.4rem;
                color: #282A35;
                text-align: center;
            }

            .login-box {
                border: 2px solid #EAEAEA;
                padding: 1.2rem;
                box-shadow: 0 8px 10px 0 #EAEAEA;
            }

            h2 {
                text-align: center;
                font-size: 2.2rem;
                font-weight: 600;
                margin-bottom: 1.2rem;
            }

            hr {
                margin-bottom: 1.8rem;
            }

            label {
                display: inline-block;
                font-size: 1.6rem;
                text-transform: capitalize;
                margin-bottom: 0.8rem;
            }

            input[type=text], input[type=password] {
                width: 100%;
                padding: 0.6rem 1.2rem;
                margin-bottom: 2.4rem;
            }

            .login-button-box {
                display: flex;
                justify-content: center;
            }

            button {
                background-color: #3BAAFF;
                border: none;
                border-radius: 8px;
                color: white;
                cursor: pointer;
                font-size: 1.6rem;
                font-weight: 600;
                padding: 0.6rem 2.2rem;
                text-transform: capitalize;
                transition: all 0.5s;
            }

            button:hover {
                background-color: #0074CC;
            }
        </style>
    </head>
    <body>
        <section class="login-section">
            <div class="login-container">
                <c:if test="${not empty errorMessage}">
                    <div class="info-box error-box">
                        <pre class="message">${errorMessage}</pre>
                    </div>
                </c:if>
                <div class="login-box">
                    <h2>Login Form</h2>
                    <hr>
                    <form method="post">
                        <label>username</label>
                        <input type="text" name="username" required>
                        <label>password</label>
                        <input type="password" name="password" required>
                        <div class="login-button-box">
                            <button type="submit">login</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </body>
</html>