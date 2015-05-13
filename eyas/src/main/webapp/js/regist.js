$(function(){
	addOption('deptId','/gisyw/portal/dept/selectAllDept.do');
});
/*背景图片变化*/
function changeBkImg(id,path){
	$("#"+id).css("background-image", "url("+path+")");
	$("#"+id).parent().parent().find("div:first").css('visibility','visible');
	$("#"+id).parent().parent().find("div:first").css('color','#909090');
}


//给select添加选项   
function addOption(id,path,defaultValue){
	var html = "";
	$("#"+id).empty();
	$.ajax({ 
		url:  path, 
		type: "POST", 
		dataType: "json", 
		async: false, 
		success: function(results) {
			for(var i=0;i<results.length;i++) {
				
				if(results[i].id == defaultValue) {
					html += "<option value='" + results[i].id + "' selected>" + results[i].name + "</option>";
				} else {
					html += "<option value='" + results[i].id + "'>" + results[i].name + "</option>";
				}
			}
			$("#"+id).append(html);
		},
		error: function(e) {
			YMLib.Tools.showPrompt("!-logo", "系统错误！请联系管理员！", 5000);
		}
	});
}

/*图片变化*/
function changeImg(id, path){
	$("#"+id).attr("src", path);
}
/*表单验证*/
function validate(id){
	var flag=true;
	var value = $("#" + id).attr('value').replace(/\s+/g, "");
	
	if(id=="username"){
		if(value.length >=6){
			flag=true;
			changeBkImg("username","image/img_t_8.png");
			$("#"+id).parent().parent().find("div:first").css('visibility','hidden');
		}else{
			flag=false;
			changeBkImg("username","image/img_t_6.png");
			$("#"+id).parent().parent().find("div:first").css('visibility','visible');
			$("#"+id).parent().parent().find("div:first").css('color','red');
		}
	}else if(id=="password"){
		if($("#ensurepassword").attr('value').replace(/\s+/g, "")==''){
			//确认密码未输入状态
		}else if((value==$("#ensurepassword").attr('value').replace(/\s+/g, ""))
				 && $("#ensurepassword").attr('value').indexOf(' ')==-1){
			changeBkImg("ensurepassword","image/img_t_8.png");
			$("#ensurepassword").parent().parent().find("div:first").css('visibility','hidden');
		}else{
			changeBkImg("ensurepassword","image/img_t_6.png");
			$("#ensurepassword").parent().parent().find("div:first").css('visibility','visible');
			$("#ensurepassword").parent().parent().find("div:first").css('color','red');
		}
		if(value.length >=6 && value.length <= 14  && $("#" + id).attr('value').indexOf(' ')==-1){
			flag=true;
			changeBkImg("password","image/img_t_8.png");
			$("#"+id).parent().parent().find("div:first").css('visibility','hidden');
		}else{
			flag=false;
			changeBkImg("password","image/img_t_6.png");
			$("#"+id).parent().parent().find("div:first").css('visibility','visible');
			$("#"+id).parent().parent().find("div:first").css('color','red');
		}
	}else if(id=="ensurepassword"){
		if((value.length!=0) && value==$("#password").attr('value').replace(/\s+/g, "")  && $("#" + id).attr('value').indexOf(' ')==-1){
			flag=true;
			changeBkImg("ensurepassword","image/img_t_8.png");
			$("#"+id).parent().parent().find("div:first").css('visibility','hidden');
		}else{
			flag=false;
			changeBkImg("ensurepassword","image/img_t_6.png");
			$("#"+id).parent().parent().find("div:first").css('visibility','visible');
			$("#"+id).parent().parent().find("div:first").css('color','red');
		}
	}else if(id=="name"){
		if(value.length >=2 && value.length <= 5 && (/^([\u4e00-\u9fa5])+$/.test(value))){
			flag=true;
			changeBkImg("name","image/img_t_8.png");
			$("#"+id).parent().parent().find("div:first").css('visibility','hidden');
		}else{
			flag=false;
			changeBkImg("name","image/img_t_6.png");
			$("#"+id).parent().parent().find("div:first").css('visibility','visible');
			$("#"+id).parent().parent().find("div:first").css('color','red');
		}
	}else if(id=="mobile"){
		 if((/^1[3|5|8]\d{9}$/.test(value)) || (/^0\d{2,3}-?\d{7,8}$/.test(value))){
				flag=true;
				changeBkImg("mobile","image/img_t_8.png");
				$("#"+id).parent().parent().find("div:first").css('visibility','hidden');
			}else{
				flag=false;
				changeBkImg("mobile","image/img_t_6.png");
				$("#"+id).parent().parent().find("div:first").css('visibility','visible');
				$("#"+id).parent().parent().find("div:first").css('color','red');
			}
	}else if(id=="email"){
		if(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(value)){
			flag=true;
			changeBkImg("email","image/img_t_8.png");
			$("#"+id).parent().parent().find("div:first").css('visibility','hidden');
		}else{
			flag=false;
			changeBkImg("email","image/img_t_6.png");
			$("#"+id).parent().parent().find("div:first").css('visibility','visible');
			$("#"+id).parent().parent().find("div:first").css('color','red');
		}
	}
	return flag;
	
}
/*提交注册*/
function gis_regist(){
	var id = "regist_form";
	 $.ajax({
		   type : "POST",
		   url : 'user/registerModify.do',
		   data : $('#'+id).serialize().replace(/\+/g, ''),
		   dataType : 'text',
		   beforeSend: function() {
		       return form_validate()==1?true:false;
		   },
		   success: function(msg){
			   if(msg=='1'){
				   var time = 5;
	   	    		setInterval(function () { 
	   	    		YMLib.Tools.showPrompt("ok-logo", "注册成功&nbsp;" + time + "秒后跳转！", 2000);
	   	    		time--;
		   	    		if (time >0) { 
		   	    		}else{ 
		   	    			window.location = 'login.jsp'; 
		   	    		} 
	   	    		}, 1000); 
			   }else if(msg=='2'){
				   changeBkImg("username","image/img_t_6.png");
				   $("#username").parent().parent().find("div:first").css('color','red');
				   YMLib.Tools.showPrompt("no-logo", "用户名已存在，不可用！", 5000);
			   } else{
				   YMLib.Tools.showPrompt("no-logo", "系统错误！请稍后尝试！", 5000);
			   }
		   	}
	});
}
//enter绑定
function enterBlind(event){                 
	//使用document.getElementById获取到按钮对象               
	var button = document.getElementById("regist");                
	if(event.keyCode == 13) {                        
		button.click();                       
		event.returnValue = false;                    
	}            
}
//表单验证
function form_validate(){
	return validate("username") & validate("password") & validate("ensurepassword")
	  & validate("name") & validate("mobile") & validate("email");
}

