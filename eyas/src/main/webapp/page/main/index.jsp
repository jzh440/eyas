<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>江西省交通地理信息共享服务平台运维管理系统</title>
  <!--地址栏和标签上显示图标-->
  <link rel="Shortcut Icon" href="/gisyw/image/img_logo_p16.png" />
  <!--收藏夹显示图标-->
  <link rel="Bookmark" href="image/favicon.ico" />
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/jquery-1.8.0.min.js"></script>
  <!-- easyui css -->
  <link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/default/easyui_old.css">
  
  <link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/icon.css">
  <link rel="stylesheet" type="text/css" href="/gisyw/page/main/css/nav-style.css"/>
  <!-- layout css -->
  <link rel="stylesheet" type="text/css" href="/gisyw/css/layout.css">
  <link rel="stylesheet" type="text/css" href="/gisyw/css/prompt.css"/>
</head>
<body class="easyui-layout" data-options="fit:true">
  <!-- 页面头模块 -->
  <div class="north" data-options="region:'north',border:false">
    <div id="header">
      <div id="content">
		<div class="content-logo"></div>
          <div class="nav-menu">
    <ul class="content clearfix">
      <li><a href="/gisyw/page/index/index2.jsp" target='iframe_main'>首页</a></li>
      <li class="dropdown"><a href="javascript: void(0);">资源中心</a>
        <ul class="sub-menu">
          <li><a href='/gisyw/page/dtzy/fwlb/fwlb.jsp'
            target='iframe_main'>服务管理</a></li>
          <li><a href='/gisyw/page/dtzy/rwgl/rwgl.jsp'
            target='iframe_main'>任务管理</a></li>
          <li><a href='/gisyw/page/dtzy/zygl/zygl.jsp'
            target='iframe_main'>资源管理</a></li>
          <li><a href='/gisyw/page/kfzx/bzgf/bzgf.jsp'
            target='iframe_main'>标准规范</a></li>
        </ul></li>
      <li class="dropdown"><a href="javascript: void(0);">开发中心</a>
        <ul class="sub-menu">
          <li><a href='/gisyw/page/kfzx/jtzt/jtzt.jsp'
            target='iframe_main'>交通专题服务</a></li>
          <li><a href='/gisyw/page/bzzx/cjwt/cjwt.jsp'
            target='iframe_main'>常见问题</a></li>
           <li><a href='/gisyw/page/bzzx/yhfk/yhfk.jsp'
            target='iframe_main'>用户反馈</a></li>
        </ul></li>
      <li class="dropdown"><a href="javascript: void(0);">监控中心</a>
        <ul class="sub-menu">
          <li><a href='/gisyw/page/jkzx/yhrz/yhrz.jsp'
            target='iframe_main'>用户日志</a></li>
          <li><a href='/gisyw/page/jkzx/fwrz/fwrz.jsp'
            target='iframe_main'>访问日志</a></li>
          <li><a href='/gisyw/page/jkzx/fwjk/fwjk.jsp'
            target='iframe_main'>服务监控</a></li>
          <li><a href='/gisyw/page/jkzx/fwtj/fwtj.jsp'
            target='iframe_main'>访问统计</a></li>
        </ul></li>
      <li><a href="/gisyw/page/xwzx/xwzx.jsp" target='iframe_main'>通知公告</a></li>
      <li class="dropdown"><a href="javascript: void(0);">系统管理</a>
        <ul class="sub-menu">
          <li><a href='/gisyw/page/xtgl/yhgl/yhgl.jsp'
            target='iframe_main'>用户管理</a></li>
          <li><a href='/gisyw/page/xtgl/dwgl/dwgl.jsp'
            target='iframe_main'>单位管理</a></li>
          <li><a href='/gisyw/page/xtgl/jsgl/jsgl.jsp'
            target='iframe_main'>角色管理</a></li>
          <li><a href='/gisyw/page/xtgl/fbsz/fbsz.jsp'
            target='iframe_main'>发布设置</a></li>
          <li><a href='/gisyw/page/xtgl/sjapp/sjapp.jsp'
            target='iframe_main'>apk更新</a></li>
        </ul></li>
       <li class="dropdown"><a id="username"></a>
       <ul class="sub-menu">
          <li><a href='/gisyw/page/wdxx/wdxx.jsp'
            target='iframe_main'>我的信息</a></li>
        </ul>    
       </li>
      <li><a href="javascript: logout();">退出</a></li>
    </ul>
  </div>
      </div>
    </div>
  </div>

 <!-- 中间主要内容iframe -->
  <div class="center" data-options="region:'center',border:false">
    <iframe id="iframe_main" name="iframe_main" class="iframe" frameborder="0" src="/gisyw/page/index/index2.jsp"></iframe>
  </div>

  <!-- 底部版权信息 -->
  <!-- <div class="south" data-options="region:'south',border:false">
    <span>Copyright &copy; 2014 hdsx Company, All Rights Reserved - Version 0.1</span>
  </div> -->

  <!-- 修改密码模块 -->
  <div id="dlg_pass">
    <form id="form_pass" method="post">
      <table>
        <tr>
          <td class="input-td"><label>用   户   名：</label></td>
          <td style="padding-left:5px;"><span id="userName_pass"></span></td>
        </tr>
        <tr>
          <td class="input-td"><label for="password_pass">当前密码：</label></td>
          <td><input id="password_pass" style="padding-left:10px;" placeholder="长度为4-20位的密码" name="user.password" type="password"></input></td><td style="width: 20px;margin-top: 20px;" align="left"><img id="password_passTishi" style="visibility:hidden;" src="" alt=""></img>&nbsp;</td>
        </tr>
       <tr>
          <td class="input-td"><label for="newPassword_pass">新    密    码：</label></td>
          <td><input id="newPassword_pass" style="padding-left:10px;" placeholder="长度为4-20位的密码" name="newPassword" type="password"></input></td><td style="width: 20px;margin-top: 20px;"  align="left"><img id="newPassword_passTishi" style="visibility:hidden;" src="" alt=""/>&nbsp;</td>
        </tr>
        <tr>
          <td class="input-td"><label for="newPassword_pass_i">确认密码：</label></td>
          <td><input id="newPassword_pass_i" style="padding-left:10px;" placeholder="确认密码与新密码一致" name="newPassword_i" type="password"></input></td><td style="width: 20px;margin-top: 20px;" align="left"><img id="newPassword_pass_iTishi" style="visibility:hidden;" src="" alt=""></img>&nbsp;</td>
        </tr>
        <tr>
          <td class="input-td" colspan="3" align="center"><font id="messageFont" style="font-size:15px;margin-top: 20px;font-family:Microsoft YaHei;"><span id="messageTishi"></span></font></td>
        </tr>
      </table>
    </form>
  </div>
	<div id="dlg_remove" title="退出系统" style="padding:10px;width:250px;height:150px;">
    <span>你确定要退出系统吗？</span>
  </div>
    <!-- easyui js -->
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/jquery.easyui.min.js"></script>
  <!-- pluging js -->
  <script type="text/javascript" src="/gisyw/framework/jquery/jquery.cookie.js"></script>
  <script type="text/javascript" src="/gisyw/page/main/js/jquery.navHover.min.js"></script>
  <!-- index js -->
  <script type="text/javascript" src="/gisyw/js/utils/YMLib.js"></script>
  <script type="text/javascript" src="/gisyw/js/MyUtil.js"></script>
  <script type="text/javascript" src="/gisyw/js/index.js"></script>

</body>
</html>