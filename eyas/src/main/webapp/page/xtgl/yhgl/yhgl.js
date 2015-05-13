$(function() {
  /**
   * 页面合法访问限制方法。
   */
  if (top.location == location) {
    alert("请合法访问页面，谢谢！");
    window.location.replace('/' + YMLib.projectName + '/index.jsp');
    return;
  }
  
  $('#table').datagrid({
    fit : true,
    fitColumns : true,
    loadMsg : '正在加载数据，请稍候...',
    url : "/gisyw/user/selectForPage.do",
    rownumbers : true,
    autoRowHeight : true,
    striped : true,
    pagination : true,
    pageSize : 15,
    pageList : [ 15, 30, 60 ],
    columns : [ [
      {field:'ck',checkbox:true},
      {field:'id',title:'ID',hidden:true},
      {field : 'grid_button',title : '操作',align : 'center',halign : 'center',
        formatter : function(value, row, index) {
        	if(row.state!='4'){
          var button1 = '<span  onclick="edit(' + index + ');" class="grid-button button-edit" title="编辑"></span> ';
          var button2 = '<span  onclick="regulator(\'1\', ' + index + ');" class="grid-button button-deletes" title="删除"></span> ';
          return button1 + button2;
          }else{
        	  var button = '<span  onclick="unlock(' + index + ');" class="grid-button1 button-lock" title="解锁"></span> ';
        	  return button;
          }
        }
      },
      {field : 'state',title : '审核状态',width : 1,align : 'center',halign : 'center',
    	  formatter:function(value, row, index){
    		  if(value=='1'||value=='2'||value=='3'){
    			  return '已审核';
    		  }
    		  if(value=='0'){
    			  return '未审核';
    		  }
    		  if(value=='4'){
    			  return '已锁定';
    		  }
//    		  return (value=='1'||value=='2')?'已审核':'未审核';
    	  }},
      {field : 'type',title : '用户类型',width : 1,align : 'center',halign : 'center',
    		formatter:function(value,row,index){
    			
    			if(row.role.length>0){
    				return row.role[0].roleName;
    			}else{
    				return "";
    			}
    		}
      },
      {field : 'username',title : '用户名称',width : 1,align : 'center',halign : 'center'},
      {field : 'name',title : '姓名',width : 1,align : 'center',halign : 'center'},
      {field : 'deptName',title : '单位',width : 1,align : 'center',halign : 'center'},
      {field : 'mobile',title : '电话',width : 1,align : 'center',halign : 'center'},
      {field : 'email',title : '邮箱',width : 1,align : 'center',halign : 'center'}
    ] ]
  });
  
	addOption('search_dw','/gisyw/dept/selectDept.do');

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
			html += "<option value='' selected>全部</option>";
			for(var i=0;i<results.length;i++) {
				
				if(results[i].id == defaultValue) {
					
					html += "<option value='" + results[i].id + "' selected>" + results[i].name + "</option>";
				} else {
					html += "<option value='" + results[i].id + "'>" + results[i].name+ "</option>";
				}
			}
			$("#"+id).append(html);
		},
		error: function(e) {
			YMLib.Tools.showPrompt("!-logo", "系统错误！请联系管理员！", 5000);
		}
	});
}


/* 条件查询 */
function queryYh() {
  $('#table').datagrid('load', {
    deptId : $.trim($("#search_dw").val()),
    state : $.trim($("#search_zt").val())
  });
}
/* 跳转添加 */
function locationAdd() {
  window.location=('add/add.jsp');
}
/**
 * 控制调节器
 * @param _index
 *    操作对象数据表格标号，用于找到操作数据
 * @param _parameter
 *    参数： 1、删除  2、审核
 */
