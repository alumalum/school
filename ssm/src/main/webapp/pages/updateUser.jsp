<%--
  Created by IntelliJ IDEA.
  User: alum
  Date: 2022/6/3
  Time: 16:41
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
<form action="/user/updateUser" method="post">
    <input type="hidden" name="uid" value="${requestScope.user.uid}">
    用户名:<input type="text" name="uname" value="${requestScope.user.uname}"><br>
    电 话:<input type="text" name="telephone" value="${requestScope.user.telephone}"><br>
    密 码:<input type="password" name="password" value="${requestScope.user.password}"><br>
    创建时间:<input type="text" name="myTime" value="<fmt:formatDate value="${requestScope.user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>"><br>
    <select name="rid" <c:if test="${user.rid == 2}"> disabled="disabled" </c:if>>
        <c:forEach items="${rolesList}" var="roles">
        <option value="${roles.id}" <c:if test="${roles.id == requestScope.user.rid}">selected="selected"</c:if> >${roles.name}</option>
        </c:forEach>
    </select><br>
    <input type="submit" value="提交">
</form>
<input type="button" onclick="javascript:history.back()-1;"value="返回上一页"><br>
</body>
</html>
