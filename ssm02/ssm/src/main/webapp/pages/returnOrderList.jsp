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
<jsp:include page="main.jsp"></jsp:include>
<div class="menus_right">
    <h1>退货列表</h1>
    <div class="tableMain">
        <table border="1px" cellpadding="0" cellspacing="0">
            <tr>
                <td>订单号</td>
                <td>总价</td>
                <td>创建时间</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${ordersList}" var="orders">
                <tr>
                    <td>${orders.oid}</td>
                    <td>${orders.totalMoney}</td>
                    <td><fmt:formatDate value="${orders.createTime}"
                                        pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td>
                        <a href="/ordersDetail/getDetail?id=${orders.oid}">查看详细订单</a>
                        <c:if test="${orders.state == '退货'}">
                            <a href="/orders/updateOrdersState?oid=${orders.oid}&id=3">同意退货</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="page">
			<span class="page_num">
                <a href="/orders/getOrders?currentPage=1&id=2">首页</a>
				<a href="/orders/getOrders?currentPage=${pages.getPrePage()}&id=2"
                   class="pn_prev">&lt;&lt;上一页 </a>
                <c:forEach items="${pages.getPageNum()}" var="num">
                    <a href="/orders/getOrders?currentPage=${num}&id=2">[${num}]</a>
                </c:forEach>
				<a href="/orders/getOrders?currentPage=${pages.getNextPage()}&id=2"
                   class="pn_next">下一页&gt;&gt;</a>
                <a href="/orders/getOrders?currentPage=${pages.getTotalPage()}&id=2">尾页</a>
			</span>
    </div>
</div>
</div>
