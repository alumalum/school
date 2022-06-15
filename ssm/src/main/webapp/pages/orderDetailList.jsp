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
<h1>订单详细列表</h1>
<input type="button" onclick="javascript:history.back()-1;" value="返回上一页"><br>
<div>
    <table border="1px" cellpadding="0" cellspacing="0">
        <tr>
            <td>订单详细号</td>
            <td>订单号</td>
            <td>商品名</td>
            <td>商品单价价格</td>
            <td>购买数量</td>
        </tr>
        <c:forEach items="${ordersDetailList}" var="ordersDetail" varStatus="i">
            <tr <c:if test="${i.index%2 == 0}">
                bgcolor="#a9a9a9"
            </c:if>>
                <td>${ordersDetail.id}</td>
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
