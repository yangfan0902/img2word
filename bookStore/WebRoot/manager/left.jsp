<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台</title>
    
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
 	<ul>
 		<li>
 			<a href="#" onclick="test(children[0])">分类管理
 				<div class="dc">
 					<a href="${pageContext.request.contextPath}/manager/addcategory.jsp" target="right">添加分类</a><br/>
 					<a href="${pageContext.request.contextPath}/CategoryServlet?method=getAll" target="right">查看分类</a><br/>
 				</div>
 			</a>
 		</li>
 		<br/><br/>
 		
 		<li>
 			<a href="#" onclick="test(children[0])">图书管理
 				<div class="dc">
 					<a href="${pageContext.request.contextPath}/BookServlet?method=forAddUI" target="right">添加图书</a><br/>
 					<a href="${pageContext.request.contextPath}/BookServlet?method=list" target="right">查看图书</a>
 				</div>
 			</a>
 		</li>
 		
 		<li>
 			<a href="#" onclick="test(children[0])">订单管理
 				<div class="dc">
 					<a href="#" target="right">待处理订单</a><br/>
 					<a href="#" target="right">已发货订单</a><br/>
 				</div>
 			</a>
 		</li>
 	</ul>
  </body>
</html>
