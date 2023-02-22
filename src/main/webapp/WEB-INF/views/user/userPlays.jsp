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
    <th>Title</th>
    <th>Date</th>
    <th>Score</th>
  </tr>
  </thead>
  <c:forEach items="${userPlays}" var="userPlay">
    <tr>
      <td>${userPlay.id}</td>
      <td><c:out value="${userPlay.play.game.title}"/></td>
      <td><c:out value="${userPlay.play.date}"/></td>
      <td><c:out value="${userPlay.points}"/></td>
    </tr>
  </c:forEach>
</table>
<p>
  <a href="/user/list">return to players list</a>
</p>
</body>
</html>
