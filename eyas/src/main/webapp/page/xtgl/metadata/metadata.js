var tcData = {
    tcmc: '', // 图层名称
    sjly: '', // 数据来源
    tclx: '', // 图层类型
    gxpl: '', // 更新频率
    ssfl: '', // 所属分类
    bbsj: '', // 版本时间
    imgSrc: ''
};
var tableData = '', cjx = '';

$(function() {
    init();
    $('#tc_form').form({
		url : "/eyas/registry/modify.do",
		clearForm:true,
		onSubmit : function() {
			var data=$('#table').datagrid('getData').rows;
			$("#text").val( JSON.stringify(data));
		},
		success : function(data) {
		}
	});
    
});

// 初始化页面
function init() {

    // 新增采集项
    addCjx();

    // 删除采集项
    delCjx();

    // cjx导航
    getCjx('1');

    // 导航相关
    ztEvent();

    // 图层相关
    tcEdit();
    tcCencel();
    tcSave();

    // 表格相关
    toolbarAdd();
    toolbarDel();
}
// 编辑图层按钮
function tcEdit() {
    $('.tc-edit').click(function(e) {
        console.log('编辑');
        $(this).hide();
        $('#tc_div').hide();
        $('#tc_form').show();
        $('.tc-cencel').show();
        $('.tc-save').show();
        $('.tc-pic button').show();
        $('.fh-ts').show();
        getTcForm();
        $('#tc_form').form('load', tcData);
        fhButton();
    });
}

// 保存图层按钮
function tcSave() {
    $('.tc-save').click(function(e) {
        console.log('保存');
        $('#tc_form').submit();
        saveAndCancelCss();
        // 刷新图层 div
        setTcDiv();
        // 清空表单
    });
}

// 取消图层按钮
function tcCencel() {
    $('.tc-cencel').click(function(e) {
        console.log('取消');
        $('#fh_img').attr('src', tcData.imgSrc);
        saveAndCancelCss();
        // 清空表单
        $('#tc_form').form('clear');
    });
}

// 保存和取消样式控制
function saveAndCancelCss() {
    $('.tc-edit').show();
    $('#tc_div').show();
    $('#tc_form').hide();
    $('.tc-cencel').hide();
    $('.tc-save').hide();
    $('.tc-pic button').hide();
    $('.fh-ts').hide();
}
// 获取表单数据
function getTcForm() {
    tcData.tcmc = $.trim($('#tcmc').text());
    tcData.sjly = $.trim($('#sjly').text());
    tcData.tclx = $.trim($('#tclx').text());
    tcData.gxpl = $.trim($('#gxpl').text());
    tcData.ssfl = $.trim($('#ssfl').text());
    tcData.bbsj = $.trim($('#bbsj').text());
    tcData.imgSrc = $.trim($('#fh_img').attr('src'));
    console.log(tcData);
    return tcData;
}

// 放置图层 div 的值
function setTcDiv() {
    $('#tcmc').text(tcData.tcmc);
    $('#sjly').text(tcData.sjly);
    $('#tclx').text(tcData.tclx);
    $('#gxpl').text(tcData.gxpl);
    $('#ssfl').text(tcData.ssfl);
    $('#bbsj').text(tcData.bbsj);
    $('#fh_img').attr('src', tcData.imgSrc);
}
// 添加符号按钮
function fhButton() {
    var oFReader = new FileReader(), rFilter = /^(?:image\/bmp|image\/cis\-cod|image\/gif|image\/ief|image\/jpeg|image\/jpeg|image\/jpeg|image\/pipeg|image\/png|image\/svg\+xml|image\/tiff|image\/x\-cmu\-raster|image\/x\-cmx|image\/x\-icon|image\/x\-portable\-anymap|image\/x\-portable\-bitmap|image\/x\-portable\-graymap|image\/x\-portable\-pixmap|image\/x\-rgb|image\/x\-xbitmap|image\/x\-xpixmap|image\/x\-xwindowdump)$/i;
    oFReader.onload = function(oFREvent) {
        var src = oFREvent.target.result;
        console.log(src);
        $('#fh_img').attr('src', src);
    };
    $('#fh_button').click(function(e) {
        $('#fh_input').click();
    });

    $('#fh_input').change(function() {
        if (document.getElementById("fh_input").files.length > 1) {
            alert("你只能上传一张图片!");
            return;
        }
        var oFile = document.getElementById("fh_input").files[0];
        console.log(oFile);
        if (!rFilter.test(oFile.type)) {
            alert("你选择的不是图片!");
            return;
        }
        oFReader.readAsDataURL(oFile);
    });
}

