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
        <th>Max Points</th>
        <th>By Who</th>
        <th>Average Points</th>

    </tr>
    </thead>

    <c:forEach items="${maxPoints}" var="maxPoint">
        <tr>
            <td>${maxPoint.id}</td>
            <td><c:out value="${maxPoint.play.game.title}"/></td>
            <td><c:out value="${maxPoint.play.date}"/></td>
            <td><c:out value="${maxPoint.points}"/></td>
            <td><c:out value="${maxPoint.user.nickName}"/></td>
            <td>${avgPoints}</td>
        </tr>
    </c:forEach>
</table>
<p>
    <a href="/game/list">return to games list</a>
</p>
</body>
</html>
