<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/chooseRoom" method="get">
    <p>Дата приезда:</p>
    <input type="date" name="arrivalDay"><br>
    <p>Дата отъезда:</p>
    <input type="date" name="departureDay"><br>
    <p>Тип номера:</p>
    <select name="roomTypeId">
        <option value="0">Любой</option>
        <c:forEach var="roomType" items="${requestScope.roomTypes}">
            <option value="${roomType.id}">${roomType.title}</option>
        </c:forEach>
    </select>
    <p>Колличество мест:</p>
    <input type="number" name="numberOfPlaces"><br>
    <br>
    <br>
    <button type="submit">Поиск</button>
</form>
</body>
</html>
