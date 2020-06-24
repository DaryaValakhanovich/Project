<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Тип номера:</p>
<select name="roomTypeId">
    <option value="0">Любой</option>
    <c:forEach var="roomType" items="${requestScope.roomTypes}">
        <option value="${roomType.id}">${roomType.title}</option>
    </c:forEach>
</select>
</body>
</html>
<c:forEach var="room" items="${requestScope.rooms}">
    <input type="radio" name = "room" value="${room.id}">${room.id} ${room.type} ${room.NumberOfPlaces}
</c:forEach>