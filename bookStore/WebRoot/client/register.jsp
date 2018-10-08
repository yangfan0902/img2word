<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
  	<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
  		<table width="300px">
  			<caption><h2>用户注册</h2></caption>
  			<tr>
	  			<td>用户名</td>
	  			<td><input type="text" name="username" style="width:200px"></input></td>
  			</tr>
  			<tr>
	  			<td>密码</td>
	  			<td><input type="password" name="password" style="width:200px"></input></td>
  			</tr>
  			<tr>
	  			<td>电话</td>
	  			<td><input type="text" name="phone" style="width:200px"></input></td>
  			</tr>
  			<tr>
	  			<td>手机</td>
	  			<td><input type="text" name="cellphone" style="width:200px"></input></td>
  			</tr>
  			<tr>
	  			<td>住址</td>
	  			<td><input type="text" name="address" style="width:200px"></input></td>
  			</tr>
  			<tr>
	  			<td>邮箱</td>
	  			<td><input type="text" name="email" style="width:200px"></input></td>
  			</tr>
  			<tr>
  				<td></td><td><input type="submit" value="注册"></input</td>
  			</tr>
  			
  		
  		
  		</table>
  	</form>
  </body>
</html>
