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
    
    <title>订单显示页面</title>
    
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
    <br></br>
    <table>
    	<caption><h2>订单信息</h2></caption>
    	<tr>
    		<td>订单人</td>
    		<td>下单时间</td>
    		<td>订单状态</td>
    		<td>订单总价</td>
    		<td>操作</td>
    	</tr>
    	<c:forEach var="order" items="${orders}">
    		<tr>
    			<td>${order.user.username}</td>
    			<td>${order.ordertime}</td>
    			<td>${order.state==false?'未发货':'已发货'}</td>
    			<td>${order.price}</td>
    			<td>
    				<a href="${pageContext.request.contextPath}/OrderServlet1?method=find&id=${order.id}">查看明细</a>
    			</td>
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>
