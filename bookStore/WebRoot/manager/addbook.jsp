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
    
    <title>添加图书</title>
    
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
    <form action="${pageContext.request.contextPath}/BookServlet?method=add" method="post" enctype="multipart/form-data">
    	<table width="500px">
    		<tr>
    			<td>书名</td>
    			<td><input type="text" name="name" style="width:200px"></input></td>
    		</tr>
    		<tr>
    			<td>作者</td>
    			<td><input type="text" name="author" style="width:200px"></input></td>
    		</tr>
    		<tr>
    			<td>售价</td>
    			<td><input type="text" name="price" style="width:200px"></input></td>
    		</tr>
    		<tr>
    			<td>图片</td>
    			<td><input type="file" name="filename" style="width:200px"></input></td>
    		</tr>
    		<tr>
    			<td>描述</td>
    			<td><textarea rows="4" cols="40" name="description"> </textarea></td>
    		</tr>
    		<tr>
    			<td>所属分类</td>
    			<td>
					<select name="category_id">
						<c:forEach var="category" items="${categories}">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
					</select>
				</td>
    		</tr>
    		<tr>
    			<td></td><td><input type="submit" value="添加书籍"></input></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
