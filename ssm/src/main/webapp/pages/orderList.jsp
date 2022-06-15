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
<h1>购买完成列表</h1>
<input type="button" onclick="javascript:window.location.href='/product/getAllProduct';" value="返回首页"><br>
<table border="1px" cellpadding="0" cellspacing="0">
    <tr>
        <td>订单号</td>
        <td>总价</td>
        <td>创建时间</td>
    </tr>
    <tr>
        <td>${orders.oid}</td>
        <td>${orders.totalMoney}</td>
        <td><fmt:formatDate value="${orders.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
    </tr>
</table>
<div>
    <h4>订单详细</h4>
    <table border="1px" cellpadding="0" cellspacing="0">
        <tr>
            <td>订单号</td>
            <td>商品名</td>
            <td>单价</td>
            <td>购买数量</td>
        </tr>
        <c:forEach items="${ordersDetailList}" var="ordersDetail" varStatus="i">
            <tr <c:if test="${i.index%2 == 0}">
                bgcolor="#a9a9a9"
            </c:if>>
                <td>${ordersDetail.oid}</td>
                <td>${ordersDetail.pname}</td>
                <td>${ordersDetail.price}</td>
                <td>${ordersDetail.quantity}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
