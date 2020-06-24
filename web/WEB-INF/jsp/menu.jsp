<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/inf" method="get">
    <p>
        <button type="submit">Inf</button>
    </p>
</form>

<form action="${pageContext.request.contextPath}/login" method="get">
    <p>
        <button type="submit">Login</button>
    </p>
</form>

<form action="${pageContext.request.contextPath}/logOut" method="get">
    <p>
        <button type="submit">Log out</button>
    </p>
</form>

Clients:
<form action="${pageContext.request.contextPath}/createReservation" method="get">
    <p>
        <button type="submit">Create Reservation</button>
    </p>
</form>

Admins:
<form action="${pageContext.request.contextPath}/admin" method="get">
    <p>
        <button type="submit">Add admin</button>
    </p>
</form>

</body>
</html>
