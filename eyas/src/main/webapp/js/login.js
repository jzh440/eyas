$(function(){
	var username = "username";//用户名
	var password = "password";//密码
	var login = "login";//提交按钮
	
	var values_ = MyUtil.Cookie.getCookie("user");
	var values = values_.split(",");
	 $("#username").val(values[0]);
	 $("#password").val(values[1]);
	
	$('#regist_img').mouseover(function(){
		$("#regist_img").attr("src","/gisyw/image/img_t_2.png");
	});
	$('#regist_img').mouseout(function(){
		$("#regist_img").attr("src","/gisyw/image/img_t_4.png");
	});
	$('#'+username).focus(function(){
		changeBkImg("username","/gisyw/image/img_t_9d.png");
	});
	$('#'+username).blur(function(){
		changeBkImg("username","/gisyw/image/img_t_9.png");
//		var user_name = $("#username").attr('value').replace(/\s+/g, "");
//		var pass_word = MyUtil.Cookie.getCookie(user_name);
//		$("#password").val(pass_word);
	});
	$('#'+password).focus(function(){
		changeBkImg("password","/gisyw/image/img_t_10d.png");
//		var user_name = $("#username").attr('value').replace(/\s+/g, "");
//		var pass_word = MyUtil.Cookie.getCookie(user_name);
//		$("#password").val(pass_word);
	});
	$('#'+password).blur(function(){
		changeBkImg("password","/gisyw/image/img_t_10.png");
	});
	$('#'+login).mouseout(function(){
		changeBkImg(login,"/gisyw/image/btn_22.png");
	});
	$('#'+login).mouseup(function(){
		changeBkImg(login,"/gisyw/image/btn_22.png");
	});
	$('#'+login).mousedown(function(){
		changeBkImg(login,"/gisyw/image/btn_22d.png");
	});
});

/*背景图片变化*/
function changeBkImg(id,path){
	$("#"+id).css("background-image", "url("+path+")");
}

/*图片变化*/
function changeImg(id, path){
	$("#"+id).attr("src", path);
}

function enterBlind(event){                 
	//使用document.getElementById获取到按钮对象               
	var button = document.getElementById("login");                
	if(event.keyCode == 13) {                        
		button.click();                       
		event.returnValue = false;                    
	}            
} 
function gis_login(){
	 var id = "login_form";
	 var username=$("#username").attr('value');
	 var password=$("#password").attr('value');
//	 var password=$("#password").attr('value').replace(/\s+/g, "");
	 $.ajax({
		   type : "POST",
		   url : '/gisyw/user/login.do',
		   data : $('#'+id).serialize().replace(/\+/g, ""),
		   dataType : 'text',
		   beforeSend: function() {
			     if(username=='' || password=='') {
			    	 $('#login_message').css('color','red');
					 $('#login_message').text('用户名和密码不能为空！');
			       return false;
			     }
		   },
		   success: function(msg){
			   var obj=document.getElementById("remember");
			   if((msg=='1'||msg=='2')&&obj.checked){
				   //记住密码
//				   MyUtil.Cookie.addCookie(username, password,10*24*60);
				   
				   //保存登录状态
				   MyUtil.Cookie.addCookie("user",username+"," + password,30);
			   }else{
				   //不勾选，删除cookie
				   MyUtil.Cookie.deleteCookie("user");
				   MyUtil.Cookie.addCookie("user",username+"," + "",30);
//				   MyUtil.Cookie.addCookie("user",username+",");

//				   MyUtil.Cookie.addCookie(username,password,-1);
			   }
			  
			   
			   if(msg=='1'){
				   location.href="/gisyw/page/main/index.jsp";
			   }else if(msg=='2'){
				   location.href="/gisyw/portal/index/index.jsp";
			   }else if(msg=='3'){
				   $('#login_message').css('color','red');
				   $('#login_message').text('用户名或者密码错误！');
			   }else if(msg=='4'){
				   $('#login_message').css('color','red');
				   $('#login_message').text('用户还未被审核！');
			   }else if(msg=='5'){
				   $('#login_message').css('color','red');
				   $('#login_message').text('用户未通过审核！');
			   }else{
				   $('#login_message').css('color','red');
				   $('#login_message').text('登录请求异常！');
			   }
		   	},
		   error : function(){
			  $('#login_message').css('color','red');
			  $('#login_message').text('登录请求异常！');
		   }
	});
}
 
