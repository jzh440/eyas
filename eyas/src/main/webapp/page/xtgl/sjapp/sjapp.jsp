<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- easyui css -->
<link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/default/easyui_old.css">
<link rel="stylesheet" type="text/css" href="/gisyw/framework/easyui1.3.2/themes/icon.css">
<!-- 弹框样式 -->
<link type="text/css" rel="stylesheet" href="/gisyw/css/prompt.css"/>
<!-- 手机app css -->
<link rel="stylesheet" type="text/css" href="sjapp.css">
<!-- easyui js -->
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="/gisyw/framework/easyui1.3.2/easyui-lang-zh_CN.js"></script>
  <!-- 工具 js -->
  <script type="text/javascript" src="/gisyw/js/utils/YMLib.js"></script>
  <script type="text/javascript" src="/gisyw/js/utils/uuid.js"></script>
<!-- js -->
<script type="text/javascript" src="sjapp.js"></script>
<title>Insert title here</title>
</head>
<body class="easyui-layout">

  <div data-options="region:'north', border:false">
    <div class="title">
      <span>App下载</span>
    </div>
  </div>

  <div data-options="region:'center', border:false">
    <div class="main">
      <div class="left">
        <img class="img" alt="手机app" src="/gisyw/image/img_download_jx.png">
        <p class="center-p"></p>
        <input class="download" type="button" onclick=" window.parent.location.href='/gisyw/rest/downApp/down';"/>
        <input class="update_btn" type="button" onclick="diaOpen();"/>
      </div>
      <div class="right">
        <h1 style="width: 740px;">江西省交通地理信息共享平台－外业采集系统（Android端） v1.0版</h1>
        <h2 class="app-title">简介</h2>
        <p>《江西省交通地理信息共享平台－外业采集系统（Android端）》是根据交通行业需求专为补采空间数据而设计的可用在Android手机等移动端的应用工具。由于互联网的迅速发展，手持移动设备的随时随地方便快捷的特点给交通行业数据采集及补充带来更多的方便。《江西省交通地理信息共享平台－外业采集系统（Android端）》结合发展趋势，通过手机可以随时、随地采集空间数据，减轻了定时采集的工作压力，让工作更轻松，数据补充更及时！</p>
        <h2 class="app-title">优缺点分析</h2>
        <p>计划性任务采集，根据下发的采集计划合理安排采集时间。</p>
        <p>任务采集完成可及时上传数据，保证安全性与及时性。</p>
        <h2 class="app-title">功能介绍</h2>
        <p>采集点状要素，轻轻点击，锁定任务，采集工作即可轻松完成！</p>
        <p>采集线状要素，路线也可以用手机采集。</p>
        <p>上传数据，无需 U盘拷贝传输，只要有网络，随时上传数据。</p>
      </div>
    </div>
  </div>
  
  <div id="dlg_import"
		style="padding-top: 31px; display: none; width: 570px; height: 380px; border:1px #ccc solid;border-top: 0;">
		<span id="tsxx" style="color:red;font-size: 16px; margin-top: -20px; margin-bottom: 20px; margin-left: 100px;display:none;">格式不正确，请选择apk格式的文件</span>
		<form id="form_import" method="post" enctype="multipart/form-data">
			<div class="ehdel_upload_show">
				<label>选择文件：</label> 
					<input class="ehdel_upload_text" id="filename" name="fileName" type="text" /> 
					<input id="ehdel_upload_btn" type="button" value="上传" onclick="open_btn();" class="upload"/>
				<input
					type="file" 
					onchange="getValue();" 
					style="width: 50px; height: 30px; position: relative; top: -38px; opacity:0;"  name="appFile" id="appFile"/>
			</div>
<!-- 			<div class="ehdel_upload_show"> -->
<!-- 				<label>版本信息：</label> -->
<!-- 				<input class="ehdel_upload_text" name="sqFileName" type="text" />  -->
<!-- 			</div> -->
			<div class="ehdel_upload_show" style="position: relative; top: -10px;">
				<label>更新描述：</label> 
				<textarea cols="44" rows="4" style="position: relative; left: 15px; width: 380px;resize: none;" name="describe"></textarea>
			</div>
			<div style="height: 40px; width: 570px; margin-top: 55px;">
				<input type="button" class="qd" value="确定" id="import"/>
				<input type="button" class="qx" value="取消" onclick="diaclose();"/>
			</div>
		</form>
	</div>
  
</body>
</html>
