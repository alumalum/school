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
<h1>购物车列表</h1>
<input type="button" onclick="javascript:history.back()-1;"value="返回上一页">
<table border="1px" cellpadding="0" cellspacing="0">
    <tr>
        <td>序号</td>
        <td>商品名</td>
        <td>单价</td>
        <td>购买数量</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${cartList}" var="cart" varStatus="i">
        <tr <c:if test="${i.index%2 == 0}">
            bgcolor="#a9a9a9"
        </c:if>>
            <td>${cart.cid}</td>
            <td>${cart.product.pname}</td>
            <td>${cart.product.price}</td>
            <td>${cart.quantity}</td>
            <td>
                <a href="/cart/updateCartQuantity?pid=${cart.product.pid}&quantity=+1">数量加</a>
                <a  href="/cart/updateCartQuantity?pid=${cart.product.pid}&quantity=-1">数量减</a>
                <a href="/cart/deleteCart?pid=${cart.product.pid}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<table>
    <tr>
        <td><a href="/cart/getAllCart?currentPage=1">首页</a></td>
        <td><a href="/cart/getAllCart?currentPage=${pages.getPrePage()}">上一页</a></td>
        <c:forEach items="${pages.getPageNum()}" var="num">
            <td><a href="/cart/getAllCart?currentPage=${num}">[${num}]</a></td>
        </c:forEach>
        <td><a href="/cart/getAllCart?currentPage=${pages.getNextPage()}">下一页</a></td>
        <td><a href="/cart/getAllCart?currentPage=${pages.getTotalPage()}">尾页</a></td>
    </tr>
</table>
</body>
</html>
