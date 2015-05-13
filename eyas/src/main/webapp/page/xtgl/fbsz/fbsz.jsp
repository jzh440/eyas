<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布配置</title>
<link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/default/easyui_old.css" />
<link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="/gisyw/css/prompt.css"/>
<link rel="stylesheet" type="text/css" href="css/css.css"/>
</head>
<body>
  <div class="center">
    <img src="images/img_yw_pic.png" width="456" height="119" />
    <form id="form">
      <table style="text-align:right;">
        <tr height="60">
          <td>Arcgis服务器地址：</td>
          <td><input name="" id="path" type="text" class="easyui-validatebox" data-options="required:true,validType:'http'"/></td>
        </tr>
        <tr height="60">
          <td>用户名：</td>
          <td><input name="" id="userName" type="text" class="easyui-validatebox" data-options="required:true,validType:'data'"/></td>
        </tr>
        <tr height="60">
          <td>密&nbsp;&nbsp;码：</td>
          <td><input name="" id="password" type="text" class="easyui-validatebox" data-options="required:true,validType:'data'"/></td>
        </tr>
      </table>
    </form>
    <div class="btn">
       <a class="btn_qx" id="btn_qx" onclick="">测试连接</a>
       <a class="btn_sure" id="btn_sure" onclick="submit()">确定</a>
    </div>
  </div>
  <!-- easyui js -->
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="/gisyw/js/jquery.json-2.4.js"></script>
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript" src="/gisyw/js/utils/YMLib.js"></script>
  <script type="text/javascript" src="js/fbsz.js"></script>
</body>
</html>
