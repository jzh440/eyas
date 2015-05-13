$(function() {
  /**
   * 页面合法访问限制方法。
   */
  if (top.location == location) {
    alert("请合法访问页面，谢谢！");
    window.location.replace('/' + YMLib.projectName + '/index.jsp');
    return;
  }
  var deptidUrl = window.location.search;
  var deptid = '';
  if(deptidUrl != "") {
    deptid = deptidUrl.substring(1, deptidUrl.length+1);
  }
  
  if(deptid != '') {
    $.ajax({
        type : "POST",
        url : '/gisyw/dept/queryById.do',
        data : "id=" + deptid,
        dataType : 'json',
        success: function(msg){
          $("#form_update").form("load",msg);
          $('#password_update').val('');
        },
        error : function(){
          $.messager.alert('错误！', '查询数据失败！');
        }
     }); 
  }
  var name = "name";//用户名
	var leader = "leader";//密码
	var tel = "tel";//确认密码
	var fax = "fax";//真实姓名
	var postCode="postCode";//联系电话
	var address = "address";//电子邮箱
	
	$('#'+ name).blur(function(){
		validate(name);
	});
	
	$('#'+ leader).blur(function(){
		validate(leader);
	});
	
	$('#'+ tel).blur(function(){
		validate(tel);
	});
	
	$('#'+ fax).blur(function(){
		validate(fax);
	});
	
	$('#'+ postCode).blur(function(){
		validate(postCode);
	});
	
	$('#'+ address).blur(function(){
		validate(address);
	});
	
	$('#'+ name).focus(function(){
		$('#'+name).parent().parent().find('td:last').attr("class","td-vali");
	});
	
	$('#'+ leader).focus(function(){
		$('#'+leader).parent().parent().find('td:last').attr("class","td-vali");
	});
	
	$('#'+ tel).focus(function(){
		$('#'+tel).parent().parent().find('td:last').attr("class","td-vali");
	});
	
	$('#'+ fax).focus(function(){
		$('#'+fax).parent().parent().find('td:last').attr("class","td-vali");
	});
	
	$('#'+ postCode).focus(function(){
		$('#'+postCode).parent().parent().find('td:last').attr("class","td-vali");
	});
	
	$('#'+ address).focus(function(){
		$('#'+address).parent().parent().find('td:last').attr("class","td-vali");
	});
  
});
/*表单验证*/
function validate(id){
	var flag=true;
	var value = $("#" + id).attr('value').replace(/\s+/g, '');
	if(id=="name"){
		if(value.length >=4){
			flag=true;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali");
		}else{
			flag=false;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali-error");
		}
	}else if(id=="leader"){
		if(value.length >=2 && value.length <= 5 && (/^([\u4e00-\u9fa5])+$/.test(value))){
			flag=true;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali");
		}else{
			flag=false;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali-error");
		}
	}else if(id=="tel"){
		if(/^0\d{2,3}-?\d{7,8}(-?(\d{3}))?$/.test(value)){
			flag=true;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali");
		}else{
			flag=false;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali-error");
		}
	}else if(id=="fax"){
		if(/^0\d{2,3}-?\d{7,8}-?(\d{3})$/.test(value)){
			flag=true;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali");
		}else{
			flag=false;
			$('#'+id).parent().parent().find('td:last').attr("class","td-vali-error");
		}
	}else if(id=="postCode"){
		 if(/^[0-9]{6}$/.test(value)){
				flag=true;
				$('#'+id).parent().parent().find('td:last').attr("class","td-vali");
			}else{
				flag=false;
				$('#'+id).parent().parent().find('td:last').attr("class","td-vali-error");
			}
	}else if(id=="address"){
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
	return validate("name") & validate("leader") & validate("tel")
	  & validate("fax") & validate("postCode") & validate("address");
}
/**
 * 取消跳转
 */
function cancelupdate() {
  window.href='/gisyw/page/xtgl/dwgl/dwgl.jsp';
}
/**
 * 提交
 */
function update() {
  var id = "form_update";
  $.ajax({
   type : "POST",
   url : '/gisyw/dept/addModify.do',
   data : $('#'+id).serialize().replace(/\+/g, ""),
   dataType : 'json',
   beforeSend: function() {
	   return form_validate()==1?true:false;
   },
   success: function(msg){
     if(msg=='3'){
       YMLib.Tools.showPrompt("ok-logo", "保存成功, 2秒后跳转。", 5000);
       setTimeout(cancelupdate, 2000);
     }else if(msg=='4'){
    	 YMLib.Tools.showPrompt("no-logo", "单位名已存在，不可用！", 2000);
    	 $('#name').parent().parent().find('td:last').attr("class","td-vali-error");
     }else{
       YMLib.Tools.showPrompt("no-logo", "保存失败！", 5000);
     }
   },
   error : function(){
     YMLib.Tools.showPrompt("i-logo", "提交请求后台出错！", 5000);
   }
  });
}
