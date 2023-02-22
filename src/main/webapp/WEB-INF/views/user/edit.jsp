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
    <title>Edit player</title>
</head>
<body>
<form:form method="post" action="/user/edit/save/${userToEdit.id}" modelAttribute="userToEdit">
    <h1>${userToEdit.id}</h1>
    <p>
        <form:label path="firstName">First Name</form:label>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="nickName">Nick</form:label>
        <form:input path="nickName"/>
    </p>
    <p>
        <form:hidden path="id"/>
        <input id="id" name="id" type="hidden" value="${userToEdit.id}"/>
        <input type="submit" />
    </p>
</form:form>
<p>
    <a href="/user/list">CANCEL</a>
</p>

</body>
</html>
