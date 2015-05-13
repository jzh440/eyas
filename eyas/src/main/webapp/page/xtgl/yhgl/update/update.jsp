<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- easyui css -->
<link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/default/easyui_old.css">
<link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/icon.css">
<!-- 弹框样式 -->
<link type="text/css" rel="stylesheet" href="/gisyw/css/prompt.css"/>
<!-- 修改用户 css -->
<link rel="stylesheet" type="text/css" href="update.css">
</head>
<body class="easyui-layout">

 <!-- 选择数据项头页面 -->
 <div class="north" data-options="region:'north',border:false">
    <!-- 页头 -->
    <div class="header-inner">修改用户</div>
  </div> 
  <!-- 数据表格内容 -->
  <div data-options="region:'center',border:false">
    <form id="form_update">
      <input name="id" type="hidden"/>
      <table class="table-update">
        <tr>
          <td class="td-title"><span>*</span>用户名称：</td>
          <td class="td-input"><input id="username_update" name="username" type="text" disabled="disabled"/></td>
          <td class="td-vali">  至少6位的中英文字符</td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>联系电话：</td>
          <td class="td-input"><input id="mobile_update" name="mobile" type="text"/></td>
          <td class="td-vali">  11位手机号或者区号加7或8位固定电话号</td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>电子邮箱：</td>
          <td class="td-input"><input id="email_update" name="email" type="text"/></td>
          <td class="td-vali">  有效电子邮箱</td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位：</td>
          <td class="td-input" id="dp"><select id="deptId" name="deptId"></select></td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</td>
          <td class="td-input">
            <select name="roleId" id="roleId">
              <option id="option1" value="2">注册用户</option>
              <option id="option2" value="1">系统管理员</option>
            </select>
          </td>
        </tr>
      </table>
      <ul class="ul-button">
        <li>
          <input class="big-button button-publish" id="publish" type="button" value="提交" onclick="update();" />
        </li>
        <li>
          <input class="big-button button-cancel" id="cancel" type="button" value="取消" onclick="cancelupdate();" />
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
  <!-- 修改用户 js -->
  <script type="text/javascript" src="update.js"></script>
</body>
</html>