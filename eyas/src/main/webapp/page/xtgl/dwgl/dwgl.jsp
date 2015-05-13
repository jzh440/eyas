<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="Shortcut Icon" href="/gisyw/image/img_logo_p16.png" />

<!-- easyui css -->
<link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/default/easyui_old.css">
<link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/icon.css">
<!-- 单位管理 css -->
<link rel="stylesheet" type="text/css" href="dwgl.css">
<!-- 弹框样式 -->
<link type="text/css" rel="stylesheet" href="/gisyw/css/prompt.css"/>
</head>
<body class="easyui-layout">
  <!-- 选择数据项头页面 -->
  <div class="north" data-options="region:'north',border:false">
    <!-- 条件查询 -->
    <div id="toolbar_div" class="toolbar_search">
      <label for="search_dw">单位名称:</label>
      <select id="search_dw" onchange="queryDw();"></select>
<!--       <input type="button" class="toolbar_button" onclick="queryDw();" /> -->
      <!-- 按钮 -->
      <!-- <ul class="ul_button">
        <li>
          <input type="button" id="add" class="big-button button-add" onclick="locationAdd();" />
        </li>
        <li>
          <input type="button" id="delete" class="big-button button-delete" onclick="regulator('1');" />
        </li>
      </ul> -->
    </div>
  </div>

  <!-- 数据表格内容 -->
  <div data-options="region:'center',border:false">
    <table id="table">
    </table>
  </div>

  <!-- easyui js -->
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/easyui-lang-zh_CN.js"></script>
  <!-- 工具 js -->
  <script type="text/javascript" src="/gisyw/js/utils/YMLib.js"></script>
  <script type="text/javascript" src="/gisyw/js/utils/hdsxUtils.js"></script>
  <script type="text/javascript" src="/gisyw/js/utils/uuid.js"></script>
  <!-- 单位管理 js -->
  <script type="text/javascript" src="dwgl.js"></script>
</body>
</html>