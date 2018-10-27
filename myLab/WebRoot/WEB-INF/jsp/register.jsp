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
	<style type="text/css">
		*{
			box-sizing: border-box;
		}
		
		body{
			margin:0;
			padding:0;
			font:16px/20px microsoft yahei;
		}
		
		.wrap{
			width: 100%;
			height:100%;
			padding:10% 0;
			position: fixed;
			opacity: 0.8;
			background: linear-gradient(to bottom right,#000000,#656565);
			background: -webkit-linear-gradient(to bottom right,#50a3a2,#53e3a6);
		}
		
		.container{
			width:60%;
			margin:0 auto;
		}	
		
		.container h1{
			text-align: center;
			color: #FFFFFF;
			font-weight: 500;
		}
		
		.container input{
			width: 320px;
			display: block;
			height:36px;
			border:0;
			outline:0;
			padding:6px 10px;
			line-height: 24px;
			margin:32px auto;
		}
		
		.container input[type="text"],.container input[type="password"]{
			background-color: #FFFFFF;
			font-size: 16px;
			color:#50a3a2;
		}
		.container input[type="submit"]{
			font-size: 16px;
			letter-spacing: 2px;
			color: #666666;
			background-color: #FFFFFF;
		}
		.container input:focus{
			width:400px;
		}
		.container input[type="submit"]:hover{
			cursor: pointer;
			width: 400px;
		}
		.wrap ul{
			position:absolute;
			top:0;
			left:0;
			widows: 100%;
			height: 100%;
			z-index: -20;
		}
		.wrap ul li{
			 list-style-type: none;
			 display: block;
			 position: absolute;
			 bottom: -120px;
			 width: 15px;
			 height: 15px;
			 z-index: -8;
			 border-radius: 50%;
			 background-color:rgba(255, 255, 255, 0.15);
			 animotion: square 25s infinite;
			 -webkit-animation: square 25s infinite;
		}
	</style>
  </head>
  
  <body>
  	<div class="wrap">
  		<div class="container">
  			<h1>注册</h1>
		    <form action="${pageContext.request.contextPath}/user/register.action">
				
				<input type="text" placeholder="你的真实姓名" name="name">
				<input type="password" placeholder="密码" name="password">
				<input type="submit" value="注册">
				
			</form>
		</div>
		<ul>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
  </body>
</html>