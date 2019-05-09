<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台登录</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="wrapper">
	<form action="login" method="post">
		<p><label>管理员账号：</label><input name="aname" type="text" /></p>
		<p><label>密码：</label><input name="apwd" type="password" /></p>
		<p><label>验证码：</label><img src="#" alt="验证码" width="30"/><input name="" type="text"  class="checkno"/></p>
		<p class="bt"><input name="" type="submit"  value="登录"/></p>
	</form>
</div>
</body>
</html>
