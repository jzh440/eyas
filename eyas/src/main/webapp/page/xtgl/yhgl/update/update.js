$(function() {
	
	
	 addOption('deptId','/gisyw/dept/selectAllDept.do');
	  var username = "username_update";//用户名
		var mobile="mobile_update";//联系电话
		var email = "email_update";//电子邮箱
		var deptName = "deptName_update";//单位名称
		
		$('#'+ username).blur(function(){
			validate(username);
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
		
		$('#'+ mobile).focus(function(){
			$('#'+mobile).parent().parent().find('td:last').attr("class","td-vali");
		});
		
		$('#'+ email).focus(function(){
			$('#'+email).parent().parent().find('td:last').attr("class","td-vali");
		});
		
		$('#'+ deptName).focus(function(){
			$('#'+deptName).parent().parent().find('td:last').attr("class","td-vali");
		});
		
  /**
   * 页面合法访问限制方法。
   */
  if (top.location == location) {
    alert("请合法访问页面，谢谢！");
    window.location.replace('/' + YMLib.projectName + '/index.html');
    return;
  }
  
  var tuseridUrl = window.location.search;
  var tuserid = '';
  if(tuseridUrl != "") {
    tuserid = tuseridUrl.substring(1, tuseridUrl.length+1);
  }
  if(tuserid != '') {
    $.ajax({
        type : "POST",
        url : '/gisyw/user/queryById.do',
        data : "id=" + tuserid,
        async: false,
        dataType : 'json',
        success: function(msg){
          $("#form_update").form("load",msg);
          if(msg.role[0].id=='1'){
        	  $("#option2").attr("selected","selected");
          }else if(msg.role[0].id=='2'){
        	  $("#option1").attr("selected","selected");
          }
          if(msg.deptId==""&&msg.deptName!=null){
        	  $('#dp').html('');
        	  $('#dp').html('<input id="deptName" name="deptName" disabled="disabled" value='+msg.deptName+' type="text">');
          }
//          $.ajax({
//  	        type : "POST",
//  	        url : '/gisyw/user/getPid.do',
//  	        data : "id=" + tuserid,
//  	        async: false,
//  	        dataType : 'json',
//  	        success: function(msg){
//  	        	if(msg=="1"){
//  	        		$('#roleId').attr('disabled',true);
//  	        	}
//  	        }
//  	    });
          $('#password_update').val('');
        },
        error : function(){
          $.messager.alert('错误！', '查询数据失败！');
        }
     }); 
  }
 
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
	if(id=="username_update"){
		if(value.length >=6){
			flag=true;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali");
		}else{
			flag=false;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali-error");
		}
	}else if(id=="mobile_update"){
		 if((/^1[3|5|8]\d{9}$/.test(value)) || (/^0\d{2,3}-?\d{7,8}$/.test(value))){
				flag=true;
				$('#'+id).parent().parent().find('td:last').attr("class","td-vali");
			}else{
				flag=false;
				$('#'+id).parent().parent().find('td:last').attr("class","td-vali-error");
			}
	}else if(id=="email_update"){
		if(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(value)){
			flag=true;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali");
		}else{
			flag=false;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali-error");
		}
	}else if(id=="deptName_update"){
		if(value.length >=4){
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
	return validate("username_update") & validate("mobile_update") & validate("email_update");
}
/**
 * 取消跳转
 */
function cancelupdate() {
  window.location=('/gisyw/page/xtgl/yhgl/yhgl.jsp');
}
/**
 * 提交
 */
function update() {
  var id = "form_update";
  $.ajax({
   type : "POST",
   url : '/gisyw/user/registerModify.do',
   data : $('#'+id).serialize().replace(/\+/g, ""),
   dataType : 'json',
   beforeSend: function() {
	   return form_validate()==1?true:false;
   },
   success: function(msg){
     if(msg=='3'){
       YMLib.Tools.showPrompt("ok-logo", "保存成功, 2秒后跳转。", 5000);
       setTimeout(cancelupdate, 2000);
     }else{
       YMLib.Tools.showPrompt("no-logo", "保存失败！", 5000);
     }
   },
   error : function(){
     YMLib.Tools.showPrompt("i-logo", "提交请求后台出错！", 5000);
   }
  });
}