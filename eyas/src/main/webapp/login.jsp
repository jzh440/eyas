<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/framework/css/login.css">
  <link rel="Shortcut Icon" href="/framework/image/img_logo_p16.png" />

<link rel="stylesheet" type="text/css" href="/framework/css/prompt.css">
<title>江西省交通地理信息共享服务平台运维管理系统</title>
<script type="text/javascript" src="/framework/framework/easyui1.3.2/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="/framework/framework/easyui1.3.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/framework/framework/easyui1.3.2/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/framework/js/utils/YMLib.js"></script>
<script type="text/javascript" src="/framework/js/login.js"></script>
<script type="text/javascript" src="/framework/js/MyUtil.js"></script>
 <script language="JavaScript"> 
     if (window != top) 
        top.location.href = location.href; 
    </script>
</head>

<body onkeydown='enterBlind(event);'> 
<div class="float">
<div class="title">
	<div class="header">
		<div class="logo"><img alt="" src="/framework/image/img_yw_logo.png"/></div>
	</div>
</div> 
<div>
	<div class="nav">
		<div class="regist_img"><a href="/framework/register.jsp"><img alt="" id="regist_img" src="/framework/image/img_t_4.png"></a></div>
		<div class="login_img"><img alt="" id="login_img" src="/framework/image/img_t_3.png"></div>
	</div>
	<div class="form">
		<form id="login_form">
		<div style="visibility: hidden;height: 0px;"><input id="sys" value="framework" name="sys" type="text" /></div>
			<div class="content">
				<div class="loginform">
					<div id="login_message" class="login_message">欢迎登录GIS运维管理系统</div>
					<div class="login_username"><input id="username" name="username" type="text" placeholder=" 请输入用户名"></div>
					<div class="login_password"><input id="password" name="password" type="password" placeholder=" 请输入密码"></div>
					<div>
						<div class="login_auto"><input id="remember" name="remeber" type="checkbox" checked="checked">记住密码
						</div>
					</div>
					<div class="login_button"><input id="login" value='' type="button" onfocus="this.blur()" onclick="gis_login()"/></div>
					
				</div>
			</div>
		</form>
	</div>
</div>
</div>
<div class="bottom">
	<div class="label1">Copyright © 2014 hdsx Company, All Rights Reserved - Version 0.1</div>
</div>
</body>
</html>
