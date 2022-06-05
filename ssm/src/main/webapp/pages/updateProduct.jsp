<%--
  Created by IntelliJ IDEA.
  User: alum
  Date: 2022/6/3
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("[name=pname]").blur(function () {
            var name = $("[name=pname]").val();
            $.ajax({
                url: "/product/checkProductName",
                type: "post",
                data: {"name": name},
                dataType: "json",
                success: function (data) {
                    if (data) {
                        $("#mySpan").html("<img src='/images/x.png'/>商品名已存在")
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
<form action="/product/updateProduct" method="post" enctype="multipart/form-data">
    <input type="hidden" name="pid" value="${requestScope.product.pid}">
    商品名:<input type="text" name="pname" value="${requestScope.product.pname}"><span id="mySpan"></span><br>
    单 价:<input type="text" name="price" value="${requestScope.product.price}"><br>
    商品原图片:<img src="/images/${requestScope.product.fileName}" style="height: 100px;width: 100px"><br>
    上传图片<input type="file" name="files"><br>
    <input type="submit" value="提交" id="sub">
</form>
<input type="button" onclick="javascript:history.back()-1;"value="返回上一页"><br>
</body>
</html>
