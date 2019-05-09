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
<title>无标题文档</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
</head>

<body id="frmain">

	<div id="main">
    	<div class="sharp color1">
           <div class="content">
           <form action="productmodify" method="post" enctype="multipart/form-data">
           	<div class="tbl">
           		<h1><strong>当前位置：</strong>添加产品</h1>
               
                <div class="optlist"><a href="#"><img src="images/tb.gif" />产品列表</a></div>
                <table border="0" cellspacing="0" class="tbledit">
  					
                  <tr>
                    <th width="180" align="right" scope="row">*产品名称：</th>
                    <td align="left">
                      <input type="text" name="pname" id="" class="longtxt" value="${product.pname}"  /><span class="errorinfo" id="ckntitle">请输入标题</span>
                    </td>
                  </tr>
                  <tr>
                    <th width="180" align="right" scope="row">*价格：</th>
                    <td align="left">
                      <input type="text" name="pprice" id="" class="longtxt" value="${product.pprice}"  /><span class="errorinfo" id="ckntitle">请输入标题</span>
                    </td>
                  </tr>
                  <tr>
                    <th width="180" align="right" scope="row">*品牌：</th>
                    <td align="left">
                    <select name="pcid">
                    <option value="0">请选择......</option>
                    <c:forEach items="${catelist}" var="cate">
                    <option value="${cate.cid}" <c:if test="${product.pcid==cate.cid}"> selected="selected"</c:if>>${cate.cname}</option>
                    </c:forEach>
                    </select>
                    <span class="errorinfo" id="ckntitle">请输入标题</span>
                    </td>
                  </tr>
                  <tr>
                    <th width="180" align="right" scope="row">销售类型：</th>
                    <td align="left">
                    <input type="checkbox" name="phot" value="1" <c:if test="${product.phot>0}"> checked="checked"</c:if>/>热卖车型
                    <input type="checkbox" name="pnew" value="1" <c:if test="${product.pnew>0}"> checked="checked"</c:if>/>新车车型
                    <input type="checkbox" name="pcheap" value="1" <c:if test="${product.pcheap>0}"> checked="checked"</c:if>/>促销车型
                    </td>
                  </tr>
             	<tr>
                     <th width="180" align="right" scope="row">*图片：</th>
                    <td align="left">
                     <input type="file" name="file" /><img src="../uploads/${product.ppic}" alt="" />
                     <input type="hidden" name="ppic" value="${product.ppic}"/>
                     <input type="hidden" name="pid" value="${product.pid}"/>
                      </td>
                   </tr>
                   <tr>
                    <th width="180" align="right" scope="row">*简介：</th>
                    <td align="left">
                      <textarea class="editcontent" name="pcontent">${product.pcontent}</textarea><span class="errorinfo" id="ckntitle">请输入标题</span>
                    </td>
                  </tr>
                  <tr>
                    <th scope="row">&nbsp;</th>
                    <td align="left"> 
                      <input name="bt" type="submit" value="发布"  class="bt"/></td>
                  </tr>
                </table>
            </div>
            </form>
           </div>
		</div>
	</div>
    
</body>
</html>
