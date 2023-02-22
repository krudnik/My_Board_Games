<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: przemek
  Date: 07/02/2023
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit game</title>
</head>
<body>
<form:form method="post" action="/game/edit/save/${gameToEdit.id}" modelAttribute="gameToEdit">
    <h1>${gameToEdit.id}</h1>
    <p>
        <form:label path="title">Title</form:label>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="minPlayers">min Players</form:label>
        <form:input path="minPlayers"/>
    </p>
    <p>
        <form:label path="maxPlayers">max Players</form:label>
        <form:input path="maxPlayers"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:input path="description"/>
    </p>
    <p>
        <form:label path="rating">rating</form:label>
        <form:input path="rating"/>
    </p>
    <p>
        <form:hidden path="id"/>
        <input id="id" name="id" type="hidden" value="${gameToEdit.id}"/>
        <input type="submit" />
    </p>
</form:form>
<p>
    <a href="/game/list">CANCEL</a>
</p>

</body>
</html>
