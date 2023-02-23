<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Users list</title>
</head>
<body>
<table>
  <thead>
  <tr>
    <th>Id</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Nick</th>
    <th>Plays</th>
    <th>Delete</th>
    <th>Edit</th>
  </tr>
  </thead>
  <c:forEach items="${users}" var="user">
    <tr>
      <td>${user.id}</td>
      <td><c:out value="${user.firstName}"/></td>
      <td><c:out value="${user.lastName}"/></td>
      <td><c:out value="${user.nickName}"/></td>
      <td><a href="/user/results/${user.id}">results</a></td>
      <td><a href="/user/delete/${user.id}">delete</a></td>
      <td><a href="/user/edit/${user.id}">edit</a></td>

    </tr>
  </c:forEach>
</table>
  <p>
    <a href="/user/add">add new player</a>
  </p>
  <p>
    <a href="/play/add">add new play</a>
  </p>
<p>
  <a href="/">show scores list</a>
</p>
</body>
</html>