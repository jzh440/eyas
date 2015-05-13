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
<!-- 添加用户 css -->
<link rel="stylesheet" type="text/css" href="add.css">
</head>
<body class="easyui-layout">

 <!-- 选择数据项头页面 -->
 <div class="north" data-options="region:'north',border:false">
    <!-- 页头 -->
    <div class="header-inner">添加用户</div>
  </div>
  
  <!-- 数据表格内容 -->
  <div data-options="region:'center',border:false">
    <form id="form_add">
      <table class="table-add">
        <tr>
          <td class="td-title"><span>*</span>用户名称：</td>
          <td class="td-input"><input id="username_add" name="username" type="text" maxlength="10"/></td>
          <td class="td-vali"> 长度为6-10位中英文字符</td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
          <td class="td-input"><input id="password_add" name="password" type="password" maxlength="14"/></td>
          <td class="td-vali"> 长度为6-14位的字符，支持数字、大小写字母和标点符号，不允许有空格</td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>确认密码：</td>
          <td class="td-input"><input id="password_confirm" type="password" maxlength="14"/></td>
          <td class="td-vali"> 确认密码与密码一致</td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
          <td class="td-input"><input id="name_add" name="name" type="text" maxlength="5"/></td>
          <td class="td-vali"> 2-5位中文字符</td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>联系电话：</td>
          <td class="td-input"><input id="mobile_add" name="mobile" type="text"/></td>
          <td class="td-vali"> 11位手机号或者区号加7或8位固定电话号</td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>电子邮箱：</td>
          <td class="td-input"><input id="email_add" name="email" type="text"/></td>
          <td class="td-vali"> 有效电子邮箱</td>
        </tr>
        <tr>
          <td class="td-title"><span>*</span>单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位：</td>
          <td class="td-input"><select id="deptId" name="deptId" onchange="getDpName();"></select></td>
<!--           <td class="td-vali"> 4位以上的中英文字符</td> -->
        </tr>
        <tr style="display:none" id="otherDp">
          <td class="td-title"><span>*</span>单位名称：</td>
          <td class="td-input"><input type="text" name="otherDp"> </td>
<!--           <td class="td-vali"> 4位以上的中英文字符</td> -->
        </tr>
        <tr>
          <td class="td-title"><span>*</span>角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</td>
          <td class="td-input">
            <select id="roleId" name="roleId">
              <option value="2" id="option2">注册用户</option>
              <option value="1" selected="selected">系统管理员</option>
            </select>
          </td>
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
  <!-- 添加用户 js -->
  <script type="text/javascript" src="add.js"></script>
</body>
</html>