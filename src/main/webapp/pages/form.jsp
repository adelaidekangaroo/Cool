<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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

<div class="container col-md-5">
    <div class="card">
        <div class="card-body">

            <c:if test="${cool != null}">
            <form action="${pageContext.request.contextPath}/cool?action=update" method="post">
                </c:if>
                <c:if test="${cool == null}">
                <form action="${pageContext.request.contextPath}/cool?action=create" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${cool != null}">
                                Update
                            </c:if>
                            <c:if test="${cool == null}">
                                Create
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${cool != null}">
                        <input type="hidden" name="id" value="${cool.id}"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>Amount (%)</label>
                        <input type="number" value="${cool.amount}" class="form-control"
                               name="amount" required="required">
                    </fieldset>

                    <button type="submit" class="btn btn-success">save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>