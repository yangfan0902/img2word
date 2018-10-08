<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>网上书店</h1>
<div style="margin-left:40%;float:left">
	<a href="${pageContext.request.contextPath}/index.jsp">首页</a>
	<a href="#" targrt="body">查看购物车</a>
	<a href="#" targrt="body">查看自己的订单</a>
</div>

<div style="float:right" method="post">
	<c:if test="${user==null}">
		<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
			用户名<input type="text" name="username" style="width:50px">
			密码<input type="password" name="password" style="width:50px"> 
			<input type="submit" value="登录">
			<input type="button" value="注册" onclick="javascript:window.location.href='/bookStore/client/register.jsp'">
		</form>
	</c:if>
	<c:if test="${user!=null }">
		${user.username}
	</c:if>
</div>
<div style="clear:both"></div>
<hr/>
