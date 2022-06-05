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
<h1>用户列表</h1>
<input type="button" onclick="javascript:history.back()-1;"value="返回上一页"><br>
<form action="/user/getAllUser" method="get">
    请输入姓名<input type="text" value="${name}" name="name">
    <input type="submit" value="搜索">
</form>
<table border="1px" cellpadding="0" cellspacing="0">
    <tr>
        <td>序号</td>
        <td>主键</td>
        <td>姓名</td>
        <td>电话</td>
        <td>密码</td>
        <td>创建时间</td>
        <td>角色id</td>
        <td>角色名</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="i">
        <tr <c:if test="${i.index%2 == 0}">
            bgcolor="#a9a9a9"
        </c:if>>
            <td>${i.count}</td>
            <td>${user.uid}</td>
            <td>${user.uname}</td>
            <td>${user.telephone}</td>
            <td>${user.password}</td>
            <td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
            <td>${user.rid}</td>
            <td>${user.roles.name}</td>
            <td>
                <a href="/user/getUserById?uid=${user.uid}">修改</a>
        <a href="/user/deleteUserById?uid=${user.uid}">删除</a>
        </td>
        </tr>
    </c:forEach>
</table>
<table>
    <tr>
        <td><a href="/user/getAllUser?name=${name}&currentPage=1">首页</a></td>
        <td><a href="/user/getAllUser?name=${name}&currentPage=${pages.getPrePage()}">上一页</a></td>
        <c:forEach items="${pages.getPageNum()}" var="num">
            <td><a href="/user/getAllUser?name=${name}&currentPage=${num}">[${num}]</a></td>
        </c:forEach>
        <td><a href="/user/getAllUser?name=${name}&currentPage=${pages.getNextPage()}">下一页</a></td>
        <td><a href="/user/getAllUser?name=${name}&currentPage=${pages.getTotalPage()}">尾页</a></td>
    </tr>
</table>
</body>
</html>
