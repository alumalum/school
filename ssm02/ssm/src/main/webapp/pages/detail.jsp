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
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/base.css">
    <link rel="stylesheet" href="../css/detail.css">
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
            <a href="../index.jsp" title="亚马逊中国">亚马逊中国</a>
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
        <i class="car"></i>  <a href="/cart/getAllCart">我的购物车</a><i class="arrow"></i>
        <div class="count">416</div>
    </div>
</div>
<div class="nav">
    <div class="w">
        <div class="dropdown fl">
            <div class="dt">全部商品分类
            </div>
        </div>
    </div>
    <div class="navitems fl">
        <ul>
            <c:forEach items="${sortList}" var="sort">
                <li><a href="/product/getAllProduct?sortId=${sort.id}">${sort.name}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>
</div>
<div class="de_container w">
    <div class="crumb_wrap">
        <a href="#">商品详细信息</a>
    </div>
    <div class="product_intro clearfix">
        <div class="preview_wrap fl">
            <div class="preview_img">
                <img src="../uploda/${product.fileName}" alt="">
            </div>
        </div>
        <div class="itemInfo_wrap fr">
            <div class="sku_name">
                ${product.pname}
            </div>
            <div class="summary">
                <dl class="summary_price">
                    <dt>价格</dt>
                    <dd>
                        <i class="price">￥${product.price} </i>
                        <div class="remark">累计评价612188</div>
                    </dd>
                </dl>
                <dl class="summary_promotion">
                    <dt>促销</dt>
                    <dd>
                        <em>加购价</em> 满999.00另加20.00元，或满1999.00另加30.00元，或满2999.00另加40.00元，即可在购物车换 购热销商品 详情 》

                    </dd>
                </dl>
                <dl class="summary_support">
                    <dt>支持</dt>
                    <dd>以旧换新，闲置手机回收 4G套餐超值抢 礼品购</dd>
                </dl>
                <div class="choose_btns">
                    <div class="choose_amount">
                        <input type="text" value="1">
                        <a href="javascript:;" class="add">+</a>
                        <a href="javascript:;" class="reduce">-</a>
                    </div>
                    <a href="/cart/addCart?quantity=1&pid=${product.pid}" class="addcar">加入购物车</a>
                </div>
            </div>
        </div>
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