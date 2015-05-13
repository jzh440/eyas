/**
  * @FileName: constantJSON.js
  * @Description: 系统全局枚举解析文件，此文件用于解析全局枚举。
  * @author suc
  * @date 2014年5月22日 下午2:19:45
  **/
var Constant = function() {
  
};
/**
  * 将字符串转化成XMLDom对象或者读取物理的xml文件  
  * @param xmlStr xml字符串 
  * @param isFile 是否是物理文件( 默认是false) 
  * @author suc 20140522 
  **/
Constant.prototype.createXmlDOM = function(xmlStr,isFile) {  
  var xmlDom = null;
  
  isFile = isFile || false;
  
  if (xmlStr.match(/.+[.]{1}xml/)) {
    isFile = true;
  }

  var isIE = (navigator.userAgent.indexOf("MSIE") >= 0);

  if (isIE) {// IE only
    xmlDom = new ActiveXObject("Microsoft.XMLDOM");
    xmlDom.async = "false";
    if (isFile) {
      xmlDom.load(xmlStr);
    } else {
      xmlDom.loadXML(xmlStr);
    }
  } else {// FF ,chrome
    try {
      if (isFile) {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", xmlStr, false);
        xhr.send(null);
        xmlDom = xhr.responseXML;
      } else {
        xmlDom = (new DOMParser()).parseFromString(xmlStr, "text/xml");
      }
    } catch (e) {
      if (isFile) {
        xmlDom = document.implementation.createDocument("", "", null);
        xmlDom.async = false;
        xmlDom.loadXML(xmlStr);
      } else {
        xmlDom = (new DOMParser()).parseFromString(xmlStr, "text/xml");
      }
    }
  }
  return xmlDom;
};
/**
 * 读取constants.xml枚举配置文件，获取枚举配置的JSON对象格式的方法
 * 
 * @param xmlPath
 *          枚举配置文件的物理路径
 * @return 将xml格式的枚举配置转成成JSON格式的JS对象
 * @author suc 20140522
 */
Constant.prototype.getConstantJSON = function(xmlPath) {
  var ConstantJSON = {};

  var xmlDom = createXmlDOM(xmlPath, false);
  //JSLogger.log(xmlDom);
  var constantDOM = (xmlDom.getElementsByTagName("constatns")[0]);

  var selectorArr = constantDOM.getElementsByTagName("selector");
  for (var i = 0, len = selectorArr.length; i < len; i++) {
    var selector = selectorArr[i];
    var name = selector.getAttribute("name");
    ConstantJSON[name] = {};
    var optionsData = {};

    var optionArr = selector.getElementsByTagName("option");
    for (var j = 0, len2 = optionArr.length; j < len2; j++) {
      var option = optionArr[j];
      var key = option.getAttribute("key");
      optionsData[key] = {
        key : option.getAttribute("key"),
        value : option.getAttribute("value"),
        text : option.getAttribute("text")
      };
      //ConstantJSON[name][key] = optionsData;
    }
    var def = selector.getAttribute("defaultKey");
    optionsData["defaultData"] = {
      key : optionsData[def].key,
      value : optionsData[def].value,
      text : optionsData[def].text
    };
    ConstantJSON[name] = optionsData;
    //ConstantJSON[name]["defaultKey"] =
  }

  return ConstantJSON;
};