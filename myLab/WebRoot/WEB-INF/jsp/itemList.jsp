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
		.findAll{
			margin-left: 46px;
		}
		.thisweek{
			margin-left: 15px;
		}
		.logout{
			
			position: absolute;
			right:100px;
		}
	</style>
  </head>
  
  <body> 
		<br>
		<p class="title"><%= session.getAttribute("name") %> 的订单列表：</p>
		<a href="${pageContext.request.contextPath }/user/logout.action" class="logout">注销用户</a>
		<br>
		<table width="90%" class="table">
			<tr>
				<td width="60px">姓名</td>
				<td width="240px">申请日期</td>
				<td width="150px">商品名称</td>
				<td width="150px">单价/元</td>
				<td width="150px">数量</td>
				<td width="150px">总价</td>
				<td>备注</td>
				<td width="100px">操作</td>
			</tr>
			<c:forEach items="${itemList}" var="item">
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
					
					<td>
						<a href="${pageContext.request.contextPath }/item/itemEdit.action?id=${item.id}&method=update">修改</a>
						<a href="${pageContext.request.contextPath }/item/itemEdit.action?id=${item.id}&method=delete">删除</a>
					</td>
					
				</tr>
			</c:forEach>
		
		</table>
		<div class="jump">
			<a href="${pageContext.request.contextPath }/item/itemListByName.action">我的所有订单</a>
			<a href="${pageContext.request.contextPath }/item/itemListByNameByWeek.action" class="thisweek">我的本周订单</a>
			<br>
			<a href="${pageContext.request.contextPath }/item/addItem.action">创建订单</a>
			<a href="${pageContext.request.contextPath }/item/allItemList.action" class="findAll">查看所有订单</a>
			
		</div>
</body>
</html>
