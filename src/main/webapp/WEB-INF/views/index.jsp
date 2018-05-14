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
	<ul>
	<li><a href="<%=basePath%>omsWebLog" target="_blank">omsWeb日志：</a></li>
	<li><a href="<%=basePath%>userCenterLog" target="_blank">userCenter日志：</a></li>
	<li><a href="<%=basePath%>omsMessageLog" target="_blank">omMessage日志：</a></li>
	</ul>
</body>
</body>
</html>