function regulator(_parameter, _index) {
  /* 获取当前操作对象 */
  var row, ids, ajaxUrl = '';
  if(_index != null) {
    row = $('#table').datagrid('getRows')[_index];
    ids = row.id;
  } else {
    row = $('#table').datagrid("getSelections");
    if(!row || row.length == 0){
      $.messager.alert('警告！', '请选择要操作的数据！');
      return;
    }
    ids = hdsxUtil.Tools.ArrayToString(row);
    
  }
  if(_parameter == '1') {
    /* 删除url */
    ajaxUrl='/gisyw/user/remove.do';
    text="确定删除用户吗？";
  } else if(_parameter == '2') {
    /* 审核url */
    ajaxUrl='/gisyw/user/emamine.do';
    text="确定审核用户吗？";
  }
  $.messager.confirm('确认？', text, function(r) { 
	 if(r){
	  $.ajax({
	    type : "POST",
	    url : ajaxUrl,
	    data : "userIds=" + ids,
	    dataType : 'json',
	    success: function(msg){
	      if(msg=='1'){
	        YMLib.Tools.showPrompt("ok-logo", "操作成功！", 3000);
	        $('#table').datagrid("reload");
	      }else if(msg=='2'){
	    	  $.messager.alert('警告！', '已锁定用户无需审核！');
		  }else if(msg=='3'){
	    	  $.messager.alert('警告！', '该用户无需审核！');
		  }else{
	        YMLib.Tools.showPrompt("no-logo", "操作失败！", 3000);
	      }
	    },
	    error : function(){
	      $.messager.alert('错误！', '操作出错！');
	    }
	 });
	 }
  });
}
function edit(_index) {
  row = $('#table').datagrid('getRows')[_index];
  window.location=('update/update.jsp?' + row.id);
}

//重置密码
function locationResetps(){
	  var row = '';
	    row = $('#table').datagrid("getSelections");
	    if(!row || row.length == 0){
	      $.messager.alert('警告！', '请选择要操作的数据！');
	      return;
	    }
	    ids = hdsxUtil.Tools.ArrayToString(row);
	    $.messager.confirm('确认？', "确认重置？", function(r) { 
	   	 if(r){
	   	  $.ajax({
	   	    type : "POST",
	   	    url : '/gisyw/user/restPassw.do',
	   	    data : "userIds=" + ids,
	   	    dataType : 'json',
	   	    success: function(msg){
	   	      if(msg=='1'){
	   	        YMLib.Tools.showPrompt("ok-logo", "密码重置为123456！", 3000);
	   	        $('#table').datagrid("reload");
	   	      }else{
	   	        YMLib.Tools.showPrompt("no-logo", "密码重置失败！", 3000);
	   	      }
	   	    },
	   	    error : function(){
	   	      $.messager.alert('错误！', '操作出错！');
	   	    }
	   	 });
	   	 }
	     });
	  }
function unlock(_index){
	  var row = '';
	  if(_index!=null){
	  row = $('#table').datagrid('getRows')[_index];
	  ids=row.id;
	  }else{
		  row = $('#table').datagrid("getSelections");
		  ids = hdsxUtil.Tools.ArrayToString(row);
	  }
	    if(!row || row.length == 0){
	      $.messager.alert('警告！', '请选择要操作的数据！');
	      return;
	    }
	    
	    $.messager.confirm('确认？', "确认解锁？", function(r) { 
	   	 if(r){
	   	  $.ajax({
	   	    type : "POST",
	   	    url : '/gisyw/user/changeState.do',
	   	    data : "userIds=" + ids,
	   	    dataType : 'json',
	   	    success: function(msg){
	   	      if(msg=='1'){
	   	    	YMLib.Tools.showPrompt("ok-logo", "解锁成功！", 3000);
	   	        $('#table').datagrid("reload");
	   	      }
	   	      if(msg=='0'){
	   	    	YMLib.Tools.showPrompt("no-logo", "解锁失败！", 3000);
	   	      }
	   	 	if(msg=='2'){
	   	 		$.messager.alert('警告！', '该用户无需解锁！');
	   	      }
	   	 	if(msg=='3'){
	   	 		$.messager.alert('警告！', '未审核的用户不能解锁！');
	   	 	}

	   	    }
	   	  });
	   	 }
	    });
}
