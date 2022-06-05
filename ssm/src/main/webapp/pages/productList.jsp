<%--
  Created by IntelliJ IDEA.
  User: alum
  Date: 2022/6/5
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>商品管理</h1>
<input type="button" onclick="javascript:history.back()-1;"value="返回上一页"><br>
<div>
    <form action="/product/getAllProductAdmin" method="get">
        请输入姓名<input type="text" value="${name}" name="name">
        <input type="submit" value="搜索">
    </form><br>
    <a href="/pages/addProduct.jsp">添加商品</a>
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
                    <a href="/product/toUpdateProduct?pid=${product.pid}">修改商品</a>
                    <a href="/product/deleteProduct?pid=${product.pid}">删除商品</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <table>
        <tr>
            <td><a href="/product/getAllProductAdmin?name=${name}&currentPage=1">首页</a></td>
            <td><a href="/product/getAllProductAdmin?name=${name}&currentPage=${pages.getPrePage()}">上一页</a></td>
            <c:forEach items="${pages.getPageNum()}" var="num">
                <td><a href="/product/getAllProductAdmin?name=${name}&currentPage=${num}">[${num}]</a></td>
            </c:forEach>
            <td><a href="/product/getAllProductAdmin?name=${name}&currentPage=${pages.getNextPage()}">下一页</a></td>
            <td><a href="/product/getAllProductAdmin?name=${name}&currentPage=${pages.getTotalPage()}">尾页</a></td>
        </tr>
    </table>
</div>
</body>
</html>
