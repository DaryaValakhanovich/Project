<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <p>
            <label for="email">Email: </label>
            <input type="text" name="email" id="email">
        </p>
        <p>
            <label for="password">Password: </label>
            <input type="password" name="password" id="password">
        </p>
        <p>
            <button type="submit">Login</button>
        </p>
    </form>

    <form action="${pageContext.request.contextPath}/createUser" method="get">
        <p>
            <button type="submit">Create new account</button>
        </p>
    </form>

    <form action="${pageContext.request.contextPath}/menu" method="get">
        <p>
            <button type="submit">Menu</button>
        </p>
    </form>
</body>
</html>
