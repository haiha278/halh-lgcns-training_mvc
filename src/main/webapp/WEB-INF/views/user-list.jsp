<%@ page pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
            integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
    />
    <link rel="stylesheet" href="<c:url value="/resources/static/css/user-list.css" />"/>
<%--    <script>--%>
<%--        function confirmDeleteUser(username) {--%>
<%--            console.log("called")--%>
<%--            var result = "Are you sure you want to delete this user?";--%>
<%--            if (result) {--%>
<%--                window.location.href = "/delete?username=" + username;--%>
<%--            }--%>
<%--        }--%>
<%--    </script>--%>
    <title>Hello</title>
</head>
<body class="container">
<h2>Hello: ${username} - ${role}</h2>
<h1 class="header">User List</h1>
<table>
    <thead>
    <tr>
        <th>Number</th>
        <th>Username</th>
        <th>Name</th>
        <th>Age</th>
        <th>Gender</th>
        <th>Role</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="count" value="1"/>
    <c:forEach var="user" items="${allUsers}">
        <tr>
            <td>${count}</td>
            <td>${user.username}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.gender}</td>
            <td>${user.roleName}</td>
            <td><a class="update-link" href="/update-user?username=${user.username}">Update</a> | <i style="cursor: pointer"
                                                                           onclick="confirmDeleteUser(`${user.username}`)"
                                                                           class="fa-solid fa-trash"></i></td>
        </tr>
        <c:set var="count" value="${count + 1}"/>
    </c:forEach>
    </tbody>
</table>
<p>${message}</p>
<script src="<c:url value="/resources/static/js/user-list-page.js" />"></script>
</body>
</html>