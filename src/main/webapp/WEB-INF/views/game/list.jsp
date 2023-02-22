<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Games list</title>
</head>
<body>
<table>
  <thead>
  <tr>
    <th>Id</th>
    <th>Title</th>
    <th>min players</th>
    <th>max players</th>
    <th>Description</th>
    <th>Rating</th>
    <th>Delete</th>
    <th>Edit</th>
  </tr>
  </thead>
  <c:forEach items="${games}" var="game">
    <tr>
      <td>${game.id}</td>
      <td><c:out value="${game.title}"/></td>
      <td><c:out value="${game.minPlayers}"/></td>
      <td><c:out value="${game.maxPlayers}"/></td>
      <td><c:out value="${game.description}"/></td>
      <td><c:out value="${game.rating}"/></td>
      <td><a href="/game/delete/${game.id}">delete</a></td>
      <td><a href="/game/edit/${game.id}">edit</a></td>
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

</body>
</html>