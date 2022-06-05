<%--
  Created by IntelliJ IDEA.
  User: alum
  Date: 2022/6/3
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/login" method="get">
    用户名:<input type="text" name="uname"><br>
    密码:<input type="password" name="password"><br>
    <select name="rid">
        <c:forEach items="${rolesList}" var="roles">
            <option value="${roles.id}">${roles.name}</option>
        </c:forEach>
    </select><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
