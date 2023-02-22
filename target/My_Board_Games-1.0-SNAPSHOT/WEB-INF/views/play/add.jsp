<%--
  Created by IntelliJ IDEA.
  User: przemek
  Date: 07/02/2023
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/user/add">add new player</a>
</p>
<p>
    <a href="/game/add">add new game</a>
</p>
<p>
    <a href="/playUser/add">add new player's score</a>
</p>

<%--przeskakuje do widoku, w którym konkretnemu graczó w konkretnej grze przypisuje konretne punkty i rozgrywkę.--%>

<form:form method="post" modelAttribute="play">
    <label for="game" style="padding: 10px 10px 7px;">game title</label>
    <br>
    <form:select itemValue="id" itemLabel="title" path="game"
                 items="${games}"/>
    <br>
    <br>

    <label for="date" style="padding: 10px 10px 7px;">date of play</label>
    <br>
    <form:input type="text" path="date"/>
    <br>
    <br>

    <button type="submit">submit</button>

    <p>
        <a href="/play/list">show plays list</a>
    </p>

</form:form>
</body>
</html>
