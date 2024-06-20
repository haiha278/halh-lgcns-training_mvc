<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home Page</title>
    <link rel="stylesheet" href="<c:url value="/resources/static/css/login-page.css" />"/>
</head>
<body>
<div class="container" id="login-id">
    <h1>Login</h1>
    <!-- login page Html source -->
    <form id="register-form-id" action="/login" method="post" modelAttribute="loginDTO">
        <div class="login-form">
            <div class="input-info">
                <label class="label" for="username">Username:</label>
                <input
                        class="input"
                        type="text"
                        id="username"
                        name="username"
                        placeholder="Username"
                        required
                />
            </div>
            <div class="input-info">
                <label class="label" for="password">Password:</label>
                <input
                        class="input"
                        type="password"
                        id="password"
                        name="password"
                        placeholder="Password"
                        required
                />
            </div>
            <div class="submit">
                <button type="submit" class="sign-in-button">Sign In</button>
                <a href="/register">Sign Up Here !</a>
            </div>
        </div>
    </form>
    <p><font color="red">${errorMessage}</font></p>
</div>
</body>
</html>