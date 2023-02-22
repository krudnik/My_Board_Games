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
  <form:form method="post" modelAttribute="game">
    <label for="title" style="padding: 10px 10px 7px;" >game title</label><br>
    <form:input type="text" path="title" />
    <br>
    <br>

    <label for="minPlayers" style="padding: 10px 10px 7px;" >min players number</label>
    <br>
    <form:input type="number" path="minPlayers" />
    <br>
    <br>

    <label for="maxPlayers" style="padding: 10px 10px 7px;" >max players number</label>
    <br>
    <form:input type="number" path="maxPlayers" />
    <br>
    <br>

    <label for="description" style="padding: 10px 10px 7px;" >description</label>
    <br>
    <form:input type="text" path="description" />
    <br>
    <br>

    <label for="rating" style="padding: 10px 10px 7px;" >rating</label>
    <br>
    <form:input type="number" path="rating" />
    <br>
    <br>

    <button type="submit">submit</button>

  </form:form>
</body>
</html>
