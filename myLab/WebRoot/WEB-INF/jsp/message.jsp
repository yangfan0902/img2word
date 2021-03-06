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
    
    <title>My JSP 'message.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.container{
			width: 100%;
			height:100%;
			padding:10% 0;
			opacity: 0.8;
			background: linear-gradient(to bottom right,#000000,#656565);
			background: -webkit-linear-gradient(to bottom right,#50a3a2,#53e3a6);
		}
		.message{
			margin:0 auto;
			font-size: 32px;
			color:#FFFFFF;
		}
		.to_login{
			font-size: 16px;
			color:#FFFFFF;
		}
	</style>
  </head>
  
  <body>
  	<div class="container">
  		<p class="message"> ${message}</p>
    	<br>
    	<a href="${pageContext.request.contextPath }/item/login.action" class="to_login">登录</a>
    	<a href="${pageContext.request.contextPath }/item/itemListByName.action" class="to_login">返回</a>
  	</div>
   
    
  </body>
</html>
