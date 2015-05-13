//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}

function  Request()
{
	this.QueryString=function(item) {
		var svalue = location.search.match(new RegExp("[\?\&]" + item
				+ "=([^\&]*)(\&?)", "i"));
		return svalue ? svalue[1] : svalue;
	};
    this.QueryLocation=function(locurl)
    {
       var value = locurl.match(new RegExp("[http://]{0,1}([0-9]+.[0-9]+.[0-9]+.[0-9]+:[0-9]{0,4})(\/)","i"));
       return value ? value[1] : value;
    };
}

/**
 * 日期格式化函数
 * @param fmt
 * @returns
 */
Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};
Date.prototype.CreateDateTime = function(s)
{
    var strInfo = s.match(/d+/g);
    var d = new Date(), 
    r = [d.getFullYear(), d.getMonth() + 1, d.getDate(), 0, 0, 0];
    for (var i = 0; i < 6 && i < strInfo.length; i++)
        r[i] = strInfo[i].length > 0 ? strInfo[i] : r[i];
    return new Date(r[0],r[1]-1,r[2],r[3],r[4],r[5]);
};