$(function() {
	/*var exit = "exit";
	$('#'+exit).mousedown(function(){
		changeImg(exit,"image/img_t_1d.png");
	});
	
	$('#'+exit).mouseout(function(){
		changeImg(exit,"image/img_t_1.png");
	});
	
	$('#'+exit).mouseup(function(){
		changeImg(exit,"image/img_t_1.png");
	});*/
	$('#login_img').mouseover(function(){
		$("#login_img").attr("src","image/img_t_3.png");
	});
	$('#login_img').mouseout(function(){
		$("#login_img").attr("src","image/img_100.png");
	});
	var username = "username";//用户名
	var password = "password";//密码
	$('#'+username).attr('value','');
	$('#'+password).attr('value','');
	var ensurepassword = "ensurepassword";//确认密码
	var name = "name";//真实姓名
	var mobile="mobile";//联系电话
	var email = "email";//电子邮箱
	var deptName = "deptName";//单位名称
	$('#'+username).focus(function(){
		changeBkImg(username,"image/img_t_5.png");
	});
	$('#'+ username).blur(function(){
		validate(username);
	});
	
	$('#'+password).focus(function(){
		changeBkImg(password,"image/img_t_5.png");	
	});
	$('#'+ password).blur(function(){
		validate(password);
	});
	$('#'+ensurepassword).focus(function(){
		changeBkImg(ensurepassword,"image/img_t_5.png");	
	});
	$('#'+ ensurepassword).blur(function(){
		validate(ensurepassword);
	});
	
	$('#'+name).focus(function(){
		changeBkImg(name,"image/img_t_5.png");	
	});
	$('#'+ name).blur(function(){
		validate(name);
	});
	$('#'+mobile).focus(function(){
		changeBkImg(mobile,"image/img_t_5.png");	
	});
	$('#'+ mobile).blur(function(){
		validate(mobile);
	});
	$('#'+email).focus(function(){
		changeBkImg(email,"image/img_t_5.png");	
	});
	$('#'+ email).blur(function(){
		validate(email);
	});
	$('#'+deptName).focus(function(){
		changeBkImg(deptName,"image/img_t_5.png");	
	});
	$('#'+ deptName).blur(function(){
		validate(deptName);
	});
	
	$('#regist').mousedown(function(){
		$('#regist').attr('src','image/btn_21d.png');
	});
	$('#regist').mouseup(function(){
		$('#regist').attr('src','image/btn_21.png');
	});
});