package com.hdsx.framework.util;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 接受参数字符集转化
 * @author xiongxt
 * @2015年3月22日
 */
public class Iso2UtfUtil {
	/**
	 * 字符串转化
	 * @param param
	 */
	public static String converToUTF(String param){
		String result = param;
		try {
			if(!StringUtile.isEmptyString(param))
				result = new String(param.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 对象中的字符串类型字段转化
	 * @param param
	 */
	public static void converToUTF(Object t) {
		try {
			if (t == null) return;
			Map<String, Field> fields = ReflectUtil.getFields(t.getClass());
			for (String key : fields.keySet()) {
				Field field = fields.get(key);
				Class<?> type = field.getType();
				if (type == String.class) {
					Object o = field.get(t);
					if (o != null) {
						String value = (String) o;
						if (!StringUtile.isEmptyString(value)) {
							String result = converToUTF(value);
							field.set(t, result);
						} else {// 防止"undefined","null"之类的
							field.set(t, null);
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
