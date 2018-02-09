<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link rel="stylesheet" href="${contextPath}/resources/css/album.css"/>
    <title><spring:message code="titleMain"/></title>

</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <a class="navbar-brand" href="${contextPath}/task-manager/tasks">Task manager</a>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a href="${contextPath}/task-manager/tasks" class="nav-link">
                        <spring:message code="allTasks"/> </a>
                </li>
                <li class="nav-item active">
                    <a href="${contextPath}/task-manager/new-task" class="nav-link">
                        <spring:message code="newTask"/></a>
                </li>


            </ul>

            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="?lang=en&id=${task.id}" class="nav-link">En</a>
                </li>
                <li class="nav-item">
                    <a href="?lang=ru&id=${task.id}" class="nav-link">Ру</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link"> ${username}</a>
                </li>
                <li class="nav-item">
                    <a href="${contextPath}/task-manager/logout" class="nav-link">
                        <spring:message code="logout"/></a>
                </li>
            </ul>
        </div>
    </nav>
</header>

<main>
    <section class="jumbotron text-center">
        <div class="container">
            <h1 class="jumbotron-heading"><spring:message code="manageTask"/></h1>
        </div>
    </section>
    <div class="album py-5 bg-light">
        <div class="container">
            <form:form modelAttribute="taskForm" action="${contextPath}/task-manager/save-task" method="post">
                <input type="hidden" name="id" value="${task.id}"/>

                    <div class="form-group row">
                        <label for="task-name-input" class="col-sm-2 col-form-label"><spring:message
                                code="nameTask"/></label>
                        <div class="col-sm-10">
                            <input name="name" class="form-control" type="text" value="${task.name}" id="task-name-input">
                        </div>
                        <form:errors path="name" class="error"/>
                    </div>

                <div class="form-group row">
                    <label for="task-description-input" class="col-sm-2 col-form-label"><spring:message
                            code="descriptionTask"/></label>
                    <div class="col-sm-10">
                        <textarea name="description" id="task-description-input"
                          class="form-control">${task.description}</textarea>
                    </div>
                    <form:errors path="description" class="error"/>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-row text-center">
                    <div class="col-12">
                        <input type="submit" value="Submit" class="btn btn-sm btn-secondary"/>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</main>


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
