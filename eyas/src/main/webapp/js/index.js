/**
 * 文件名：index.js 
 * 作者：suc 
 * 更新时间：2014-04-22 
 * 功能描述： TODO
 */

//用于存储获取到的所有资源
var allResource_global = {};

$(function() {
	addUserName();
//	var values_ = MyUtil.Cookie.getCookie("user");
//	var values = values_.split(",");
//	 $("#username").text(values[0]+"，您好！");	 
	 
     $().navHover();
  function validate(id, current_event){
   if(current_event=='blur'){
      $('#'+id).blur(function(){
          if(id != 'newPassword_pass_i'){
           if($('#'+id).val().trim().length >=4 && $('#'+id).val().trim().length <=20){
             $('#'+id).css('background-image','url(image/img_password_1.png)');
             $('#' + id +'Tishi').attr("src","");
             $('#' + id +'Tishi').css("visibility","hidden");
             $('#messageTishi').text("");
           }else{
             $('#messageFont').attr("color","RED");
             $('#messageTishi').text("密码至少4个字符，最多20个字符");
             $('#'+id).css('background-image','url(image/img_password_3.png)');
             $('#' + id +'Tishi').attr("src","image/img_juser_7.png");
             $('#' + id +'Tishi').css("visibility","visible");
           }
         }else{
           if($('#'+id).val().trim() == $('#newPassword_pass').val().trim()
               && $('#'+id).val().trim().length >=4
               && $('#'+id).val().trim().length <=20){
             $('#'+id).css('background-image','url(image/img_password_1.png)');
             $('#' + id +'Tishi').attr("src","");
             $('#' + id +'Tishi').css("visibility","hidden");
             $('#messageTishi').text("");
           }else{
             $('#messageFont').attr("color","RED");
             $('#messageTishi').text("确认密码与新密码不一致");
             $('#'+id).css('background-image','url(image/img_password_3.png)');
             $('#' + id +'Tishi').attr("src","image/img_juser_7.png");
             $('#' + id +'Tishi').css("visibility","visible");
           }
         }
       }); 
    }else if(current_event=='focus'){
      $('#'+id).focus(function(){
        $('#'+id).css('background-image','url(image/img_password_2.png)');
        $('#' + id +'Tishi').attr("src","");
        $('#' + id +'Tishi').css("visibility","hidden");
      });
    }
  }; 
  validate('password_pass','blur');
  validate('newPassword_pass','blur');
  validate('newPassword_pass_i','blur');
  validate('password_pass','focus');
  validate('newPassword_pass','focus');
  validate('newPassword_pass_i','focus');
  
  $('#form_pass').form({
    url : "user/modifyPassword.do",
    onSubmit : function() {
      // 提交前去除表单数据的空格
      var pass = $.trim($("#password_pass").val());
      if (!pass || pass.length == 0) {
        YMLib.Tools.showPrompt("!-logo", "请输入当前密码！", 3000);
        return false();
      }
      var newPass = $.trim($("#newPassword_pass").val());
      if (!newPass || newPass.length == 0) {
        YMLib.Tools.showPrompt("!-logo", "请输入新密码！", 3000);
        return false();
      }
      var ensurePass = $.trim($('#newPassword_pass_i').val());
      if(!ensurePass || ensurePass.length ==0){
        YMLib.Tools.showPrompt("!-logo", "请输入确认密码！", 3000);
          return false();
      }
      if(ensurePass != newPass){
        YMLib.Tools.showPrompt("!-logo", "前后密码不一致！", 3000);
          return false();
      }
      $("#password_pass").val(pass);
      $("#newPassword_pass").val(newPass);

    },
    success : function(data) {
      if (data == 1) {
        YMLib.Tools.showPrompt("!-logo", "修改成功！", 3000);
        $('#dlg_pass').dialog('close');
      } else if (data == 2) {
        YMLib.Tools.showPrompt("!-logo", "当前密码不对，请重新输入！", 3000);
      } else if (data == 0) {
        YMLib.Tools.showPrompt("!-logo", "系统错误，请联系管理员！", 5000);
      }
    }
  });
  
  $("body").css("visibility", "visible");// 显示
  $("#mail_pop").css('display','none');
  function noticePop() {
    $.ajax({
      type : "post",
      url : "/giscj/message/countMessage.do",
      cache : false,
      dataType : 'json',
      success : function(data) {
      if(data==0)
      {
        $("#mail_pop").css('display','none');
      }
      else if (data > 0 && data < 100) {
          $("#mail_pop").html(data);
          $("#mail_pop").css('display','block');
        } else if (data > 99) {
          $("#mail_pop").html('99+');
          $("#mail_pop").css('display','block');
        }
      }
    });
  }
  //  noticePop();
  //  setInterval(noticePop, 1000*30);
});
/*
 * 获取所有资源
 */
