<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'itemList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		table{
			border-collapse: collapse;
			margin: 0 auto;
		}
		table td{
			border: 1px solid #cad9ea;
			color:#666;
			height:30px;
		}
		table tr:nth-child(odd){
			background: #fff;
		}
		table tr:NTH-CHILD(even) {
			background: #F5FAFA;	
		}
		table td{
			text-align: center;
		}
		.title{
			text-align: center;
			color: #4876FF;
			font:28px/20px microsoft yahei
		}
		.jump{
			margin-left: 75px;
		}
		.all{
			margin-left: 15px;
		}
		.totalprice{
			font:20px/20px microsoft yahei;
			color:#4876FF;
		}
	</style>
  </head>
  
  <body> 
	
		<br>
		<p class="title">课题组订单列表：</p>
		<table width="90%">
			<tr>
				<td width="60px">姓名</td>
				<td width="240px">申请日期</td>
				<td width="150px">商品名称</td>
				<td width="150px">单价/元</td>
				<td width="150px">数量</td>
				<td width="150px">总价</td>
				<td>备注</td>
			</tr>
			<c:set value="0" var="total" />
			<c:forEach items="${allItemList}" var="item">
				<c:set var="total" value="${total+item.totalprice }"></c:set>
				<tr>
					<td>${item.name }</td>
					<jsp:useBean id="dateObject" class="java.util.Date" scope="page"></jsp:useBean>
					<jsp:setProperty property="time" name="dateObject" value="${item.date}"/>
					<td><fmt:formatDate value="${dateObject}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
					<td>${item.product}</td>
					<td>${item.price}</td>
					<td>${item.number}</td>
					<td>${item.totalprice}</td>
					<td>${item.description}</td>	
				</tr>
			</c:forEach>
			
		</table>
		
	<%-- <a href="${pageContext.request.contextPath }/item/addItem.action">创建订单</a>
	<a href="${pageContext.request.contextPath }/item/allItemList.action">查看所有订单</a> --%>
		<div class="jump">
			<p class="totalprice">总额 ${total}元</p>
			<a href="${pageContext.request.contextPath }/item/itemListByWeek.action" class="thisweek">本周订单</a>
			<a href="${pageContext.request.contextPath }/item/allItemList.action" class="all">所有订单</a>
			<br>
			<a href="${pageContext.request.contextPath }/item/itemListByName.action" class="goback">返回我的订单</a>
		</div>
</body>
</html>
