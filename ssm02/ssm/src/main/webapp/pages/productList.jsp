<%--
  Created by IntelliJ IDEA.
  User: alum
  Date: 2022/6/5
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="main.jsp"></jsp:include>
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    function addStock(pid){
        var nums = $("#num").val();
        $.ajax({
            url: "/product/updateProductStock",
            type: "post",
            data: {"num": nums,"pid":pid},
            success(){
                location.reload();
            }
        })
    }
</script>
<div class="menus_right">
    <h1>商品管理</h1>
    <div>
        <form action="/product/getAllProductAdmin" method="get">
            请输入姓名<input type="text" value="${name}" name="name">
            <input type="submit" value="搜索">
        </form>
        <br>
        <a href="/pages/addProduct.jsp">添加商品</a>
    </div>
    <div class="tableMain">
        <table border="1px" cellpadding="0" cellspacing="0">
            <tr>
                <td>序号</td>
                <td>商品名</td>
                <td>单价</td>
                <td>图片</td>
                <td>库存</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${productList}" var="product" varStatus="i">
                <tr <c:if test="${i.index%2 == 0}">
                    bgcolor="#a9a9a9"
                </c:if>>
                    <td>${i.count}</td>
                    <td>${product.pname}</td>
                    <td>${product.price}</td>
                    <td><img src="/uploda/${product.fileName}" style="height: 100px;width: 100px"></td>
                    <td>${product.stock}</td>
                    <td>
                        <input type="text" placeholder="请输入要进货的数量" id="num"><input type="button" onclick="addStock(${product.pid})" value="提交"><br>
                        <a href="/product/toUpdateProduct?pid=${product.pid}">修改商品</a>
                        <a href="/product/deleteProduct?pid=${product.pid}">删除商品</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="page">
			<span class="page_num">
                <a href="/product/getAllProductAdmin?name=${name}&currentPage=1&sortId=${sort.id}">首页</a>
				<a href="/product/getAllProductAdmin?name=${name}&currentPage=${pages.getPrePage()}&sortId=${sort.id}"
                   class="pn_prev">&lt;&lt;上一页 </a>
                <c:forEach items="${pages.getPageNum()}" var="num">
                    <a href="/product/getAllProductAdmin?name=${name}&currentPage=${num}&sortId=${sort.id}">[${num}]</a>
                </c:forEach>
				<a href="/product/getAllProductAdmin?name=${name}&currentPage=${pages.getNextPage()}&sortId=${sort.id}"
                   class="pn_next">下一页&gt;&gt;</a>
                <a href="/product/getAllProductAdmin?name=${name}&currentPage=${pages.getTotalPage()}&sortId=${sort.id}">尾页</a>
			</span>
    </div>
</div>
</div>

