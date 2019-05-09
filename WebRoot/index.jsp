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
<title>南华汽车网</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/nhcar.js"></script>
<script language="javascript" src="js/banner.js"></script>
</head>

<body>
<c:import url="header"/>
<div id="banner">
    <div id="banner-content">
        <ul class="bannerlist">
            <li ><a href="#"><img src="images/banner1.jpg" /></a></li>
            <li><a href="#"><img src="images/banner2.jpg" /></a></li>
            <li><a href="#"><img src="images/banner3.jpg" /></a></li> 
        </ul>
        <a href="#" id="leftarrow">left</a>
        <a href="#" id="rightarrow">right</a>
    </div>
 </div>
<div id="main">
	<div id="content">
        <div id="subcategory">
            <h2>品牌：</h2>
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
            <div class="clear"></div>
            <a href="#" class="more">more</a>
        </div>
        
        <div class="homeplist" id="hotplist">
        <h2><a href="#">more</a>热卖车型</h2>
          <ul>
          <c:forEach items="${hotProductList}" var="product">
              <li><a href="product?pid=${product.pid}"><img src="uploads/${product.ppic}" /></a>
                <h3><a href="product?pid=${product.pid}">${product.pname}</a></h3>
                <p><a href="addcart?pid=${product.pid}">立即抢购</a>RMB:${product.pprice}</p>
              </li>
          </c:forEach>
          </ul>
        </div>
        <div class="homeplist" id="newplist">
        <h2><a href="#">more</a>新车上市</h2>
        <ul>
          <c:forEach items="${newProductList}" var="product">
              <li><a href="product?pid=${product.pid}"><img src="uploads/${product.ppic}" /></a>
                <h3><a href="product?pid=${product.pid}">${product.pname}</a></h3>
                <p><a href="addcart?pid=${product.pid}">立即抢购</a>RMB:${product.pprice}</p>
              </li>
          </c:forEach>
        </ul>
        </div>
        <div class="homeplist" id="cheapplist">
        <h2><a href="#">more</a>促销车型</h2>
        <ul>
          <c:forEach items="${cheapProductList}" var="product">
              <li><a href="product?pid=${product.pid}"><img src="uploads/${product.ppic}" /></a>
                <h3><a href="product?pid=${product.pid}">${product.pname}</a></h3>
                <p><a href="addcart?pid=${product.pid}">立即抢购</a>RMB:${product.pprice}</p>
              </li>
          </c:forEach>
        </ul>
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
