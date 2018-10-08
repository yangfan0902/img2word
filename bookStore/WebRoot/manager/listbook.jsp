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
    
    <title>后台书籍列表</title>
    
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
    <br/><br/>
    <table frame="border" cellpadding="0" cellspacing="0" width="90%">
    	<caption><h2>图书信息</h2></caption>
    	<tr>
    		<td>书名</td>
    		<td>作者</td>
    		<td>描述</td>
    		<td>图片</td>
    		<td>操作</td>	
    	</tr>
    	
    	<c:forEach var="book" items="${books}">
    		<tr>
    			<td>${book.name}</td>
    			<td>${book.author}</td>
    			<td>${book.description}</td>
    			<td><a href="${pageContext.request.contextPath }/images/${book.image}">查看图片</a></td>
    			<td>
    				<a href="#">修改</a>
    				<a href="#">删除</a>
    			</td>
    		</tr>
    	</c:forEach>
    	
    </table>
  </body>
</html>
