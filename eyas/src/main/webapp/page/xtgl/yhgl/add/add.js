$(function() {
  /**
   * 页面合法访问限制方法。
   */
  if (top.location == location) {
    alert("请合法访问页面，谢谢！");
    window.location.replace('/' + YMLib.projectName + '/index.jsp');
    return;
  }
  
	addOption('deptId','/gisyw/dept/selectAllDept.do');
  
  var username = "username_add";//用户名
	var password = "password_add";//密码
	var ensurepassword = "password_confirm";//确认密码
	var name = "name_add";//真实姓名
	var mobile="mobile_add";//联系电话
	var email = "email_add";//电子邮箱
	var deptName = "deptName_add";//单位名称
	$('#'+username).attr('value','');
	$('#'+password).attr('value','');
	$('#'+ username).blur(function(){
		validate(username);
	});
	
	$('#'+ password).blur(function(){
		validate(password);
	});
	
	$('#'+ ensurepassword).blur(function(){
		validate(ensurepassword);
	});
	
	$('#'+ name).blur(function(){
		validate(name);
	});
	
	$('#'+ mobile).blur(function(){
		validate(mobile);
	});
	
	$('#'+ email).blur(function(){
		validate(email);
	});
	
	$('#'+ deptName).blur(function(){
		validate(deptName);
	});
	$('#'+ username).focus(function(){
		$('#'+username).parent().parent().find('td:last').attr("class","td-vali");
	});
	
	$('#'+ password).focus(function(){
		$('#'+password).parent().parent().find('td:last').attr("class","td-vali");
	});
	
	$('#'+ ensurepassword).focus(function(){
		$('#'+ensurepassword).parent().parent().find('td:last').attr("class","td-vali");
	});
	
	$('#'+ name).focus(function(){
		$('#'+name).parent().parent().find('td:last').attr("class","td-vali");
	});
	
	$('#'+ mobile).focus(function(){
		$('#'+mobile).parent().parent().find('td:last').attr("class","td-vali");
	});
	
	$('#'+ email).focus(function(){
		$('#'+email).parent().parent().find('td:last').attr("class","td-vali");
	});
	
	$('#'+ deptName).focus(function(){
		$('#'+deptName).parent().parent().find('td:last').attr("class","td-vali");
	});
	
});


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
			html += "<option value='其他单位'>其他单位</option>";
			$("#"+id).append(html);
		},
		error: function(e) {
			YMLib.Tools.showPrompt("!-logo", "系统错误！请联系管理员！", 5000);
		}
	});
}

/*表单验证*/
function validate(id){
	var flag=true;
	var value = $("#" + id).attr('value').replace(/\s+/g, '');
	if(id=="username_add"){
		if(value.length >=6&&!(/[\u4E00-\u9FA5]/.test(value))){
			flag=true;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali");
		}else{
			flag=false;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali-error");
		}
	}else if(id=="password_add"){
		if((value==$("#password_confirm").attr('value').replace(/\s+/g, '')) 
				&& ($("#password_confirm").attr('value').replace(/\s+/g, '')!='')
				 && $("#password_confirm").attr('value').indexOf(' ')==-1){
			$('#password_confirm').parent().parent().find('td:last').attr("class","td-vali");
		}else{
			$('#password_confirm').parent().parent().find('td:last').attr("class","td-vali-error");
		}
		if(value.length >=6 && value.length <= 14  && $("#" + id).attr('value').indexOf(' ')==-1){
			flag=true;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali");
		}else{
			flag=false;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali-error");
		}
	}else if(id=="password_confirm"){
		if((value.length!=0) && value==$("#password_add").attr('value').replace(/\s+/g, '')  && $("#" + id).attr('value').indexOf(' ')==-1){
			flag=true;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali");
		}else{
			flag=false;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali-error");
		}
	}else if(id=="name_add"){
		if(value.length >=2 && value.length <= 5 && (/^([\u4e00-\u9fa5])+$/.test(value))){
			flag=true;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali");
		}else{
			flag=false;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali-error");
		}
	}else if(id=="mobile_add"){
		 if((/^1[3|5|8]\d{9}$/.test(value)) || (/^0\d{2,3}-?\d{7,8}$/.test(value))){
				flag=true;
				$('#'+id).parent().parent().find('td:last').attr("class","td-vali");
			}else{
				flag=false;
				$('#'+id).parent().parent().find('td:last').attr("class","td-vali-error");
			}
	}else if(id=="email_add"){
		if(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(value)){
			flag=true;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali");
		}else{
			flag=false;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali-error");
		}
	}
	return flag;
}

//表单验证
function form_validate(){
	return validate("username_add") & validate("password_add") & validate("password_confirm")
	  & validate("name_add") & validate("mobile_add") & validate("email_add") & validate("deptId");
}
/**
 * 取消跳转
 */
function cancelAdd() {
  window.location=('/gisyw/page/xtgl/yhgl/yhgl.jsp');
}
/**
 * 提交
 */
function add() {
  var id = "form_add";
  $.ajax({
   type : "POST",
   url : '/gisyw/user/add.do',
   data : $('#'+id).serialize().replace(/\+/g, ""),
   dataType : 'json',
   beforeSend: function() {
	   return form_validate()==1?true:false;
   },
   success: function(msg){
     if(msg=='1'){
       YMLib.Tools.showPrompt("ok-logo", "保存成功, 2秒后跳转。", 5000);
       setTimeout(cancelAdd, 2000);
     }else if(msg=='2'){
       YMLib.Tools.showPrompt("no-logo", "用户名已存在,不可用！", 5000);
       $('#username_add').parent().parent().find('td:last').attr("class","td-vali-error");
     }else{
       YMLib.Tools.showPrompt("no-logo", "保存失败！", 5000);
     }
   },
   error : function(){
     YMLib.Tools.showPrompt("i-logo", "提交请求后台出错！", 5000);
   }
  });
}


function getDpName() {
	if($("#deptId").val()=="其他单位"){
		$("#otherDp").css("display","");
	}
	
}
