<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Results list</title>
</head>
<body>
<table>
  <thead>
  <tr>
    <th>Id</th>
    <th>Points</th>
    <th>Player</th>
    <th>Game</th>
    <th>Date</th>
  </tr>
  </thead>
  <c:forEach items="${playUsers}" var="playUser">
    <tr>
      <td>${playUser.id}</td>
      <td><c:out value="${playUser.points}"/></td>
      <td><c:out value="${playUser.user.nickName}"/></td>
      <td><c:out value="${playUser.play.game.title}"/></td>
      <td><c:out value="${playUser.play.date}"/></td>

    </tr>
  </c:forEach>
</table>
  <p>
    <a href="/playUser/add">add new player's score</a>
  </p>
  <p>
    <a href="/play/add">add new play</a>
  </p>
<p>
  <a href="/game/add">add new game</a>
</p>
<p>
  <a href="/user/add">add new player</a>
</p>
<p>
  <a href="/play/list">show plays list</a>
</p>
<p>
  <a href="/game/list">show games list</a>
</p>
<p>
  <a href="/user/list">show players list</a>
</p>
</body>
</html>