<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
    <head>
        <title><spring:message code="signIn"/></title>
    </head>
    <body>
        <div class="container">

            <form method="POST" action="${contextPath}/login" class="form-signin">
                <h2 class="form-heading"><spring:message code="signIn"/></h2>

                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <span>${message}</span>
                    <input name="username" type="text" class="form-control" placeholder="<spring:message code="usernamePlaceholder"/>"
                           autofocus="true"/>
                    <input name="password" type="password" class="form-control" placeholder="<spring:message code="passwordPlaceholder"/>"/>
                    <span>${error}</span>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="signIn"/></button>
                    <h4 class="text-center"><a href="${contextPath}/task-manager/registration"><spring:message code="signUp"/></a></h4>
                </div>

            </form>

        </div>
    </body>
</html>