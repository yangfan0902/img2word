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
    
    <title>My JSP 'itemList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		
		function addRow(){
			var tableNode=document.getElementById("table");
			var trList=tableNode.getElementsByTagName("tr");
			var tdList=trList[trList.length-1].getElementsByTagName("td");
			var number=trList.length-1;
			
			var nameinput=document.createElement("input");
			var productinput=document.createElement("input");
			var priceinput=document.createElement("input");
			var numberinput=document.createElement("input");
			var descriptioninput=document.createElement("input");
			
			nameinput.setAttribute("name","itemList["+number+"].name");
			productinput.setAttribute("name","itemList["+number+"].product");
			priceinput.setAttribute("name","itemList["+number+"].price");
			numberinput.setAttribute("name","itemList["+number+"].number");
			descriptioninput.setAttribute("name","itemList["+number+"].description");
			
			
			var td1=document.createElement("td");
			td1.appendChild(nameinput);
					
			var td2=document.createElement("td");
			td2.appendChild(productinput);
			
			var td3=document.createElement("td");
			td3.appendChild(priceinput);
			
			var td4=document.createElement("td");
			td4.appendChild(numberinput);
			
			var td5=document.createElement("td");
			td5.appendChild(descriptioninput);
			
			var tr=document.createElement("tr");
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
			tr.appendChild(td5);
			
			
			tableNode.appendChild(tr);
			
		}
		
		function test(){
			var nodes=document.getElementsByTagName("tr");
			for(var i=1;i<nodes.length;i++){
				alert((nodes[i].getElementsByTagName("td"))[0].getElementsByTagName("input")[0].getAttribute("name"));
			}
		}
	</script>
  </head>
  
  <body> 
	<form action="${pageContext.request.contextPath }/add.action" method="post">
		<input type="button" value="增加订单" onclick="addRow()">
		订单列表：
		<table width="80%" border=1 id="table">
			<tr>
				<td>姓名</td>
				<td>商品名称</td>
				<td>单价/元</td>
				<td>数量</td>
				<td>备注</td>
			</tr>
			
			<tr>
				<td><input type="text" name="itemList[0].name"/></td>
				<td><input type="text" name="itemList[0].product"/></td>
				<td><input type="text" name="itemList[0].price"/></td>
				<td><input type="text" name="itemList[0].number"/></td>
				<td><input type="text" name="itemList[0].description"/></td>		
			</tr>
		</table>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>
