<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
    <link rel="stylesheet" href="<c:url value="/resources/static/css/register.css" />"/>
</head>
<body>
    <div class="container">
        <h1>Register</h1>
        <form id="register-form-id" action="/register" method="post" modelAttribute="registerDTO">
            <div class="register-form">
                <div class="input-info">
                    <label for="username">Username:</label>
                    <input class="input" type="text" id="username" name="username" placeholder="Username" required>
                </div>

                <div class="input-info">
                    <label for="password">Password:</label>
                    <input class="input" type="password" id="password" name="password" placeholder="Password" required>
                </div>

                <div class="input-info">
                    <label for="name">Full Name:</label>
                    <input class="input" type="text" id="name" name="name" placeholder="Full Name" required>
                </div>

                <div class="input-info">
                    <label>Gender:</label>
                    <div class="radio-input">
                        <div>
                            <input type="radio" id="male" name="gender" value="Male" required>
                            <label for="male">Male</label>
                        </div>

                        <div>
                            <input type="radio" id="female" name="gender" value="Female" required>
                            <label for="female">Female</label>
                        </div>
                    </div>
                </div>


                <div class="input-info">
                    <label for="dob">Date of Birth:</label>
                    <input class="input" type="date" id="dob" name="dob" required>
                </div>

                <div>
                    <button class="submit-button" type="submit" class="sign-in-button">Register</button>
                </div>
            </div>
        </form>
        <p><font color="red">${errorMessage}</font></p>
    </div>
</body>
</html>
