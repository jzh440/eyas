<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- easyui css -->
  <link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/default/easyui_old.css">
  <link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/icon.css">
  <!-- 任务管理 css -->
  <link rel="stylesheet" type="text/css" href="jsgl.css">
</head>
<body class="easyui-layout">
  
  <!-- 中间内容 -->
  <div data-options="region:'center',border:false">
    <div class="div-box div1">
      <div class="div-header xtgly">
        <span>系统管理员</span>
      </div>
      <div class="div-content xtgly-c">
        <span>角色权限:</span>
        <p>资源中心<br/>开发中心<br/>监控中心<br/>通知公告<br/>系统管理</p>
      </div>
    </div>
    <div class="div-box div2">
      <div class="div-header zcyh">
        <span>注册用户</span>
      </div>
      <div class="div-content zcyh-c">
        <span>角色权限:</span>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资源门户浏览资源、申请服务、下载资源等。</p>
      </div>
    </div>
  </div>
  
  <!-- easyui js -->
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/easyui-lang-zh_CN.js"></script>
  <!-- 工具 js -->
  <script type="text/javascript" src="/gisyw/js/utils/YMLib.js"></script>
  <!-- 任务管理 js -->
  <script type="text/javascript" src="jsgl.js"></script>
</body>
</html>