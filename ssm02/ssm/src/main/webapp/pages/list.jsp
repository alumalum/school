<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alumalum
  Date: 2022/6/11
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>列表页</title>
    <meta name="description"
          content="亚马逊中国.COM-专业的综合网上购物商城,销售家电、数码通讯、电脑、家居百货、服装服饰、母婴、图书、食品等数万个品牌优质商品.便捷、诚信的服务，为您提供愉悦的网上购物体验!"/>
    <!-- 引入css文件 -->
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/base.css">
    <link rel="stylesheet" href="../css/list.css">
    <!-- 引入网页图标    -->
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
<!-- 顶部快捷导航start -->
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
            <a href="../index.jsp" title="亚马逊中国">亚马逊中国</a>
        </h1>
    </div>
    <div class="sk">
        <img src="../uploda/sk.png" alt="">
    </div>
    <div class="search">
        <input type="text" class="text" value="请搜索内容">
        <button class="btn">搜索</button>
    </div>
    <div class="hotwrods">
        <a href="#" class="one">优惠购首发</a>
        <a href="#">亿元优惠</a>
        <a href="#">9.9元团购</a>
        <a href="#">满99减30</a>
        <a href="#">办公用品</a>
        <a href="#">电脑</a>
        <a href="#">通信</a>
    </div>
    <!-- shopcar -->
    <div class="shopcar">
        <i class="car"></i> <a href="/cart/getAllCart">我的购物车</a><i class="arrow"></i>
        <div class="count">416</div>
    </div>
</div>
<!-- header结束 -->
<!-- nav开始 -->
<div class="nav">
    <div class="w">
        <div class="sk_con fl">
            <ul>
                <c:forEach items="${sortList}" var="sort">
                    <li><a href="/product/getAllProduct?sortId=${sort.id}">${sort.name}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<div class="sk_container w">
    <div class="sk_bd clearfix">
        <ul>
            <c:forEach items="${productList}" var="product">
                <li class="sk_goods">
                    <a href="/product/getProductById?pid=${product.pid}">
                        <img src="../uploda/${product.fileName}">
                        <h5 class="sk_goods_title">${product.pname}</h5>
                    </a>
                    <p class="sk_goods_price"><em>${product.price}</em>
                    </p>
                    <p style="margin-left: 225px;height: 50px;
                    text-align: center;line-height: 50px;font-size: 20px;"><a href="/favorites/addCollect?pid=${product.pid}" style="color: #f24349">收藏</a></p>
                    <a href="/product/getProductById?pid=${product.pid}" class="sk_goods_buy">立即抢购</a>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="page">
			<span class="page_num">
                <a href="/product/getAllProduct?name=${name}&currentPage=1&sortId=${sort.id}">首页</a>
				<a href="/product/getAllProduct?name=${name}&currentPage=${pages.getPrePage()}&sortId=${sort.id}" class="pn_prev">&lt;&lt;上一页 </a>
                <c:forEach items="${pages.getPageNum()}" var="num">
                    <a href="/product/getAllProduct?name=${name}&currentPage=${num}&sortId=${sort.id}">[${num}]</a>
                </c:forEach>
				<a href="/product/getAllProduct?name=${name}&currentPage=${pages.getNextPage()}&sortId=${sort.id}" class="pn_next">下一页&gt;&gt;</a>
                <a href="/product/getAllProduct?name=${name}&currentPage=${pages.getTotalPage()}&sortId=${sort.id}">尾页</a>
			</span>
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
</body>
</html>