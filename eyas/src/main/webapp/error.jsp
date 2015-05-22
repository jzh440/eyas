<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="/gisyw/css/error.css"/>
<title>Insert title here</title>
</head>
<body>
   
   <div class="error-main">
   		<div class="error-left"></div>
		<div class="error-right">
		   	<ul>
		   		<li><h3>出错了！</h3></li>
		   		<li><br></li>
				<li><span><%=request.getAttribute("exception") %></span></li>
				<li><span><a href="/eyas/index.jsp"> 返回首页 </a></span></li>	
		   	</ul>
		</div>
   	</div>
   
</body>
</html>