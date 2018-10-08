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
    
    <title>首页管理</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body{
			margin: 0px;
			padding:0px;
			text-align: center;
		}
		#container{
			
			text-align: left;
		}
		#head{
			text-align: center;
		}
		#categories{
			border:solid 1px blue;
			width:150px;
			padding-left: 20px;
			margin-left:100px;
			height:350px;
			line-height: 40px;
			float:left;
		}
		#books{
			float:left;
			margin-left:80px;
		}
		#image{
			float:left;
			
		}
		#rimage{
			
			width:100px;
			height:150px;
		}
		#info{
			float:left;
			margin-left: 20px;
		}
		#book{
			float:left;
			width:300px;
		}
		#name{
			
		}
	</style>
  </head>
  
  <body style="text-align:center">
  	<div id="container">
  		<div id="head"><%@include file="/client/head.jsp"  %></div>
  		<div id="main">
  			<div id="categories">
  				书籍类别
  				<c:forEach var="c" items="${categories}">
  					<li><a href="${pageContext.request.contextPath}/IndexServlet?category_id=${c.id}">${c.name}</a></li>
  				</c:forEach>
  			</div>
  			<div id="books">
  				<c:forEach var="book" items="${pagebean.list }" varStatus="status">
  					<div id="book">
	  					<div id="image"><image id="rimage" src="${pageContext.request.contextPath}/images/${book.image}"></div>
	  					<div id="info">
	  						<li id="name">${book.name}</li>
	  						<li>${book.author}</li>
	  						<li>${book.price}</li>
	  						<li>
	  							<a href="${pageContext.request.contextPath}/BuyServlet?id=${book.id}">购买</a>
							</li>
	  					</div>
	  					
  					</div>
  					<c:if test="${status.count%3==0}">
  						<div style="clear:both"></div>
  					</c:if>
  					
  				</c:forEach>
  				
  				<div style="clear:both"></div>
  				<br/>
  				<div id="pagebar">
  					总共${pagebean.totalPage}页
  					当前${pagebean.currentPage }页
  					<c:forEach var="pagenum" items="${pagebean.pageBar}">
  						<a href="${pageContext.request.contextPath}/IndexServlet?currentPage=${pagenum}&category_id=${param.category_id}">${pagenum}</a>
  					</c:forEach>
  					
  				
  				</div>
  				
  			</div>
  		</div>
  	</div>
  </body>
</html>
  