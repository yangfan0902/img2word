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
    
    <title>订单明细页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table frame="border" cellpadding="0" cellspacing="0">
    	<caption><h2>订单明细</h2></caption>
    	<tr>
    		<td>书名</td>
    		<td>售价</td>
    		<td>数量</td>
    		<td>应收货款</td>
    	</tr>
    	<c:forEach var="orderitem" items="${order.orderitem}">
    		<tr>
    			<td>${orderitem.book.name}</td>
    			<td>${orderitem.book.price}</td>
    			<td>${orderitem.quantity}</td>
    			<td>${orderitem.price}</td>
    		</tr>
    	</c:forEach>
    	<tr>
    		<td colspan="2">总计应收款</td>
    		<td colspan="2">${order.price}元</td>
    	</tr>
    </table>
    <br/><br/>
    <table frame="border" cellpadding="0" cellspacing="0">
    	<caption><h2>收货人详细信息</h2></caption>
    	<tr>
    		<td>用户</td>
    		<td>电话</td>
    		<td>手机</td>
    		<td>地址</td>
    		<td>邮箱</td>
    	</tr>
    	<tr>
    		<td>${order.user.username}</td>
    		<td>${order.user.phone}</td>
    		<td>${order.user.cellphone}</td>
    		<td>${order.user.address}</td>
    		<td>${order.user.email}</td>
    	</tr>
    </table>
    <br/>
    <a href="${pageContext.request.contextPath}/OrderServlet1?method=confirm&id=${order.id}&state="true">确认发货</a>
  </body>
</html>
