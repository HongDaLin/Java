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
<title>注册--南华汽车网</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/nhcar.js"></script>
</head>

<body>
<c:import url="header"/>
<div id="main">
	<div id="content">
        <div id="loginform">
        <div id="form">
        <h2><a href="#">立即注册</a>登录</h2>
      	<form  action="checkuser" method="post">
        	<p><input type="text"  name="uname" class="txtinfo uname"/></p>
            <p><input type="password"  name="upwd" class="txtinfo upwd"/></p>
            <p><input type="submit" class="bt" value="登录" /></p>
        </form>
        
      </div>
        
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

