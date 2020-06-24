<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="{pageContext.request.contextPath}/menu" method="get">
    Ваша заявка добавлена:
    <p>Дата приезда: ${requestScope.application.dayOfArrival}</p>
    <p>Дата отъезда: ${requestScope.application.dayOfDeparture}</p>
    <p>Номер комнаты: ${requestScope.application.room.id}</p>
    <p>Тип комнаты: ${requestScope.application.room.type.title}</p>
    <p>Колличество мест: ${requestScope.application.room.numberOfPlaces}</p>
    <p>Итоговая стоимость: ${requestScope.cost}</p>
    <p>
        <button type="submit">Подтвердить</button>
    </p>
</form>
</body>
</html>
