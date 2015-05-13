$(function() {
  /**
   * 页面合法访问限制方法。
   */
  if (top.location == location) {
    alert("请合法访问页面，谢谢！");
    window.location.replace('/' + YMLib.projectName + '/index.jsp');
    return;
  }
  
  addOption('search_dw','/gisyw/dept/selectAllDept.do','全部');
  
  $('#table').datagrid({
    fit : true,
    fitColumns : true,
    loadMsg : '正在加载数据，请稍候...',
    url : "/gisyw/dept/selectForPage.do",
    rownumbers : true,
    autoRowHeight : false,
    rowStyler:function(index,row)
    {
    	return "height:40px;line-height:40px";
    },
    striped : true,
    pagination : true,
    pageSize : 15,
    pageList : [ 15, 30, 60 ],
    columns : [ [
//      {field:'ck',checkbox:true},
      {field:'id',title:'ID',hidden:true},
      /*{field : 'grid_button',title : '操作',align : 'center',halign : 'center',
        formatter : function(value, row, index) {
          var button1 = '<span  onclick="edit(' + index + ');" class="grid-button button-edit" title="编辑"></span> ';
          var button2 = '<span  onclick="regulator(\'1\', ' + index + ');" class="grid-button button-deletes" title="删除"></span> ';
          return button1 + button2;
        }
      },*/
      {field : 'name',title : '单位名称',width : 1,align : 'center',halign : 'center'},
      {field : 'leader',title : '负责人',width : 1,align : 'center',halign : 'center',
    	  formatter: function(value, row, index) {
    		  if(value==null||value==""){
    			  return "——";
    		  }else{
    			  return value;
    		  }
    	  }  
      },
      {field : 'address',title : '地址',width : 1,align : 'center',halign : 'center',
    	  formatter: function(value, row, index) {
    		  if(value==null||value==""){
    			  return "——";
    		  }else{
    			  return value;
    		  }
    	  }   
      },
      {field : 'tel',title : '电话',width : 1,align : 'center',halign : 'center',
    	  formatter: function(value, row, index) {
    		  if(value==null||value==""){
    			  return "——";
    		  }else{
    			  return value;
    		  }
    	  }   
      },
      {field : 'fax',title : '传真',width : 1,align : 'center',halign : 'center',
    	  formatter: function(value, row, index) {
    		  if(value==null||value==""){
    			  return "——";
    		  }else{
    			  return value;
    		  }
    	  }   
      },
      {field : 'postCode',title : '邮编',width : 1,align : 'center',halign : 'center',
    	  formatter: function(value, row, index) {
    		  if(value==null||value==""){
    			  return "——";
    		  }else{
    			  return value;
    		  }
    	  }   
      }
    ] ]
  });
  
});
function queryDw() {
  $('#table').datagrid('load', {
    name : $.trim($("#search_dw").val())
  });
}
function locationAdd() {
  window.location=('add/add.jsp');;
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
    ajaxUrl='/gisyw/dept/remove.do';
    text = '确定删除单位吗？';
    $.messager.confirm('确认？', text, function(r) { 
    	if(r){
    		$.ajax({
	    		type : "POST",
	    		url : ajaxUrl,
	    		data : "deptIds=" + ids,
	    		dataType : 'json',
	    		success: function(msg){
	    			if(msg=='1'){
	    				YMLib.Tools.showPrompt("ok-logo", "操作成功！", 3000);
	    				$('#table').datagrid("reload");
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
  }else{
	  $.ajax({
		    type : "POST",
		    url : ajaxUrl,
		    data : "deptIds=" + ids,
		    dataType : 'json',
		    success: function(msg){
		      if(msg=='1'){
		        YMLib.Tools.showPrompt("ok-logo", "操作成功！", 3000);
		        $('#table').datagrid("reload");
		      }else{
		        YMLib.Tools.showPrompt("no-logo", "操作失败！", 3000);
		      }
		    },
		    error : function(){
		      $.messager.alert('错误！', '操作出错！');
		    }
		 });
  }
}
function edit(_index) {
  row = $('#table').datagrid('getRows')[_index];
  window.location=('update/update.jsp?' + row.id);
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
			html += "<option value='' selected>全部</option>";
			for(var i=0;i<results.length;i++) {
				
				if(results[i].name == defaultValue) {
					html += "<option value='" + results[i].id + "' selected>" + results[i].name + "</option>";
				} else {
					html += "<option value='" + results[i].name + "'>" + results[i].name + "</option>";
				}
			}
			$("#"+id).append(html);
		},
		error: function(e) {
			YMLib.Tools.showPrompt("!-logo", "系统错误！请联系管理员！", 5000);
		}
	});
}




