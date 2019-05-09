<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左边导航</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="js/sidebar.js"></script>
</head>

<body>
<div id="sidebar">
	<h2>控制面版</h2>
	<div id="list">
		<h3 onclick="explodeItems('newstitle','news')" id="newstitle">新闻管理</h3>
		<ul id="news">
			<li><a href="addnews.html" target="mainFrame">添加新闻</a></li>
			<li><a href="newslist." target="mainFrame">新闻列表</a></li>
			<li><a href="newsflashes.html" target="mainFrame">Flash列表</a></li>
		</ul>
		<h3 onclick="explodeItems('admintitle','admin')" id="admintitle">管理员设置</h3>
		<ul id="admin">
			<li><a href="#" target="mainFrame">添加新闻</a></li>
			<li><a href="#" target="mainFrame">新闻列表</a></li>
		</ul>
	</div>
</div>
</body>
</html>
