document.write("<script language=javascript src='../portal/page/zyzx/dzfw/dzfw.js'></script>");
document.write("<script language=javascript src='../portal/page/zyzx/ljsq/ljsq.js'></script>");


function prompt(_logo, _content) {
	  var _t = $('<div></div>');
	  var _div = '<div class="' + _logo + '"></div>' + '<span class="prompt-content">' + _content + '</span>';
	  var _id = "winDiv" + new Date().getHours() + new Date().getMinutes() + new Date().getSeconds() + new Date().getMilliseconds();
	  _t.attr("id", _id);
	  _t.append(_div);
	  _t.addClass("prompt-box");
	  _t.appendTo('body');
	  return _id;
	}
function showPrompt(_logo, _content, _interval){
var _t = null ;
var _tipsid = prompt(_logo, _content);
var _left = $(document).width() / 2 - 120;
var _top = $(document).height() / 2-300;
function _closeTip(){
$("#" + _tipsid).fadeOut('slow',function(){
  $("#" + _tipsid).remove();
});
clearInterval(_t);
}
$("#" + _tipsid).css({
position : 'absolute',
left : _left,
top : _top,
display : 'none',
zIndex : 10000
});
$("#" + _tipsid).fadeIn('slow');
_t = setInterval(_closeTip, _interval);
}

function tijiao1(){
    var kssysj = document.getElementById("kssysj").value;
    var jssysj = document.getElementById("jssysj").value;
    var data1=stringToJsTime(kssysj);
    var data2=stringToJsTime(jssysj);
    var sCha=data2.getTime()-data1.getTime();
    var dCha=Math.floor(sCha/(24*3600*1000));
    if(dCha>365){
    	
    	alert('您申请的时间段超过一年了');

    	
    }
    var timeisok;
    if(jssysj){
    	 timeisok=opinionStartTimeEndTime(kssysj,jssysj);
    		if(!timeisok){
    			
    			alert('您选择的结束日期小于开始日期，无法统计 请重新输入！');
 
    		}
    }

}

function tijiao(){
        var rwmc = document.getElementById("rwmc").value;
        var kssysj = document.getElementById("kssysj").value;
        var jssysj = document.getElementById("jssysj").value;
        var sqsm = document.getElementById("sqsm").value;
      
        var s=opinionStartTimeEndTime(kssysj,jssysj);  
        if(rwmc.trim()==""){   		
        	alert("项目名称不能为空，请重新输入！");
    	}
    	else if(kssysj.trim()==""){
    		alert("申请日期开始时间不能为空，请重新输入！");
    	}
    	else if(jssysj.trim()==""){
    		alert("申请日期结束时间不能为空，请重新输入！");
    	}
    	else if(sqsm.trim()==""){
    		alert("申请说明不能够为空，请重新输入！");
    	}
    	else if(!s){
    		alert("您选择的结束日期小于开始日期，无法统计 请重新输入！");
		}//else if(!tijiao2()){ 
			//alert("您还没有选择申请条件哦 ！");
		//}
    	else{
    		//alert(2333);
    		window.form1.submit();
    
    	}
}
function tijiao3(param){
//	
//	if(param=='dzfw'){
//	
//		var content='';
//		var _childObjs=document.getElementsByName("check");
//		var _len=_childObjs.length;
//		
//		for(var i=0;i<_len;i++){
//			if(_childObjs[i].checked){
//				content+=_childObjs[i].value+",";
//			}
//		}
//	
//		content=content.substr(0,content.length-1);
//		alert(content);
//		$("#content").text(content);
//	
//	
//	}
	var gfmc=$("#relname").val();
	var suffix=gfmc.split(".")[1];
	var rwmc = document.getElementById("rwmc").value;
//	var kssysj = document.getElementById("startTime").value;
//	var jssysj = document.getElementById("endTime").value;
	var kssysj=$("#startTime").datebox('getValue');
	var jssysj=$("#endTime").datebox('getValue');
	var sqsm = document.getElementById("sqsm").value;
//	var s=opinionStartTimeEndTime(kssysj,jssysj);
	if(rwmc.trim()==""){ 
		alert('项目名称不能为空，请重新输入！');

	}
	else if(suffix!=""&&suffix!='png'&&suffix!="jpg"){
		alert('附件格式不正确，请重新选择！');

		
	}
	else if(kssysj.trim()==""){
		
		alert('申请日期开始时间不能为空，请重新输入！');

	
	}
	else if(jssysj.trim()==""){
		alert('申请日期结束时间不能为空，请重新输入！');
	
	}
	else if(sqsm.trim()==""){
		
		alert('申请说明不能够为空，请重新输入！');

	
	}else if(gfmc.length>300){
		
		alert('附件名称长度应在0-300之间');

		
	}else if($("input[name$=content]:checked").val()==null){
		alert("定制内容不能为空，请重新选择！");
		
	}
	
	
	
//	else if(!s){
//		$('#dlg_remove span').text('您选择的结束日期小于开始日期，无法统计 请重新输入！');
//		$("#dlg_remove").css("display","block");
//		$('#dlg_remove').dialog({
//	        title : "系统提示",
//	        modal : true,
//	        buttons : [ {
//	          text : '确定',
//	          handler : function() {
//	            $('#dlg_remove').dialog('close');
//	          }
//	        } ]
//	      });
//	}
	else{
		//alert(2333);
		window.form1.submit();
		onload();
	
	}
}

function tijiao2(){
	var serids =document.getElementsByName("ServicefwIDS");
	for(var i=0;i<serids.length;i++){
		if(serids[i].checked){
			
			return true;
		}
		
		
	}
	return false;
}
String.prototype.trim=function() {

    return this.replace(/(^\s*)|(\s*$)/g,'');
}


function opinionStartTimeEndTime(stratTime , endTime ){
        // 截取日期字符串
		if(stratTime&&endTime){
	        var strat = stratTime.split( "-" );
	        var end = endTime.split( "-" );
	        if( parseInt(strat[0]) < parseInt( end[0]) ){
	            return true ;
	        }else if( parseInt(strat[0]) > parseInt( end[0])){
	        	return false;
	        }else{
	        	if(parseInt(strat[1]) < parseInt( end[1])) return true;
	        	else if(parseInt(strat[1]) > parseInt( end[1])) return false;
	        	else{
	        		if(parseInt(strat[2]) < parseInt( end[2])) return true;
		        	else  return false;
	        	}
	        }
	        return false ;
		}
		return false ;
     // 判断
        
    } 

//将字符串转换为js的时间对象，  字符串格式yyyy-MM-dd HH:ss:mm       
function stringToJsTime(timeString) {      
    var y = timeString.substring(0,4);      
    var m = timeString.substring(5,7)-1;      
    var d = timeString.substring(8,10);      
   // var h = timeString.substring(11,13);      
   // var mm = timeString.substring(14,16);      
    //var ss = timeString.substring(17,19);      
    var time = new Date(y,m,d,0,0,0,0);      
    return time;      
}    

