var hdsxUtil = {
		
	Description: '此工具类基于Jquery封装了一些js的常用方法',
	
	Version: 'v0.1',
	
	Author: 'suchen',
	
	Date: '2014年1月20日',
	
	projectName: 'jxgisyw',
	
	/**
	 * 常用工具
	 */
	Tools: {
		
		/**
		 * Ajax动态创建一个下拉列表，返回html。
		 * @param _url Ajax请求路径
		 * @param _value option中value值
		 * @param _text option中文本显示值
		 * @param _default select默认选中值
		 * @param _error 错误提示信息
		 * @returns {String} 返回下拉列表的html
		 */
		CreateAjaxSelect: function(_url, _value, _text, _default, _error) {
			var html = "";
			$.ajax({ 
				url: _url, 
				type: "POST", 
				dataType: "json", 
				async: false, 
				success: function(results) {
					for(var i=0;i<results.length;i++) {
						var value = eval("results[" + i + "]." + _value);
						var text = eval("results[" + i + "]." + _text);
						if(value == _default) {
							html += "<option value='" + value + "' selected>" + text + "</option>";
						} else {
							html += "<option value='" + value + "'>" + text + "</option>";
						}
					}
				},
				error: function(e) {
					alert(_error);
				}
			});
			return html;
		},
		
		/**
		 * 字符串拆分为数组，根据_sign来拆分_str字符串。
		 * @param _str 传入字符串
		 * @param _sign 拆分符号
		 * @returns {___anonymous1099_1100} 返回拆分出来的数组
		 */
		StringToArray: function(_str, _sign) {
			var result = {};
			if(!_str || _str.length == 0){
				return result;
			}
			if(!_sign || _sign.length == 0){
				return result;
			}
			result = _str.split(_sign);
			return result;
		},
		
		/**
		 * 将传入数组以 , 拼接成字符串。
		 * @param _array 传入数组
		 * @returns {String} 返回拼接好的字符串
		 */
		ArrayToString: function(_array) {
			var result = "";
			if(!_array || _array.length == 0){
				return result;
			}
			for(var i=0; i<_array.length; i++){
				result += _array[i].id + ",";
			}
			return result.substring(0, result.length - 1);
		},
		/**
		 * 将传入数组以 , 拼接成字符串。
		 * @param _array 传入数组
		 * @returns {String} 返回拼接好的字符串
		 */
		ArrayToCharString: function(_array) {
			var result = "";
			if(!_array || _array.length == 0){
				return result;
			}
			for(var i=0; i<_array.length; i++){
				result += ""+_array[i].id +""+ ",";
			}
			return result.substring(0, result.length - 1);
		},
		
		/**
		 * 创建随机名字的DIV
		 * @returns {String}返回是随机名字
		 */
		createRandomDiv : function(){
			var _t = $('<div></div>');
			var _id = "winDiv" + new Date().getHours() + new Date().getMinutes() + new Date().getSeconds() + new Date().getMilliseconds();
			_t.attr("id", _id);
			_t.appendTo('body');
			return _id;
		},
		
		/**
		 * 弹框显示文字
		 * @param _tips 文字信息
		 * @param _interval 弹出显示时长
		 */
		Show : function(_tips,_interval){
			var _t = null ;
			var _tipsid = hdsxUtil.Tools.createRandomDiv();
			var _width = _tips.length * 13;
			var _left = $(document).width() / 2 - _width / 2;
			var _top = $(document).height() / 2 -100;
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
				width :_width+20,
				height : 35,
				display : 'none',
				zIndex : 10000,
				color : 'red',
				border : '1px solid #99bbe8',
				padding : '10px 8px 0px 8px',
				background :'#E0ECFF',
				font :'12px 宋体',
				fontWeight:'bold'
			});
			$("#" + _tipsid).html(_tips);
			$("#" + _tipsid).fadeIn('slow');
			_t = setInterval(_closeTip, _interval);
		}
	},
		
	/**
	 * 功能性函数：日期类
	 */
	Date: {
		
		/**
		 * 获得当前日期 格式为 yyyy-mm-dd
		 * @param dval
		 * @returns {String}
		 */
		getNowDate : function(dval) {
			if(arguments.length != 0){
				var _yyyy = new Date().getFullYear();
		    var _MM = new Date().getMonth() + 1;
		    var _dd = new Date().getDate()+dval;
		    _MM = _MM < 10 ? '0' + _MM : _MM;
		    _dd = _dd < 10 ? '0' + _dd : _dd;
		    return _yyyy + '-' + _MM + '-' + _dd ;
			}else{
				var _yyyy = new Date().getFullYear();
		    var _MM = new Date().getMonth() + 1;
		    var _dd = new Date().getDate();
		    _MM = _MM < 10 ? '0' + _MM : _MM;
		    _dd = _dd < 10 ? '0' + _dd : _dd;
		    return _yyyy + '-' + _MM + '-' + _dd ;
			}
		},
		
		/**
		 * 求两个时间的天数差 日期格式为 YYYY-MM-dd
		 * @param DateOne
		 * @param DateTwo
		 */
		daysBetween: function(DateOne,DateTwo) {
			var OneMonth = DateOne.substring(5,DateOne.lastIndexOf ('-'));  
	    var OneDay = DateOne.substring(DateOne.length,DateOne.lastIndexOf ('-')+1);  
	    var OneYear = DateOne.substring(0,DateOne.indexOf ('-'));  
	  
	    var TwoMonth = DateTwo.substring(5,DateTwo.lastIndexOf ('-'));  
	    var TwoDay = DateTwo.substring(DateTwo.length,DateTwo.lastIndexOf ('-')+1);  
	    var TwoYear = DateTwo.substring(0,DateTwo.indexOf ('-'));  
	  
	    var cha=((Date.parse(OneMonth+'/'+OneDay+'/'+OneYear)- Date.parse(TwoMonth+'/'+TwoDay+'/'+TwoYear))/86400000);   
	    return Math.abs(cha);  
		}
		
	},
	
	/**
	 * EasyUI 数据表格 ajax 相关操作
	 * @param _url 请求路径
	 * @param _data 需要传的参数
	 * @param _success 成功提示信息
	 * @param _failure 失败提示信息
	 * @param _error 异常提示信息
	 * @param _close 关闭dialog窗口id
	 * @param _reload 重新载入datagrid
	 */
	Ajax: function(_url, _data, _success, _failure, _error, _close, _reload) {
		$.ajax({
		  type: "POST",
		  url: _url,
		  cache: false,
		  dataType: 'text',
		  data: _data,
		  success: function(result) {
		    if (result == "1") {
		      hdsxUtil.Tools.Show(_success, 3000);
		    } else {
		      hdsxUtil.Tools.Show(_failure, 3000);
		      return;
		    }
		    $('#' + _close).dialog('close');
		    $('#' + _reload).datagrid("reload");
		  },
		  error: function() {
		    hdsxUtil.Tools.Show(_error, 5000);
		  }
		});
	}, 
	
};