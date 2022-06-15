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
    <title>亚马逊中国-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
    <meta name="description"
          content="亚马逊中国.COM-专业的综合网上购物商城,销售家电、数码通讯、电脑、家居百货、服装服饰、母婴、图书、食品等数万个品牌优质商品.便捷、诚信的服务，为您提供愉悦的网上购物体验!"/>

    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="../css/list.css">
    <style type="text/css">
        .menus {
            width: 100%;
            height: 100%;
            display: flex;
            justify-content: space-between;
        }

        .menus_left {
            width: 10%;
            padding: 0 25px;
            line-height: 45px;
            font-size: 16px;
            min-height: 100%;
            background-color: #9bcae6;
        }

        .menus_left ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
        }

        .menus_left ul li {
        }

        .menus_left ul li a {
            display: block;
            color: white;
            text-align: center;
            padding: 23px;
            text-decoration: none;
        }

        .menus_right {
            width: 90%;
            text-align: center;
        }

        .menus_right h1 {
            margin: 10px 0px;
        }

        .menus_right .tableMain {
            text-align: center;
            align-items: center;
            margin: 25px 0%;
        }

        .menus_right table {
            border-collapse: collapse;
            margin: 0 auto;
            text-align: center;
        }

        .menus_right table td, table th {
            border: 1px solid #cad9ea;
            color: #666;
            height: 30px;
        }

        .menus_right table tr:nth-child(odd) {
            background: #fff;
        }

        .menus_right table tr:nth-child(even) {
            background: #F5FAFA;
        }

        .in i {
            padding-top: 28px;
            display: block;
        }
    </style>

</head>

<body>
<div class="shortcut">
    <div class="w">
        <div class="fl">
            <ul>
                <li>亚马逊中国欢迎您!</li>&nbsp;&nbsp;&nbsp;
                <li>
                    <c:if test="${sessionScope.user == null}">
                        <a href="/login.jsp">请登录</a>
                    </c:if>
                    <c:if test="${sessionScope.user != null}">
                        <a href="#">用户：${sessionScope.user.uname}</a>
                    </c:if>
                    <a href="/user/toAdd" class="one">免费注册</a></li>
            </ul>
        </div>
        <div class="fr">
            <ul>
                <li><a href="/user/getUserInfo">我的个人信息</a></li>
                <li class="xian">|</li>
                <c:if test="${sessionScope.user != null}">
                    <li>
                        <a href="/user/getUserByUserId">修改个人信息</a>
                    </li>
                    <li class="xian">|</li>
                    <li>
                        <a href="/user/loginOut">退出登录</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</div>
<div class="menus">
    <div class="menus_left">
        <ul>
            <li><a href="/user/getAllUser">用户管理</a></li>
            <li><a href="/product/getAllProductAdmin">商品管理</a></li>
            <li><a href="/orders/getOrders?id=1">订单管理</a></li>
            <li><a href="/user/approveUserList">待审批列表</a></li>
            <li><a href="/orders/getOrders?id=2">退货处理</a></li>
        </ul>
    </div>

</body>

</html>