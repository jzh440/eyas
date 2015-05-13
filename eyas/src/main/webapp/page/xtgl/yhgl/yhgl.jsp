<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- easyui css -->
<link rel="stylesheet" type="text/css" href="/eyas/framework/easyui1.3.2/themes/default/easyui_old.css">
<link rel="stylesheet" type="text/css" href="/eyas/framework/easyui1.3.2/themes/icon.css">
<!-- 弹框样式 -->
<link type="text/css" rel="stylesheet" href="/eyas/css/prompt.css"/>
<!-- 用户管理 css -->
<link rel="stylesheet" type="text/css" href="yhgl.css">
</head>
<body class="easyui-layout">
  <!-- 选择数据项头页面 -->
  <div class="north" data-options="region:'north',border:false">
    <!-- 条件查询 -->
    <div id="toolbar_div" class="toolbar_search">
      <label for="search_dw">单位名称:</label>
      <select id="search_dw" onchange="queryYh();"></select>
      <label for="search_zt">审核状态:</label>
      <select  id="search_zt" onchange="queryYh();">
        <option value="">全部</option>
        <option value="0">未审核</option>
        <option value="1">已审核</option>
        <option value="4">已锁定</option>
      </select>
<!--       <input type="button" class="toolbar_button" onclick="queryYh();" /> -->
      <!-- 按钮 -->
      <ul class="ul_button">
      	<li>
          <input type="button" id="resetps" class="big-button button-resetps" style="width:136px;height:39px;" onclick="locationResetps();" />
        </li>
        <li>
          <input type="button" id="unlock" class="big-button button-unlock" style="width:104px;height:39px;" onclick="unlock();" />
        </li>
        <li>
          <input type="button" id="add" class="big-button button-add" onclick="locationAdd();" />
        </li>
        <li>
          <input type="button" id="auditing" class="big-button button-auditing" onclick="regulator('2');" />
        </li>
        <li>
          <input type="button" id="delete" class="big-button button-delete" onclick="regulator('1');" />
        </li>
      </ul>
    </div>
  </div>

  <!-- 数据表格内容 -->
  <div data-options="region:'center',border:false">
    <table id="table">
    </table>
  </div>

  <!-- easyui js -->
  <script type="text/javascript" src="/eyas/framework/easyui1.3.2/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="/eyas/framework/easyui1.3.2/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="/eyas/framework/easyui1.3.2/easyui-lang-zh_CN.js"></script>
  <!-- 工具 js -->
  <script type="text/javascript" src="/eyas/js/utils/hdsxUtils.js"></script>
  <script type="text/javascript" src="/eyas/js/utils/YMLib.js"></script>
  <script type="text/javascript" src="/eyas/js/utils/uuid.js"></script>
  <!-- 用户管理 js -->
  <script type="text/javascript" src="yhgl.js"></script>
</body>
</html>