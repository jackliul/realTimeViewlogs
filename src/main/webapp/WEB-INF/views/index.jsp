<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
 String path = request.getContextPath();  
 String basePath = request.getScheme() + "://"  
         + request.getServerName() + ":" + request.getServerPort()  
         + path + "/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>realTimeViewLogs index</title>
</head>
<body>

	<% if (request.getAttribute("isTest").equals("true")) { %>
		<ul>
			<li>仿真环境日志：</li>
			<li><a href="<%=basePath%>omsWebLog?env=test" target="_blank">oms-web日志：</a></li>
			<li><a href="<%=basePath%>userCenterLog?env=test" target="_blank">user-center日志：</a></li>
			<li><a href="<%=basePath%>fileServerLog?env=test" target="_blank">file-server日志：</a></li>
<%-- 			<li><a href="<%=basePath%>messageLog?env=other" target="_blank">message日志：</a></li> --%>
			<li><a href="<%=basePath%>projectPoolLog?env=other" target="_blank">projectPool日志：</a></li>
			<li><a href="<%=basePath%>interfacePlatformLog?env=test" target="_blank">interfacePlatform日志：</a></li>
		</ul>
	<% } %>

	
	<% if (request.getAttribute("isTest").equals("false")) { %>
		<ul>
			<li>01环境日志：</li>
			<li><a href="<%=basePath%>omsWebLog?env=01" target="_blank">oms-web日志：</a></li>
			<li><a href="<%=basePath%>userCenterLog?env=01" target="_blank">user-center日志：</a></li>
			<li><a href="<%=basePath%>fileServerLog?env=01" target="_blank">file-server日志：</a></li>
<%-- 			<li><a href="<%=basePath%>messageLog?env=other" target="_blank">message日志：</a></li> --%>
            <li><a href="<%=basePath%>projectPoolLog?env=other" target="_blank">projectPool日志：</a></li>
            <li><a href="<%=basePath%>interfacePlatformLog?env=01" target="_blank">interfacePlatform日志：</a></li>
		</ul>
		<ul>
			<li>02环境日志：</li>
			<li><a href="<%=basePath%>omsWebLog?env=02" target="_blank">oms-web日志：</a></li>
			<li><a href="<%=basePath%>userCenterLog?env=02" target="_blank">user-center日志：</a></li>
			<li><a href="<%=basePath%>fileServerLog?env=02" target="_blank">file-server日志：</a></li>
<%-- 			<li><a href="<%=basePath%>messageLog?env=other" target="_blank">message日志：</a></li> --%>
            <li><a href="<%=basePath%>interfacePlatformLog?env=02" target="_blank">interfacePlatform日志：</a></li>
		</ul>
	<% } %>
	
</body>
</body>
</html>