// 表格添加按钮
function toolbarAdd() {
    $('.toolbar-add').click(function(e) {
        console.log('添加');
        $('#toolbar_add').show();
        $('#toolbar_add').dialog({
            title: '添加属性',
            width: 500,
            height: 420,
            modal: true,
            buttons:[{
                text:'保存',
                handler:function(){
                    $('#table').datagrid('appendRow',{
                    	name: $('#sx_name').val(),
                    	code: $('#sx_code').val(),
                    	type: $('#sx_type').val(),
                    	domain: $('#sx_domain').val(),
                    	isNull: $('#sx_isNull').val()
                    });
                    $('#toolbar_add').dialog('close');
                }
            },{
                text:'关闭',
                handler:function(){
                    $('#toolbar_add').dialog('close');
                }
            }]
        });
    });
}

// 表格删除按钮
function toolbarDel() {
    $('.toolbar-del').click(function(e) {
        var rows = $('#table').datagrid("getSelections");
        if (!rows || rows.length == 0) {
            $.messager.alert('警告！', '请选择要删除的数据！');
            return;
        }
        $.messager.confirm('确认？', '是否要这些删除数据？', function(r) {
            if (r) {
                console.log('删除了' + rows.length + '条数据。');
                $.ajax({
                    type: "POST",
                    url: "/eyas/registry/delColumns.do",
                    data: "ids=" +  hdsxUtil.Tools.ArrayToString(rows),
                    dataType: 'json',
                    success: function(msg) {
                        if (msg == '1') {
                            YMLib.Tools.showPrompt("ok-logo", "删除成功！", 3000);
                        } else {
                            YMLib.Tools.showPrompt("no-logo", "删除失败！", 3000);
                        }
                    },
                    error: function() {
                        $.messager.alert('错误！', '提交请求出错！');
                    }
                });
            }
        });
    });
}
// 获取采集项
function getCjx(classify) {
	$.ajax({
	    url:'/eyas/registry/queryTree.do',
	    data : "classify="+classify,
	    type : 'post',
	    cache : false,
	    dataType : 'json',
	    success : function(data) {
	    	 var html = '';
	    	 if(data!=null) {
	    		 $("#cjx-count").html("采集项("+data.length+")");
	    		 for(var i = 0; i < data.length; i++) {
	    			 if(i == 0) {
	    				 html += '<li><span class="cjx-select" id="' + data[i].id + '">' + data[i].name + '</span></li>'
	    			 } else {
	    				 html += '<li><span id="' + data[i].id + '">' + data[i].name + '</span></li>'
	    			 }
	    		 }
	    		 $('#name').html(data[0].name);
	    		 $('#alias').html(data[0].alias);
	    		 $('#featureType').html(data[0].featureType);
	    		 $('#source').html(data[0].source);
	    		 $('#frequency').html(data[0].frequency);
	    		 $('#updateTime').html(data[0].updateTime);
	    		 $('#coordinate').html(data[0].coordinate);
	    		 $('#classify').html(data[0].classify);
	    		 loadGrid(data[0].id);
	    		 cjxEvent();
	    	 }
	    	 console.log('专题点击后采集项：' + cjx);
	    	 $('.cjx-content').html(html);
	    },
	    error : function(obj) {
	       YMLib.Tools.showPrompt("i-logo", "系统错误，请联系管理员！", 2000);
	    }
	  });
}

