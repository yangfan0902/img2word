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
    
    <title>数据库信息备份列表页面</title>
    
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
     <table width="800" frame="border">
     	<caption><h2>数据库备份信息列表</h2></caption>
     	<tr>
     		<td>备份文件名</td>
     		<td>备份时间</td>
     		<td>备注</td>
     		<td>操作</td>
     	</tr>
     	<c:forEach var="back" items="${backs}">
	     	<tr>
	     		<td>${back.filename}</td>
	     		<td>${back.backtime}</td>
	     		<td>${back.description}</td>
	     		<td><a href="${pageContext.request.contextPath}/DBServlet?method=restore&id=${back.id}">恢复</a></td>
	     	</tr>
     	</c:forEach>
     </table>
  </body>
</html>
