<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="${contextPath}/resources/css/signin.css" rel="stylesheet">
    <title><spring:message code="signUp"/></title>
</head>
<body class="text-center">
<form:form method="POST" modelAttribute="userForm" class="form-signin">
<h1 class="h3 mb-3 font-weight-normal"><spring:message code="signUp.Title"/></h1>
    <spring:bind path="username">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label for="inputUsername" class="sr-only"><spring:message code="usernamePlaceholder"/></label>
            <input type="text" name="username" id="inputUsername" class="form-control" placeholder="<spring:message code="usernamePlaceholder"/>"
                        autofocus="true"/>
            <form:errors path="username" class="error"/>
        </div>
    </spring:bind>

    <spring:bind path="password">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label for="inputPassword" class="sr-only"><spring:message code="passwordPlaceholder"/></label>
            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="<spring:message code="passwordPlaceholder"/>"/>
            <form:errors path="password" class="error"/>
        </div>
    </spring:bind>

    <spring:bind path="confirmPassword">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label for="inputConfirmPassword" class="sr-only"><spring:message code="signUp.ConfPas"/></label>
            <input type="password" name="confirmPassword" id="inputConfirmPassword" class="form-control"
                        placeholder="<spring:message code="signUp.ConfPas"/>"/>
            <form:errors path="confirmPassword" class="error"/>
        </div>
    </spring:bind>

    <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="btn.submit"/></button>
    <h4 class="text-center"><a href="${contextPath}/task-manager/login"><spring:message code="signIn"/></a></h4>
</form:form>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
