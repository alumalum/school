<%--
  Created by IntelliJ IDEA.
  User: alum
  Date: 2022/6/4
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>网上订餐</title>
</head>
<body>
<h2>网上订餐系统</h2>
<div>
    <a href="/cart/getAllCart">购物车</a>&nbsp;&nbsp;
    <c:if test="${sessionScope.user == null}"><a href="../login.jsp">登录</a>&nbsp;&nbsp;</c:if>
    <c:if test="${sessionScope.user != null}">
        <a href="/pages/main.jsp">个人中心</a>&nbsp;&nbsp;
        <a href="/user/loginOut">退出登录</a>&nbsp;&nbsp;</c:if>
    <a href="/user/toAdd">注册</a>
</div>
<div>
    <form action="/product/getAllProduct" method="get">
        请输入姓名<input type="text" value="${name}" name="name">
        <input type="submit" value="搜索">
    </form>
</div>
<div>
    <table border="1px" cellpadding="0" cellspacing="0">
        <tr>
            <td>序号</td>
            <td>商品名</td>
            <td>单价</td>
            <td>图片</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${productList}" var="product" varStatus="i">
            <tr <c:if test="${i.index%2 == 0}">
                bgcolor="#a9a9a9"
            </c:if>>
                <td>${i.count}</td>
                <td>${product.pname}</td>
                <td>${product.price}</td>
                <td><img src="/images/${product.fileName}" style="height: 100px;width: 100px"></td>
                <td>
                    <a href="/cart/addCart?quantity=1&pid=${product.pid}">加入购物车</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <table>
        <tr>
            <td><a href="/product/getAllProduct?name=${name}&currentPage=1">首页</a></td>
            <td><a href="/product/getAllProduct?name=${name}&currentPage=${pages.getPrePage()}">上一页</a></td>
            <c:forEach items="${pages.getPageNum()}" var="num">
                <td><a href="/product/getAllProduct?name=${name}&currentPage=${num}">[${num}]</a></td>
            </c:forEach>
            <td><a href="/product/getAllProduct?name=${name}&currentPage=${pages.getNextPage()}">下一页</a></td>
            <td><a href="/product/getAllProduct?name=${name}&currentPage=${pages.getTotalPage()}">尾页</a></td>
        </tr>
    </table>
</div>
</body>
</html>
