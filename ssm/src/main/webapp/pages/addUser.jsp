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
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("[name=uname]").blur(function () {
            var name = $("[name=uname]").val();
            $.ajax({
                url: "/user/checkName",
                type: "post",
                data: {"name": name},
                dataType: "json",
                success: function (data) {
                    if (data) {
                        $("#mySpan").html("<img src='/images/x.png'/>用户名已存在")
                        $("#sub").attr("disabled","disabled")
                    } else {
                        $("#mySpan").html("<img src='/images/打勾.png' />可以使用")
                        $("#sub").removeAttr("disabled")
                    }
                }
            })
        })
    })
</script>
<form action="/user/addUser" method="post">
    <input type="hidden" name="uid">
    用户名:<input type="text" name="uname"><span id="mySpan"></span><br>
    电 话:<input type="text" name="telephone"><br>
    密 码:<input type="password" name="password"><br>
    创建时间:<input type="text" name="myTime"><br>
    <select name="rid">
        <c:forEach items="${rolesList}" var="roles">
            <option value="${roles.id}">${roles.name}</option>
        </c:forEach>
    </select><br>
    <input type="submit" value="注册" id="sub">
</form>
<input type="button" onclick="javascript:history.back()-1;"value="返回上一页"><br>
</body>
</html>
