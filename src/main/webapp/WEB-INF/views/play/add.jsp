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
    <a href="/game/add">add new participant</a>
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

<%--    <label for="user" style="padding: 10px 10px 7px;">participants</label>--%>
<%--    <br>--%>
<%--    juz wiem, czemu gowno nie działa - nie ma private User user w klasie Play--%>
<%--    musze całość przemyśleć na nowo, bo kurde nie wiem już jak dopisać punkty do gracza, jak w ogóle wybrac kto grał w dana gre--%>
<%--    <form:select itemValue="id" itemLabel="nickName" path="user" multiple="true"--%>
<%--                 items="${users}"/>--%>
<%--    <br>--%>
<%--    <br>--%>

    <button type="submit">submit</button>

</form:form>
</body>
</html>
