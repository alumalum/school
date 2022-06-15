<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <!-- 引入css文件 -->
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/base.css">
    <link rel="stylesheet" href="../css/index.css">
    <script src="../js/animate.js"></script>
    <script src="../js/index.js"></script>
    <!-- 引入网页图标    -->
    <style>
        .in {
            align-items: center;
            text-align: center;
            margin: 50px;
        }
        .in i{
            padding-top: 28px;
            display: block;
        }
    </style>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url: "/cart/getUserCartCount",
                type: "post",
                data: {},
                dataType: "json",
                success: function (data) {
                    $(".count").html(data);
                }
            })
        })
    </script>
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
                <li>
                    <a href="/orders/getOrders">我的订单</a>
                </li>
                <c:if test="${sessionScope.user != null}">
                    <li class="xian">|</li>
                    <li>
                        <a href="/favorites/getAllFavorites">我的收藏夹</a>
                    </li>
                    <li class="xian">|</li>
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
<div class="header w">

    <div class="logo">
        <h1>
            <a href="index.jsp" title="亚马逊中国">亚马逊中国</a>
        </h1>
    </div>
    <!-- search  -->
    <div class="search">
        <input type="text" class="text" value="请搜索内容">
        <button class="btn">搜索</button>
    </div>
    <!-- hotwrods -->
    <div class="hotwrods">
        <a href="#" class="one">优惠购首发</a>
        <a href="#">亿元优惠</a>
        <a href="#">9.9元团购</a>
        <a href="#">满99减30</a>
        <a href="#">办公用品</a>
        <a href="#">电脑</a>
        <a href="#">通信</a>
    </div>
    <div class="shopcar">
        <i class="car"></i> <a href="/cart/getAllCart">我的购物车</a><i class="arrow"></i>
        <div class="count">416</div>
    </div>
</div>
<div class="nav">
    <div class="w">
        <div class="dropdown fl">
            <div class="dt">全部商品分类

            </div>
        </div>
        <div class="navitems fl">
            <ul>
                <li><a href="#">服装城</a></li>
                <li><a href="#">美妆馆</a></li>
                <li><a href="#">生鲜超市</a></li>
                <li><a href="#">全球购</a></li>
                <li><a href="#">闪购</a></li>
                <li><a href="#">团购</a></li>
                <li><a href="#">拍卖</a></li>
                <li><a href="#">有趣</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="w">
    <div class="main">
        <div class="in">
            <h1>修改个人信息</h1>
            <form action="/user/updateUser" method="post">
               <i> <input type="hidden" name="uid" value="${requestScope.user.uid}"></i>
                <i> 用户名:<input type="text" name="uname" value="${requestScope.user.uname}"><br></i>
                <i> 电 话:<input type="text" name="telephone" value="${requestScope.user.telephone}"><br></i>
                <i>  密 码:<input type="password" name="password" value="${requestScope.user.password}"><br></i>
                <i>  真实名字:<input type="text" name="realName" value="${requestScope.user.realName}"><br></i>
                <i>  地 址:<input type="text" name="address" value="${requestScope.user.address}"><br></i>
                <i>  创建时间:<input type="text" name="myTime"
                            value="<fmt:formatDate value="${requestScope.user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>"><br></i>
                <i>   <select name="rid" <c:if test="${user.rid == 2}"> disabled="disabled" </c:if>>
                    <c:forEach items="${rolesList}" var="roles">
                        <option value="${roles.id}"
                                <c:if test="${roles.id == requestScope.user.rid}">selected="selected"</c:if> >${roles.name}</option>
                    </c:forEach>
                </select><br></i>
                <i> <input type="submit" value="提交"></i>
            </form>
        </div>
    </div>
    <div class="footer">
        <div class="w">
            <div class="mod_service">
                <ul>
                    <li>
                        <i class="mod-service-icon mod_service_zheng"></i>
                        <div class="mod_service_tit">
                            <h5>正品保障</h5>
                            <p>正品保障，提供发票</p>
                        </div>
                    </li>
                    <li>
                        <i class="mod-service-icon mod_service_kuai"></i>
                        <div class="mod_service_tit">
                            <h5>极速物流</h5>
                            <p>极速物流，极速送达</p>
                        </div>
                    </li>
                    <li><i class="mod-service-icon mod_service_bao"></i>
                        <div class="mod_service_tit">
                            <h5>无忧售后</h5>
                            <p>7天无理由送达</p>
                        </div>
                    </li>
                    <li><i class="mod-service-icon mod_service_te"></i>
                        <div class="mod_service_tit">
                            <h5>特色服务</h5>
                            <p>私人定制、家电套餐</p>
                        </div>
                    </li>
                    <li><i class="mod-service-icon mod_service_bang"></i>
                        <div class="mod_service_tit">
                            <h5>帮助中心</h5>
                            <p>您的购物指南</p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</body>
</html>

