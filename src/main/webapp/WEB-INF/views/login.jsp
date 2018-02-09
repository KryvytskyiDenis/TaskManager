<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <!-- Custom styles for this template -->
        <link href="${contextPath}/resources/css/signin.css" rel="stylesheet">

        <title><spring:message code="signIn"/></title>
    </head>
    <body class="text-center">
            <form method="POST" action="${contextPath}/login" class="form-signin">
                <h1 class="h3 mb-3 font-weight-normal"><spring:message code="signIn"/></h1>
                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <span class="message">${message}</span>
                    <label for="inputUsername" class="sr-only">Username</label>
                    <input name="username" id="inputUsername" type="text" class="form-control" placeholder="<spring:message code="usernamePlaceholder"/>"
                           required autofocus/>

                    <label for="inputPassword" class="sr-only">Password</label>
                    <input name="password" id="inputPassword" type="password" class="form-control" placeholder="<spring:message code="passwordPlaceholder"/>" required/>
                    <span class="error">${error}</span>

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="checkbox mb-3">
                        <label>
                            <input name="remember-me" type="checkbox"> Remember me
                        </label>
                    </div>

                    <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="signIn"/></button>
                    <h4 class="text-center"><a href="${contextPath}/task-manager/registration"><spring:message code="signUp"/></a></h4>
                </div>
            </form>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>