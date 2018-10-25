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
    
    <title>My JSP 'itemList.jsp' starting page</title>
    
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
	<form action="${pageContext.request.contextPath }/item/queryitem.action" method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td><input type="submit" value="查询"/></td>
			</tr>
		</table>
		订单列表：
		<table width="100%" border=1>
			<tr>
				<td>姓名</td>
				<td>申请日期</td>
				<td>商品名称</td>
				<td>单价/元</td>
				<td>数量</td>
				<td>总价</td>
				<td>备注</td>
			</tr>
			<c:forEach items="${itemList}" var="item">
				<tr>
					<td>${item.name }</td>
					<td><fmt:formatDate value="${item.date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${item.product}</td>
					<td>${item.price}</td>
					<td>${item.number}</td>
					<td>${item.totalprice}</td>
					<td>${item.description}</td>
					
					<td>
						<a href="${pageContext.request.contextPath }/itemEdit.action?id=${item.id}&method=update">修改</a>
						<a href="${pageContext.request.contextPath }/itemEdit.action?id=${item.id}&method=delete">删除</a>
					</td>
					
				</tr>
			</c:forEach>
		
		</table>
	</form>
</body>
</html>
