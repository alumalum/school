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
    <h1>用户列表</h1>
    <form action="/user/getAllUser" method="get">
        请输入姓名<input type="text" value="${name}" name="name">
        <input type="submit" value="搜索">
    </form>
    <div class="tableMain">
        <table border="1px" cellpadding="0" cellspacing="0">
            <tr>
                <td>序号</td>
                <td>主键</td>
                <td>姓名</td>
                <td>电话</td>
                <td>密码</td>
                <td>真实姓名</td>
                <td>地址</td>
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
                    <td>${user.realName}</td>
                    <td>${user.address}</td>
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
    </div>

    <div class="page">
			<span class="page_num">
                <a href="/user/getAllUser?name=${name}&currentPage=1">首页</a>
				<a href="/user/getAllUser?name=${name}&currentPage=${pages.getPrePage()}"
                   class="pn_prev">&lt;&lt;上一页 </a>
                <c:forEach items="${pages.getPageNum()}" var="num">
                    <a href="/user/getAllUser?name=${name}&currentPage=${num}">[${num}]</a>
                </c:forEach>
				<a href="/user/getAllUser?name=${name}&currentPage=${pages.getNextPage()}"
                   class="pn_next">下一页&gt;&gt;</a>
                <a href="/user/getAllUser?name=${name}&currentPage=${pages.getTotalPage()}">尾页</a>
			</span>
    </div>
</div>
</div>
