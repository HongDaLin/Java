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
<title>购物车--南华汽车网</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/nhcar.js"></script>
</head>

<body>
<c:import url="header"/>
<div id="main">
	<div id="content">
    <h2 class="title">购物车明细</h2>
        	<div id="cart">
				<form  action="updatecart" method="post">
			  <table border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <th scope="col">汽车图片</th>
                    <th scope="col">名称</th>
                    <th scope="col">数量</th>
                    <th scope="col">单价</th>
                    <th scope="col">小结</th>
                    <th scope="col">操作</th>
                  </tr>
                  <c:forEach items="${cartlist}" var="cart">
                  <tr>
                    <td><a href="#"><img src="uploads/${cart.ppic}"/></a></td>
                    <td><a href="#">${cart.pname}</a> </td>
                    <td><input name="nums" type="text" value="${cart.cnum}" class="stxt" />
                    <input name="cids" type="hidden" value="${cart.cid}" class="stxt" />
                    </td>
                    <td>${cart.pprice}</td>
                    <td>${cart.pprice*cart.cnum}</td>
                    <td><a href="#">删除</a></td>
                  </tr>
                  </c:forEach>
              </table>
				<div class="cartinfo">
					<p class="total">总金额：${total}</p>
					<p class="orderbt"><input name="" type="submit" value="清空"/><input name="" type="submit" value="更新" class="clearbt"/></p>
					<p class="orderbt"><input name="" type="button" onclick="location.href='index'" value="继续购物"/><input name="" type="submit" value="去购物台" class="enterorder"/></p>
				</div>
				</form>
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
