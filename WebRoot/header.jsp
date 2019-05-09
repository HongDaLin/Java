<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="header">
	<div id="header-content">
        <a href="#" id="logo"><img src="images/logo.gif" alt="南华汽车网" /></a>
        <div id="header-right">
        <ul id="subnav">
        <c:choose>
        <c:when test="${not empty sessionScope.sUser}">
        <li class="login">${sessionScope.sUser.uname}您好！<a href="logout">注销</a></li>
        </c:when>
        <c:otherwise>
        	<li class="login"><a href="login">登录</a></li>
        </c:otherwise>
        </c:choose>
            <li class="mobile"><a href="#">手机版</a></li>
            <li class="car"><a href="showcart">购物车</a></li>
            <li class="message"><a href="message">在线留言</a></li>
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
            	<c:forEach items="${catelist}" var="cate">
            	  <li><a href="productlistindex?cid=${cate.cid}">${cate.cname}</a></li>
            	</c:forEach>
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
