<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  	若没有注册，请先注册<a href="${pageContext.request.contextPath }/user/toRegister.action">注册</a>
    <form action="${pageContext.request.contextPath}/user/login.action">
		<label>用户名：</label>
		<br>
			<input type="text" name="name">
		<br>
		<label>密码：</label>
		<br>
			<input type="password" name="password">
		<br>
		<input type="submit" value="登录">
	</form>
  </body>
</html>
