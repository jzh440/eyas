/**
 * 2014-5-15 14:27
 */
var MyUtil = {
		/**
		 * 常用正则表达式
		 */
		tel_regex_1 : /^0\d{2,3}-?\d{7,8}$/,
		tel_regex_2 : /^0\d{2,3}-?\d{7,8}(-?(\d{3}))?$/,
		space_global:/\s+/g,
		mobile_regex :/^1[3|5|8]\d{9}$/,
		code_regex:/^[0-9]{6}$/,
		fax_regex:/^0\d{2,3}-?\d{7,8}-?(\d{3})$/,
		simple_chinese_regex:/^([\u4e00-\u9fa5])+$/,
		email_regex:/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/,
		
		/**是否赋值*/
		canBeUsed:function(value){
			return "undefined"!=typeof value && value!=null && value!='null';
		},
		/**
		 * Cookie增删改
		 */
		Cookie : {
			//是否已经存在该cookie
			/**
			 * 判断是否有改cookie
			 * @param cookieName cookie名
			 */
			contain:function(cookieName){
				var cookies = document.cookie.split(";");
				for(var i=0;i < cookies.length;i++) {    
					 var cookie = cookies[i];                      //取得字符串    
					 while (cookie.charAt(0)==' ') {          //判断一下字符串有没有前导空格    
						 cookie = cookie.substring(1,cookie.length);      //有的话，从第二位开始取    
					 } 
					 var values = cookie.split("=");
					 if (unescape(values[0])==cookieName) {       //如果含有我们要的name    
						 return true;
					 }    
				 }
				return false;
			},
			
			//添加cookie
			/**
			 * 设置cookie
			 * @param cookieName cookie名
			 * @param value cookie值
			 * @param minutes 有效时间（单位分）
			 */
			addCookie:function(cookieName, value, minutes) {
				//初始化参数
				value = MyUtil.Str.skip(value);
				cookieName = MyUtil.Str.skip(cookieName);
				value = MyUtil.Str.skip(value);
				//值为空时，不保存cookie
				if(value == '' || cookieName==''){
					return;
				}
				//密匙
				var seed = MyUtil.Cookie.seed();
				value = MyUtil.Cookie.encrypt(value, seed)+":"+seed;
				
				minutes = minutes || 0;   //seconds有值就直接赋值，没有为0，这个根php不一样。
				//有效期
				 var expires = "";    
				 if (minutes != 0 ) {      //设置cookie生存时间    
				 var date = new Date();  
				 date.setTime(date.getTime()+(minutes*60*1000)); 
				 expires = "; expires="+date.toGMTString();    
				 } 
				 //没有事添加，有时修改
				 document.cookie = escape(cookieName)+"="+escape(value)+expires+"; path=/";
			},
			
			//获取cookie
			/**
			 * 获取cookie值
			 * @param cookieName cookie名
			 */
			getCookie:function(cookieName) { 
				cookieName = MyUtil.Str.skip(cookieName);
				if(cookieName==''){
					return '';
				}
				var cookies = document.cookie.split(";");
				for(var i=0;i < cookies.length;i++) {    
					 var cookie = cookies[i];                      //取得字符串    
					 while (cookie.charAt(0)==' ') {          //判断一下字符串有没有前导空格    
						 cookie = cookie.substring(1,cookie.length);      //有的话，从第二位开始取    
					 } 
					 var values = cookie.split("=");
					 if (unescape(values[0])==cookieName) {       //如果含有我们要的name    
						 return MyUtil.Cookie.decrypt(unescape(values[1]).split(":")[0],unescape(values[1]).split(":")[1]);
						 break;
					 }    
				 }
				return '';
			},
			
			//获取第一个cookie,并初始化输入框
			initUseFirstCookie:function(){
				if(document.cookie ==''){
					return ['',''];
				}
				var cookies = document.cookie.split(";");
				if(cookies.length > 0){
					 var cookie = cookies[0];                      //取得字符串    
					 while (cookie.charAt(0)==' ') {          //判断一下字符串有没有前导空格    
						 cookie = cookie.substring(1,cookie.length);      //有的话，从第二位开始取    
					 }
					 var values = cookie.split("=");
					 
					 values[0]=unescape(values[0]);
					 values[1]=MyUtil.Cookie.decrypt(unescape(values[1]).split(":")[0],unescape(values[1]).split(":")[1]);
					 
					 return values;
				}
				return ['',''];
			},
			
			//删除cookie
			/**
			 * 删除cookie
			 * @param cookieName cookie名
			 */
			deleteCookie:function(cookieName) {
				cookieName = MyUtil.Str.skip(cookieName);
				MyUtil.Cookie.addCookie(cookieName,'delete',-10);
			},
			/**
			 * 密匙
			 */
			seed:function(){
				return Math.floor(Math.random() * 0x7f) + 1;
			},
			//加密
			/**
			 * @param password 密码
			 * @param seed 密匙
			 */
			encrypt:function(password,seed) {      
			     var fnl = "", code = 0;
			     for(var i = 0; i < password.length; i++){
			           code = password.charCodeAt(i) & 0x7f ^ (seed << 7 - i % 8 | seed >> i % 8 | 0x80) & 0xff;
			           fnl += code.toString(16);
			     }
			     return fnl;
			},
			//解密
			/**
			 * @param password 密码
			 * @param seed 密匙
			 */
			decrypt:function(password,seed)	{
			     var fnl = "", code = 0;
			     for(var i = 0; i < password.length >> 1; i++){
			           code = new Number("0x" + password.substr(i * 2, 2));
			           fnl += String.fromCharCode((code ^ (seed << 7 - i % 8 | seed >> i % 8 | 0x80)) & 0x7f);
			     }
			     return fnl;
			}
		},
		//自连接parent-children
	DTO : {
		//集合中的所有叶子 须知道叶子对应对象中的属性名cjx
		//collects 集合对象ArrayList,Array
		getLeaves : function(collects){
			
			function getChildren(objs){
				var obj_='';
				for(var i=0;i<objs.length;i++){
					if(objs[i].children.length != 0){
						obj_ += getChildren(objs[i].children);
					}else{
						obj_+=','+objs[i].cjx; //cjx为要获取的属性
					}
				}
				return obj_;
			}
			
			var obj = '';
			obj = getChildren(collects);
			if(obj != '')
				obj = obj.substring(1, obj.length);
			return obj;
		}

	},
	/*String*/
	Str:{
		/**是否为空*/
		isEmpty:function(value){
			if("undefined"==typeof value || value==null || value=='null'){
				value = '';
			}else{
				value = value.replace(/\s+/g,'');
			}
			if(value == ''){
				return true;
			}
			return false;
		},
		
		/**去空*/
		skip:function(value){
			return MyUtil.Str.isEmpty(value)?'':value.replace(/\s+/g,'');
		},
		
		/**去左右空格*/
		skipSide:function(value){
			return $.trim(value);
		},
		
		/**字符串变数组,并且去两边空格*/
		strToArr:function(str){
			if("undefined"==typeof str || str==null || str=='null'){
				return [];
			}
			
			var values = str.split(",");
			for(var i=0; i<values.length; i++){
				values[i] = MyUtil.Str.skipSide(values[i]);
			}
			return values;
		}
	},
	
	/**数组操作*/
	Arr : {
		/**数组变字符串*/
		arrToStr:function(arr){
			if("undefined"==typeof arr || arr==null || arr=='null'){
				return '';
			}
			
			var value ='';
			for(var i=0; i<arr.length; i++){
				if(i==0)
					value += MyUtil.Str.skipSide(arr[i]);
				else
					value += "," + MyUtil.Str.skipSide(arr[i]);
			}
			return value;
		}
	},
	/**dom对象创建*/
	Dom:{
		/**
		 * 创建下拉框
		 * @param id input 参数输入框
		 * @param name 参数接收名
		 * @param parentId 容纳下拉框的div id
		 * @param options 选项
		 * @param values 选项对应值
		 * @param height 高度
		 * 
		 */
		select:function(id, name, parentId, options, values, height,initValue){ 
			var div=document.getElementById(parentId);
			var y = div.getBoundingClientRect().top;
			//下拉控件足够 30px留余
			if((y + height*(options.length+1) + 30) < document.documentElement.clientHeight)
				MyUtil.Dom.select_(id, name, parentId, options, values, height,'bottom',initValue);
			//上拉空间足够
			else if((y - height*(options.length+1)-30 ) > 0)
				MyUtil.Dom.select_(id, name, parentId, options, values, height,'top',initValue);
			//都不够
			else
				MyUtil.Dom.select_(id, name, parentId, options, values, height,'bottom',initValue);
		},
		/**
		 * 创建下拉框
		 * @param id input 参数输入框
		 * @param name 参数接收名
		 * @param parentId 容纳下拉框的div id
		 * @param options 选项
		 * @param values 选项对应值
		 * @param height 高度
		 * @param param 下拉还是上拉
		 */
		select_:function(id, name, parentId, options, values, height,param,initValue){
			var containObj = document.getElementById(parentId);
			
			var paramObj = document.createElement("input");
			$(paramObj).attr('type','text');
			$(paramObj).attr('id',id);
			$(paramObj).attr("name",name);
			$(paramObj).css('display','none');
			$(paramObj).attr('value',initValue);
			containObj.appendChild(paramObj);
			
			var selectObj = document.createElement("div");
			$(selectObj).attr('id','select');
			$(selectObj).attr('class','select');
			var initText = options[0];
			for(var j=0;j<values.length;j++){
				if(initValue == values[j]){
					initText = options[j];
					break;
				}
			}
			$(selectObj).text(initText);
			$(selectObj).mousedown(function(){
				if($('.select ~ div').css('display')=='none'){
					$('.contain div:not(.select)').each(function(){
						$(this).css('display',"block");
						if($(this).attr("value")==$('#'+id).val()){
							$(this).css('background-color',"#3399FF");
						}
					});
				}else{
					$('.contain div:not(.select)').each(function(){
						$(this).css('display',"none");
					});
				}
			});
			containObj.appendChild(selectObj);
			
			for(var i=0;i<options.length;i++){
				var optionObj = document.createElement("div");
				$(optionObj).attr('id','select'+(i+1));
				$(optionObj).attr('class','select'+(i+1));
				if(param == 'top'){
					$(optionObj).css('margin-top', -1*height*(i+1) + 'px');
					if(i==options.length-1){
						$(optionObj).css('border-top','1px solid black');
					}
				}else{
					$(optionObj).css('margin-top', height*(i+1) + 'px');
					if(i==options.length-1){
						$(optionObj).css('border-bottom','1px solid black');
					}
				}
				$(optionObj).css('display','none');
				$(optionObj).attr('value', values[i]);
				if(initValue == values[i]){
					$(optionObj).css('background-color',"#3399FF");
				}
				$(optionObj).css('width', 284+'px');
				$(optionObj).css('border-left','1px solid black');
				$(optionObj).css('border-right','1px solid black');
				$(optionObj).text(options[i]);
				containObj.appendChild(optionObj);
			}
			
			$('.contain div:not(.select)').click(function(){
				$('#select').text($(this).text());
				$(this).parent().find("input:first").val($(this).attr('value'));
				$('.contain div:not(.select)').each(function(){
					$(this).css('display',"none");
					$(this).css('background-color',"white");
				});
			});
			$('.contain div:not(.select)').mouseout(function(){
				$(this).css('background-color',"white");
			});
			$('.contain div:not(.select)').mouseover(function(){
				$('.contain div:not(.select)').each(function(index){
					$(this).css('background-color',"white");
				});
				$(this).css('background-color',"#3399FF");
			});
		},
		/**
		 * 删除子标签
		 * @param tagId 要删除子标签的标识id
		 */
		removeChildTag:function(tagId){
			var tagObj = document.getElementById(tagId);
		    while(tagObj.hasChildNodes()){//当div下还存在子节点时 循环继续
		    	tagObj.removeChild(tagObj.firstChild);
		    	//jquery
//		    	$(tagObj.firstChild).remove();
		    }
		}
	},
	/**obj操作*/
	Obj:{
		/**空对象*/
		isEmpty:function(obj){
		}
	},
	/**时间*/
	Time:{
		/**当前时间*/
		currentTime : function(union_char1, union_char2, union_char3){
			//初始化
			union_char1 = MyUtil.Str.isEmpty(union_char1)?"-":union_char1;
			union_char2 = MyUtil.Str.isEmpty(union_char2)?":":union_char2;
			union_char3 = MyUtil.Str.isEmpty(union_char3)?" ":union_char3;
			
			var _yyyy = new Date().getFullYear();
		    var _MM = new Date().getMonth() + 1;
		    var _dd = new Date().getDate();
		    var _hh = new Date().getHours();
		    var _mm = new Date().getMinutes();
		    var _ss = new Date().getSeconds();
		    var _sss = new Date().getMilliseconds();
		    _MM = _MM < 10 ? '0' + _MM : _MM;
		    _dd = _dd < 10 ? '0' + _dd : _dd;
		    _hh = _hh < 10 ? '0' + _hh : _hh;
		    _mm = _mm < 10 ? '0' + _mm : _mm;
		    _ss = _ss < 10 ? '0' + _ss : _ss;
		    return _yyyy + union_char1 +  _MM   + union_char1 +  _dd
		    	+ union_char3 + _hh + union_char2 +  _mm  + union_char2 
		    	+ _ss + union_char3 + _sss;
		},
		
		/**时间ID*/
		timeForId:function(){
			var _yyyy = new Date().getFullYear();
		    var _MM = new Date().getMonth() + 1;
		    var _dd = new Date().getDate();
		    var _hh = new Date().getHours();
		    var _mm = new Date().getMinutes();
		    var _ss = new Date().getSeconds();
		    var _sss = new Date().getMilliseconds();
		    _MM = _MM < 10 ? '0' + _MM : _MM;
		    _dd = _dd < 10 ? '0' + _dd : _dd;
		    _hh = _hh < 10 ? '0' + _hh : _hh;
		    _mm = _mm < 10 ? '0' + _mm : _mm;
		    _ss = _ss < 10 ? '0' + _ss : _ss;
		    return _yyyy +  _MM  + _dd + _hh + _mm  +  _ss + _sss;
		}
	},
	
	/**WINDOW各式窗口*/
	Win:{
		/**退出*/
		
	}
	
	
};