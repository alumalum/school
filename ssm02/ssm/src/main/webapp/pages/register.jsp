<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alumalum
  Date: 2022/6/11
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册页面</title>
    <link rel="stylesheet" href="../css/base.css">
    <link rel="stylesheet" href="../css/register.css">
    <script src="../js/reg.js"></script>
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
</head>

<body>
<div class="w">
    <div class="header">
        <div class="logo">
            <a href="../index.jsp">
                <img src="img/logo.png" alt="">
            </a>
        </div>
    </div>
    <div class="registerarea">
        <h3>
            注册新用户
            <em>
                我有账号，去<a href="/login.jsp">登陆</a>
            </em>
        </h3>
        <div class="reg_form">
            <form action="/user/addUser">
                <ul>
                    <li>
                        <label>昵称:</label>
                        <input type="text" class="inp" name="uname">
                        <span class="mySpan" id="mySpan"></span>
                    </li>
                    <li>
                        <label>手机号:</label>
                        <input type="text" class="inp" name="telephone">
                        <span class=""></span>
                    </li>
                    <li>
                        <label for="qq">真实姓名:</label>
                        <input type="text" class="inp" id="qq" name="realName">
                        <span class=""></span>
                    </li>
                    <li>
                        <label for="qq">地址:</label>
                        <input type="text" class="inp" id="nc" name="address">
                        <span class=""></span>
                    </li>
                    <li>
                        <label for="">登陆密码:</label>
                        <input type="text" class="inp" id="pwd">
                        <span class=""></span>
                    </li>
                    <li>
                        <label for="">确认密码:</label>
                        <input type="text" class="inp" id="sure" name="password">
                        <span class=""></span>
                    </li>
                    <li>
                        <label for="">角色:</label>
                        <select name="rid">
                            <c:forEach items="${rolesList}" var="roles">
                                <option value="${roles.id}">${roles.name}</option>
                            </c:forEach>
                        </select>
                        <span class=""></span>
                    </li>
                    <li>
                        <input type="submit" value="完成注册" class="over" id="sub">
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
</body>

</html>