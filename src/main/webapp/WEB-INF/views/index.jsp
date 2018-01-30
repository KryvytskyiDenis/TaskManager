<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<head>
    <title>Task Manager</title>
</head>
<body>

<div>
    <ul>
        <li><a href="/task-manager/tasks"><spring:message code="allTasks"/> </a></li>
        <li><a href="/task-manager/new-task"> <spring:message code="newTask"/></a></li>
        <li><a href="?lang=en">En</a></li>
        <li><a href="?lang=ru">Ru</a></li>
        <%--<form action="/logout" method="post">--%>
            <%--<input type="submit" value="Sign Out"/>--%>
        <%--</form>--%>
    </ul>
</div>
<c:choose>
    <c:when test="${mode == 'MODE_TASKS'}">
        <h2><spring:message code="myTasks"/></h2>
        <table>
            <thead>
            <tr>
                <th><spring:message code="idTask"/></th>
                <th><spring:message code="nameTask"/></th>
                <th><spring:message code="descriptionTask"/></th>
                <th><spring:message code="date"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tasks}" var="task">
                <tr>
                    <td>${task.id}</td>
                    <td>${task.name}</td>
                    <td>${task.description}</td>
                    <td>${task.dateCreated}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:when test="${mode == 'MODE_NEW' || mode == 'MODE_EDIT'}">
        <h2><spring:message code="manageTask"/></h2>
        <form action="/task-manager/save-task" method="post">
            <ul>
                <li>
                    <input type="hidden" name="id" value="${task.id}"/>
                </li>
                <li>
                    <label for="name"><spring:message code="nameTask"/>: </label>
                    <input name="name" id="name" value="${task.name}"/>
                </li>
                <li>
                    <label for="description"><spring:message code="descriptionTask"/>: </label>
                    <input name="description" id="description" value="${task.description}"/>
                </li>
                <li>
                    <input type="submit" value="Submit"/>
                </li>
            </ul>
        </form>
    </c:when>
</c:choose>

</body>
</html>
