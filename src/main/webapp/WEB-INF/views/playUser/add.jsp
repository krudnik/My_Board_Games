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

<%--przeskakuje do widoku, w którym konkretnemu graczó w konkretnej grze przypisuje konretne punkty i rozgrywkę.--%>

<form:form method="post" modelAttribute="playUser">
    <label for="play" style="padding: 10px 10px 7px;">play</label>
    <br>
    <form:select itemValue="id" itemLabel="date" path="play"
                 items="${plays}"/>
    <br>
    <br>

    <label for="user" style="padding: 10px 10px 7px;">player</label>
    <br>
    <form:select itemValue="id" itemLabel="nickName" path="user"
                 items="${users}"/>
    <br>
    <br>

    <label for="points" style="padding: 10px 10px 7px;" >points</label>
    <br>
    <form:input type="number" path="points" />
    <br>
    <br>

    <button type="submit">submit</button>

</form:form>
</body>
</html>
