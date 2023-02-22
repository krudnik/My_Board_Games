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
  <form:form method="post" modelAttribute="user">
    <label for="firstName" style="padding: 10px 10px 7px;" >player name</label><br>
    <form:input type="text" path="firstName" />
    <br>
    <br>

    <label for="lastName" style="padding: 10px 10px 7px;" >surname</label>
    <br>
    <form:input type="text" path="lastName" />
    <br>
    <br>

    <label for="nickName" style="padding: 10px 10px 7px;" >nick</label>
    <br>
    <form:input type="text" path="nickName" />
    <br>
    <br>

    <button type="submit">submit</button>

  </form:form>
</body>
</html>
