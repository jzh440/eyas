package com.hdsx.framework.util;

import java.io.Writer;

import javax.servlet.ServletResponse;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class JsonUtils {
	/** * logger. */
	private static Log logger = LogFactory.getLog(JsonUtils.class);
	
	protected JsonUtils(){}
	
	public static String bean2Json(Object bean){
		/**
		 *  定制输出格式
		 *  QuoteFieldNames———-输出key时是否使用双引号,默认为true
			WriteMapNullValue——–是否输出值为null的字段,默认为false
			WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null
			WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null
			WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null
			WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null
			*/
		SerializerFeature[] features = {SerializerFeature.QuoteFieldNames,SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.DisableCircularReferenceDetect};  
		logger.info("转换json成功！");
		return JSONObject.toJSONString(bean,features);
	}
	public static void write(Object bean,Writer writer) throws Exception{
		String jsonStr=bean2Json(bean);
		writer.write(jsonStr);
	}
	public static void json2Bean(String input,Class<?> cla){
		JSON.parseObject(input, cla);
	}
	public static void write(Object bean,ServletResponse response) throws Exception{
		String jsonStr=bean2Json(bean);
		response.getWriter().write(jsonStr);
	}
}
