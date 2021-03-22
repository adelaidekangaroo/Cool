<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

<div class="row">
    <div class="container">
        <h3 class="text-center">Do you have something cool? Share with us</h3>
        <hr>
        <div class="container text-left">
            <a href="${pageContext.request.contextPath}/cool?action=new" class="btn btn-success">add</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>id</th>
                <th>Amount (%)</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="list" scope="request" type="java.util.List"/>
            <c:forEach var="cool" items="${list}">
                <jsp:useBean id="cool" type="edu.born.cool.model.Cool"/>
                <tr>
                    <td>${cool.id}</td>
                    <td>${cool.amount}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/cool?id=${cool.id}&action=edit">update</a>
                        <a href="${pageContext.request.contextPath}/cool?id=${cool.id}&action=delete">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>