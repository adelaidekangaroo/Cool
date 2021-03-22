<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cool things</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: dodgerblue">
        <div>
            <a href="${pageContext.request.contextPath}/cool" class="navbar-brand">Cool things</a>
        </div>
    </nav>
</header>

<br>
<h3 class="text-center"><%=exception.getMessage()%>
</h3>
<hr>
<div class="text-center">
    <a href="${pageContext.request.contextPath}/cool" class="btn btn-success">back</a>
</div>