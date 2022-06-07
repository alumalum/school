<%--
  Created by IntelliJ IDEA.
  User: alum
  Date: 2022/6/3
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎你，<c:if test="${sessionScope.user.rid == 1}">管理员:</c:if>${sessionScope.user.uname}</h1>
<input type="button" onclick="javascript:history.back()-1;"value="返回上一页"><br>
<c:if test="${sessionScope.user.rid == 1}">
    <a href="/user/getAllUser">用户管理</a><br>
    <a href="/product/getAllProductAdmin">商品管理</a><br>
    <a href="/orders/getOrders">订单管理</a>
</c:if>
<c:if test="${sessionScope.user.rid == 2}">
    <a href="/user/getUserById?uid=${sessionScope.user.uid}">修改个人信息</a>
    <a href="/orders/getOrders">查看所有订单</a>
</c:if>
</body>
</html>