function queryAllResource() {
  $.ajax({
    type : "POST",
    url : "",
    async : false,
    cache : false,
    data : "username=" + $.cookie("userName"),
    dataType : 'json',
    success : function(result) {
      allResource_global = result;
    },
    error : function() {
      YMLib.Tools.Show("系统错误，请联系系统管理员！", 5000);
    }
  });

}

function addUserName(){
	$.ajax({
	    type : "POST",
	    url : "/gisyw/user/getUserFromSession.do",
	    async : false,
	    cache : false,
	    dataType : 'json',
	    success : function(result) {
	 	 $("#username").text(result.username+"，您好！");
	    },
	    error : function() {
	      YMLib.Tools.Show("系统错误，请联系系统管理员！", 5000);
	    }
	  });
}
 /**
 * 通知按钮跳转
 */
function mail() {
  $("#index_left").accordion('select', '系统管理');
  $('#xxgl').click();
  $('#iframe_main').attr('src', 'page/xtgl/xxgl/xxgl.html');
}
/**
 * 选中状态效果
 * @param _id 被选中元素的id
 */
function selected(_id) {
  $("a").removeClass("selected-li");
  $("#" + _id).addClass("selected-li");
}
/*
 * 生成左侧Accordion
 */
function createLeft() {
  var html = "";
  if (!allResource_global || allResource_global.length == 0) {
    html = "您只有登录权限！如需要其他权限，请联系系统管理员……";
  }
  for (var i = 0; i < allResource_global.length; i++) {
    var temp = allResource_global[i];
    if (!temp.path && temp.pid) {
      html += "<div title='" + temp.title + "'><ul class='menu-item'>";
      for (var j = 0; j < allResource_global.length; j++) {
        var temp2 = allResource_global[j];
        if (temp2.pid == temp.id) {
          html += "<li><a href='" + temp2.path + "'target='iframe_main'>"
              + temp2.title + "</a></li>";
        }
      }
      html += "</ul></div>";
    }
  }
  $('#index_left').append(html);
  $("#index_left").accordion();
}

/*
 * 退出系统
 */
function logout() {
  
   $('#dlg_remove').dialog({
        title : "退出系统",
        modal : true,
        buttons : [ {
          text : '退出',
          handler : function() {
              $.ajax({
                  type : "post",
                  url : "/gisyw/user/logout.do",
                  async : false,
                  cache : false,
                  dataType : 'json',
                  success : function(data) {
                    if (data == 1) {
                      YMLib.Tools.showPrompt("ok-logo", "安全退出！", 1);
                      setCookie('user', '', -10000);
                      document.location.href = "login.jsp";
                  } else if (data == 0) {
                      YMLib.Tools.showPrompt("!-logo", "退出异常！", 0);
                  }
                  },
                  error : function() {
                    YMLib.Tools.showPrompt("!-logo", "系统错误，请联系系统管理员！", 5000);
                  }
                });
          }
        }, {
          text : '取消',
          handler : function() {
            $('#dlg_remove').dialog('close');
          }
        } ]
      });
  
}

/*
 * 显示修改密码模块
 */
function showDialogPass() {
  //session中取username
   $.ajax({
          type : "post",
          url : "user/getUserName.do",
          dataType : 'text',
          success : function(data) {
            if (data != '0') {
              $("#userName_pass").text(data);
          } else {
              $('#dlg_pass').dialog('close');
              var time = 5;
                setInterval(function () { 
                YMLib.Tools.showPrompt("!-logo", time + "秒后跳转，请登录后修改！", 2000);
                time--; 
                if (time >0) { 
                } else { 
                window.location = 'login.jsp '; 
                } 
                }, 1000); 
          }
          }
        });
   
  $('#form_pass span').text("");
  $('#form_pass input').css('background-image','url(image/img_password_1.png)');
  $('#form_pass img').attr("src","");
  $('#form_pass').form('clear');
  $('#dlg_pass').dialog({
    title : "修改密码",
    modal : true,
    buttons : [ {
      text : '修改',
      handler : function() {
        $('#form_pass').submit();
      }
    }, {
      text : '取消',
      handler : function() {
        $('#dlg_pass').dialog('close');
      }
    } ]
  });

  $("#password_pass").focus();
}

//设置cookie    
function setCookie(name, value, m) {
	 m = m || 0;   //seconds有值就直接赋值，没有为0，这个根php不一样。    
	 var expires = "";
	 if (m != 0 ) {      //设置cookie生存时间    
	 var date = new Date();
	 date.setTime(date.getTime()+(m*1000*60));    
	 expires = "; expires="+date.toGMTString();    
	 }
	 document.cookie = name+"="+escape(value)+expires+"; path=/";   //转码并赋值
}