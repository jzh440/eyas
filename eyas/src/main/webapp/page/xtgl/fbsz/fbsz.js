/**
 * easyui 自定义验证。
 */
$(function() {
  $.extend($.fn.validatebox.defaults.rules, {
    http: {
      validator: function(value, param){
        var reg = /^(http|https|ftp)\:\/\/([a-zA-Z0-9\.\-]+(\:[a-zA-Z0-9\.&amp;%\$\-]+)*@)?((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|([a-zA-Z0-9\-]+\.)*[a-zA-Z0-9\-]+\.[a-zA-Z]{2,4})(\:[0-9]+)?(\/[^\/][a-zA-Z0-9\.\,\?\'\\/\+&amp;%\$#\=~_\-@]*)*$/;
        var result = value.match(reg);
        if(result) {
          return true;
        }
      },
      message: '请正确填写，例如：http://<servicename>:6080/arcgis/admin！'
    },
    data: {
      validator: function(value, param){
        var reg = /^[A-Za-z0-9\@]+$/;
        var result = value.match(reg);
        if(result) {
          if(value.length >= 5 && value.length <= 15) {
            return true;
          }
        }
      },
      message: '只能输入字母和数字，长度5-15个字符！'
    }
  });

});
function submit() {
 var parameter={};
 parameter.path=$.trim($("#path").val());
 parameter.userName=$.trim($("#userName").val());
 parameter.password=$.trim($("#password").val());
  $.ajax({
  type : "POST",
  url : '/gisyw/rest/arcgis/set',
  data : $.toJSON(parameter),
  dataType : 'json',
  contentType: "application/json", 
  beforeSend: function() {
    if(!$("#form").form('validate')) {
      $.messager.alert('错误！', '表单内容有误，请重新输入！');
      return false;
    }
  },
  success: function(msg){
   if(msg){
     YMLib.Tools.showPrompt("ok-logo", "保存成功！", 3000);
   } else {
     YMLib.Tools.showPrompt("no-logo", "保存失败！", 3000);
   }
  },
  error : function(){
    YMLib.Tools.showPrompt("i-logo", "提交请求后台出错！", 3000);
  }
  });
}