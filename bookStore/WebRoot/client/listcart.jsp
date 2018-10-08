<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车列表页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align:center">
  <%@include file="/client/head.jsp"  %>
  <br/><br/>
  	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
  		<caption>购物车页面</caption>
  		<tr>
  			<td>书名</td>
  			<td>售价</td>
  			<td>数量</td>
  			<td>小计</td>
  		</tr>
  		<c:forEach var="entry" items="${cart.map}">
  			<tr>
  				<td>${entry.value.book.name}</td>
  				<td>${entry.value.book.price}元</td>
  				<td>${entry.value.quantity}</td>
  				<td>${entry.value.price}元</td>
  			</tr>
  		</c:forEach>
  		<tr>
  			<td colspan="">合计</td>
  			<td colspan="2">${cart.price}元</td>
  		</tr>
  		
  	</table>
  	<a href="${pageContext.request.contextPath}/OrderServlet">生成订单</a>
    
  </body>
</html>
