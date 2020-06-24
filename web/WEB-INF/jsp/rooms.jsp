<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/chooseServices" method="get">
    <p>Выберете комнату:</p>
    <c:forEach var="room" items="${requestScope.rooms}">
       <p><input type="radio" name = "room" value="${room.id}">${room.id} ${room.type.title} ${room.type.costForOneNight} ${room.numberOfPlaces}</p>
    </c:forEach>
    <br>
    <br>
    <button type="submit">Выбрать</button>
</form>
</body>
</html>

