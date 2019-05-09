<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<script language="javascript" src="js/register.js"></script>
</head>

<body>
<div id="header">
	<div id="header-content">
        <a href="#" id="logo"><img src="images/logo.gif" alt="南华汽车网" /></a>
        <div id="header-right">
        <ul id="subnav">
            <li class="login"><a href="#">登录</a></li>
            <li class="mobile"><a href="#">手机版</a></li>
            <li class="car"><a href="#">购物车</a></li>
            <li class="message"><a href="#">在线留言</a></li>
        </ul>
        <form id="search">
            <p><label>输入你要搜索的车型名称</label><input type="text"  value="" class="skey"/><input type="submit" value="搜索" class="searchbt" /></p>
            <dl>
                <dt>热门：</dt>
                <dd><a href="#">速腾</a></dd>
                <dd><a href="#">奥迪A3</a></dd>
                <dd><a href="#">宝马X6</a></dd>
                <dd><a href="#">速腾</a></dd>
                <dd><a href="#">奥迪A3</a></dd>
                <dd><a href="#">宝马X6</a></dd>
            </dl>
        </form>
        </div>
      <div id="nav">
        	<div class="catelist">
            	<h2>汽车分类</h2>
            	<ul>
            	  <li><a href="#">大众</a></li>
            	  <li><a href="#">丰田</a></li>
            	  <li><a href="#">吉利</a></li>
            	  <li><a href="#">海马</a></li>
            	  <li><a href="#">奥迪</a></li>
            	  <li><a href="#">劳斯莱斯</a></li>
            	  <li><a href="#">雷克萨斯</a></li>
            	  <li><a href="#">本田</a></li>
            	  <li><a href="#">英菲尼迪</a></li>
            	  <li><a href="#">凯迪拉克</a></li>
            	  <li><a href="#">奇瑞</a></li>
              </ul>
       	  </div>
          <ul id="navlist">
          	<li><a href="#">首页</a></li>
            <li><a href="#">新车上市</a></li>
            <li><a href="#">热销汽车</a></li>
            <li><a href="#">豪车推荐</a></li>
            <li><a href="#">汽车资讯</a></li>
          </ul>
      </div>
    </div>
</div>
<div id="main">
	<div id="content" class="register">
        <div id="loginform">
        <div id="form">
        <h2><a href="login.jsp">立即登录</a>注册</h2>
      	<form  action="adduser.jsp"  method="post"  >
        	<p><input type="text" name="uname" class="txtinfo uname"/>
            <span class="tipinfo">输入用户名</span>
            <span class="errorinfo">不能为空！</span>
            </p>
            <p><input type="password" name="upwd" class="txtinfo upwd"/>
            <span class="tipinfo">输入密码</span>
            <span class="errorinfo">不能为空！</span>
            </p>
            <p><input type="password" name="urepwd" class="txtinfo upwd"/>
            <span class="tipinfo">重新输入密码</span>
            <span class="errorinfo">两次密码不一致！</span>
            </p>
            <p><input type="text"  name="uemail" class="txtinfo uemail"/>
            <span class="tipinfo">输入Email地址</span>
            <span class="errorinfo">不能为空或格式不对！</span>
            </p>
            <p><input type="submit" class="bt" value="注册" /></p>
        </form>
        
      </div>
        
        </div>
    </div>
</div>
<div id="footer">
	<ul id="footer-nav">
    	<li><a href="#">免责条款</a></li>
        <li><a href="#">隐私保护</a></li>
        <li><a href="#">咨询热点</a></li>
        <li><a href="#">联系我们</a></li>
        <li><a href="#">公司简介</a></li>
        <li class="last"><a href="#">配送方式</a></li>
    </ul>
    <ul id="footer-intro">
    	<li class="item1">正品保障</li>
        <li class="item2">30天退换货</li>
        <li class="item3">货到付款</li>
        <li class="item4">实物拍摄</li>
        <li class="item5">实时发货</li>
        <li class="item6">会员积分</li>
    </ul>
    <div id="footer-content">
        <p>&copy;2002-2015 南华汽车网（nhcar.com）版权所有，并保留所有权利。ICP备案证书号：粤ICP888888号</p>
        <p>常年法律顾问：南华律师事务所。技术支持：广州锐发计算机科技有限公司</p>
        <p>广州市南华工商学院信息管理专业</p>
    </div>
</div>
<div id="cslist">
	<ul>
    	<li class="qq"><a href="#"><i>qq</i></a></li>
        <li class="tel"><a href="#"><i>tel</i></a></li>
        <li class="weixin"><a href="#"><i>weixin</i></a></li>
        <li class="top"><a href="#"><i>top</i></a></li>
    </ul>
</div>
</body>
</html>
