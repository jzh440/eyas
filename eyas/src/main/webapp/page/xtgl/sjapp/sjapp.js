$(function() {
	
	
});

function diaOpen(){
		$("#tsxx").css("display","none");
	    $("#dlg_import").show();
	    $('#dlg_import').dialog({
	        title : "版本更新"
	    });
	    $("#import").attr("onclick","importDate();");
}

function open_btn(){
    $("#appfile").click();
}

function diaclose(){
    $('#dlg_import').dialog('close');
}

function diaclose(){
    $('#dlg_import').dialog('close');
} 

function importDate(){
	var rurl = null;
  	rurl="/gisyw/sjapp/uploadApp.do";
	var location=$("#filename").val();  
	var point = location.lastIndexOf(".");  
	var type = location.substr(point);  
	if(type==".apk"){	
  	$('#form_import').form('submit',{
  		url:rurl,
	    onSubmit: function(){
	    	YMLib.Tools.showPrompt("progress-logo", "正在上传，请稍后...", 100000000);
	    },
	    success:function(data){
	    	
	    	$('.prompt-box').remove();
	    	if(data){
	    	 YMLib.Tools.showPrompt("ok-logo", "更新成功！", 3000);
	    	}else{
	    		 YMLib.Tools.showPrompt("ok-logo", "更新失败！", 3000);
	    	}
	    	 $('#dlg_import').dialog('close');
	    }
  		});
  		diaclose();
		}else{
			$("#tsxx").css("display","block");
		}
	
}

function getValue(){

	var fileName= $("#appFile").val().split("\\").pop();  	
	$("#filename").attr("value",fileName);
}

//function downApp(){
//	$.ajax({
//		url:'/gisyw/rest/downApp/down',
//		type : 'get',
//		cache : false,
//		dataType : 'json',
//		success : function(obj) {
//			if(obj==null){
//				 $.messager.alert('提示！', '暂无应用！');
//			}else{
//				alert(obj);
//			}
//			
//		}
//	});
//}