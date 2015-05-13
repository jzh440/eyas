<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="Shortcut Icon" href="/gisyw/image/img_logo_p16.png" />

<!-- easyui css -->
<link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/default/easyui_old.css">
<link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/icon.css">
<!-- 弹框样式 -->
<link type="text/css" rel="stylesheet" href="/gisyw/css/prompt.css"/>
<!-- 添加单位 css -->
<link rel="stylesheet" type="text/css" href="add.css">
</head>
<body class="easyui-layout">

 <!-- 选择数据项头页面 -->
 <div class="north" data-options="region:'north',border:false">
    <!-- 页头 -->
    <div class="header-inner">添加单位</div>
  </div>
  
  <!-- 数据表格内容 -->
  <div data-options="region:'center',border:false">
    <form id="form_add">
      <table class="table-add">
        <tr>
          <td class="td-title"><span>*</span>单位名称：</td>
          <td class="td-input"><input id="name" name="name" type="text" maxlength="30"/></td>
          <td class="td-vali"> 至少4位的中英文字符</td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>负责人员：</td>
          <td class="td-input"><input id="leader" name="leader" type="text"/></td>
          <td class="td-vali"> 2-5位中文字符</td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>联系电话：</td>
          <td class="td-input"><input id="tel" name="tel" type="text"/></td>
          <td class="td-vali"> 格式：0开头区号(3到4位)-电话号码(7到8位)-分机号(3位)</td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真：</td>
          <td class="td-input"><input id="fax" name="fax" type="text"/></td>
          <td class="td-vali"> 格式：0开头区号(3到4位)-电话号码(7到8位)-分机号(3位)</td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编：</td>
          <td class="td-input"><input id="postCode" name="postCode" type="text"/></td>
          <td class="td-vali"> 6位数字字符</td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
          <td class="td-input"><input id="address" name="address" type="text"/></td>
          <td class="td-vali"> 至少2位的中英文字符</td>
        </tr>
      </table>
      <ul class="ul-button">
        <li>
          <input class="big-button button-publish" id="publish" type="button" value="提交" onclick="add();" />
        </li>
        <li>
          <input class="big-button button-cancel" id="cancel" type="button" value="取消" onclick="cancelAdd();" />
        </li>
      </ul>
    </form>
  </div>
  
  <!-- easyui js -->
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript" src="/gisyw/js/datagrid-detailview.js"></script>
  <!-- 工具 js -->
  <script type="text/javascript" src="/gisyw/js/utils/YMLib.js"></script>
  <script type="text/javascript" src="/gisyw/js/utils/uuid.js"></script>
  <!-- 添加单位 js -->
  <script type="text/javascript" src="add.js"></script>
</body>
</html>