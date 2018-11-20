<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
 String path = request.getContextPath();  
 String basePath = request.getServerName() + ":" + request.getServerPort()  
         + path + "/"; 
 
 String env = (String)request.getAttribute("env");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>omsMessage log</title>
<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
</head>
<body>
	<div id="log-container" style="height: 950px; overflow-y: scroll; background: #333; color: #aaa; padding: 10px;">
		<div>
		</div>
	</div>
</body>
<script>
	$(document).ready(function() {
		// 指定websocket路径 TODO 這裏需要注意一下
		var websocket = new WebSocket('ws://<%=basePath%>log/other/projectPool');
		websocket.onmessage = function(event) {
			$("#log-container div").append(event.data);
			$("#log-container").scrollTop($("#log-container div").height() - $("#log-container").height());
		};
	});
</script>
</body>
</html>