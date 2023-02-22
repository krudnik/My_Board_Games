<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Plays list</title>
</head>
<body>
<table>
  <thead>
  <tr>
    <th>Id</th>
    <th>Date</th>
    <th>Game Title</th>
  </tr>
  </thead>
  <c:forEach items="${plays}" var="play">
    <tr>
      <td>${play.id}</td>
      <td><c:out value="${play.date}"/></td>
      <td><c:out value="${play.game.title}"/></td>
    </tr>
  </c:forEach>
</table>
<p>
  <a href="/game/add">add new game</a>
</p>
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