<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/createUser" method="post">
    <p>Имя:</p>
    <input type="text" name="name"><br>
    <p>Фамилия:</p>
    <input type="text" name="surname"><br>
    <p>Email:</p>
    <input type="text" name="email"><br>
    <p>Придумайте пароль:</p>
    <input type="text" name="password"><br>
    <button type="submit">Создать</button>
</form>
</body>
</html>
