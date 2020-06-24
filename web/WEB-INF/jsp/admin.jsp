<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin" method="post">
    <p>
        <label for="email">Username: </label>
        <input type="text" name="email" id="email">
    </p>
    <p>
        <button type="submit">Add</button>
    </p>
</form>
</body>
</html>