// 采集项点击事件
function cjxEvent() {
    $('.cjx-content li span').click(function(e) {
        $(this).addClass('cjx-select');
        $(this).parent().siblings().find('span').removeClass('cjx-select');
        cjx = $(this).attr('id');
        loadMetaData(cjx);
        loadGrid(cjx);
        console.log('采集项点击：' + cjx);
        console.log('加载数据');
        console.log('生成表格');
    });
}

// 加载表格数据
function loadMetaData(id) {
	$.ajax({
	    url:'/eyas/registry/queryTable.do',
	    data : "id="+id,
	    type : 'post',
	    cache : false,
	    dataType : 'json',
	    success : function(data) {
	    	if(data!=null){
	    		$('#name').html(data.name);
		    	$('#alias').html(data.alias);
		    	$('#featureType').html(data.featureType);
		    	$('#source').html(data.source);
		    	$('#frequency').html(data.frequency);
		    	$('#updateTime').html(data.updateTime);
		    	$('#coordinate').html(data.coordinate);
		    	$('#classify').html(data.classify);
	    	}
	    },
	    error : function(obj) {
	       YMLib.Tools.showPrompt("i-logo", "系统错误，请联系管理员！", 2000);
	    }
	  });
}

// 专题点击事件
function ztEvent() {
    $('.zt-content li').click(function(e) {
        $(this).addClass('zt-select');
        $(this).siblings().removeClass('zt-select');
        var ztmc = $(this).attr('value');
        if(ztmc<8)
        	$('#classfiy').val("1");
        else 
        	$('#classfiy').val("2");
        console.log('专题点击：' + ztmc);
        getCjx(ztmc)
    });
}
/**
 * 1：新增
 * 2：修改
 */
var state=1;
function addCjx() {
    $('.cjx-add').click(function(e) {
        console.log('新增采集项');
        $('.tc-edit').hide();
        $('#tc_div').hide();
        $('#tc_form').show();
        $('.tc-cencel').show();
        $('.tc-save').show();
        $('.tc-pic button').show();
        $('.fh-ts').show();
        state=1;
        tableData = [];
        loadGrid('');
        $('#tc_form').form('clear');
        fhButton();
    });
}


function loadGrid(id) {
    console.log('加载表格');
    $('#table').datagrid({
        fit: true,
        fitColumns: true,
        loadMsg: '正在加载数据，请稍候...',
        data: tableData,
        url:'/eyas/registry/queryColumns.do',
        queryParams:{tableName:id},
        border: false,
        rownumbers: true,
        autoRowHeight: true,
        striped: true,
        pagination: true,
        pageSize: 15,
        pageList: [ 15, 30, 60, 120 ],
        columns:[[
            {field : 'ck', checkbox : true},
            {field:'name',title:'字段名称',width:100},
            {field:'code',title:'字段编码',width:100},
            {field:'type',title:'字段类型',width:100,align:'right'},
            {field:'isNull',title:'是否为空',width:100},
            {field:'defaults',title:'默认值',width:100},
            {field:'domain',title:'值域',width:100}
        ]]
    });
}

function delCjx() {
    $('.cjx-del').click(function(e) {
        console.log('删除采集项');
        var cjx = $('.cjx-content .cjx-select').attr('id');
        console.log('删除的id=' + cjx);
        $.ajax({
    	    url:'/eyas/registry/delTable.do',
    	    data : "id="+id,
    	    type : 'post',
    	    cache : false,
    	    dataType : 'json',
    	    success : function(data) {
    	    	getCjx('1');
    	    },
    	    error : function(obj) {
    	       YMLib.Tools.showPrompt("i-logo", "系统错误，请联系管理员！", 2000);
    	    }
    	  });
    });
}
