<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>smarty新闻管理后台</title>
</head>

<frameset rows="*" cols="171,*" frameborder="yes" border="1" framespacing="0">
  <frame src="index?act=left" name="leftFrame" scrolling="yes" noresize="noresize" id="leftFrame" />
  <frameset rows="50,*" cols="*" framespacing="0" frameborder="no" border="0">
    <frame src="index?act=header" name="topFrame" scrolling="no" noresize="noresize" id="topFrame"/>
    <frame src="index?act=main" name="mainFrame" id="mainFrame" />
  </frameset>
</frameset>
<noframes><body>
</body>
</noframes></html>
