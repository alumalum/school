<%--
  Created by IntelliJ IDEA.
  User: alum
  Date: 2022/6/3
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>订单列表</h1>
<input type="button" onclick="javascript:window.location.href='/product/getAllProduct';" value="返回首页"><br>
<table border="1px" cellpadding="0" cellspacing="0">
    <tr>
        <td>订单号</td>
        <td>总价</td>
        <td>创建时间</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${ordersList}" var="orders">
        <tr>
            <td>${orders.oid}</td>
            <td>${orders.totalMoney}</td>
            <td><fmt:formatDate value="${orders.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
            <td>
                <a href="/ordersDetail/getDetail?id=${orders.oid}">查看详细订单</a>
            </td>
        </tr>
    </c:forEach>
</table>
<table>
    <tr>
        <td><a href="/orders/getOrders?currentPage=1">首页</a></td>
        <td><a href="/orders/getOrders?currentPage=${pages.getPrePage()}">上一页</a></td>
        <c:forEach items="${pages.getPageNum()}" var="num">
            <td><a href="/orders/getOrders?currentPage=${num}">[${num}]</a></td>
        </c:forEach>
        <td><a href="/orders/getOrders?currentPage=${pages.getNextPage()}">下一页</a></td>
        <td><a href="/orders/getOrders?currentPage=${pages.getTotalPage()}">尾页</a></td>
    </tr>
</table>
</body>
</html>
