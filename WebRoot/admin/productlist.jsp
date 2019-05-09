<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>汽车列表</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="wrapper">
	<div id="main">
	<form>
		<table width="200" border="0" cellpadding="0" cellspacing="3" class="datatb">
		<caption>汽车列表</caption>
  <tr>
    <th scope="col">ID</th>
    <th scope="col">名称</th>
    <th scope="col">缩略图</th>
	<th scope="col">品牌</th>
    <th scope="col">操作</th>
    </tr>
   <c:forEach items="${productlist}" var="product">
  <tr class="even">
    <td>${product.pid}</td>
    <td>${product.pname}</td>
    <td><img src="../uploads/${product.ppic}" class="smallpic" /></td>
	<td>${product.cname}</td>
    <td><a href="productdelete?pid=${product.pid}&ppic=${product.ppic}"><img src="images/icon_delete.gif" />删除</a>
    <a href="productmodify?pid=${product.pid}"><img src="images/icon_edit.gif" />修改</a><a href="#">添加flash展示</a></td>
    </tr>
   </c:forEach>
 
</table>
</form>
<div class="pagnav">${pagenav}</div>
	</div>
</div>
</body>
</html>
