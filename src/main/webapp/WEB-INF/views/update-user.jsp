<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/23/2024
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<h2>Edit User</h2>
<form action="/update-user" method="post" modelAttribute="updateUserDTO">
    <input type="hidden" name="username" value="${userInfo.username}"/>
    <div>
        <label>Name:</label>
        <input type="text" name="name" value="${userInfo.name}" required/>
    </div>
    <div>
        <label>Age:</label>
        <input type="number" name="age" value="${userInfo.age}" required/>
    </div>
    <div>
        <label>Gender:</label>
        <input type="text" name="gender" value="${userInfo.gender}" required/>
    </div>
    <div>
        <label>Date of Birth:</label>
        <input type="date" name="dob" value="${userInfo.dob}" required/>
    </div>
    <div>
        <input type="submit" value="Update"/>
    </div>
</form>
</body>
</html>
