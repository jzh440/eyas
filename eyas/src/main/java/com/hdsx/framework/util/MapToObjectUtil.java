package com.hdsx.framework.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * map给对应的对象赋值
 * @author xiongxt
 * @2015年3月24日 
 */
public class MapToObjectUtil {
	
	/**
	 * map转化成obj map中values不含复杂类型（基本类型，string，date）
	 * @param maps
	 * @param clazz
	 * @return
	 */
	public static List<Object> listSimpleMapToObject(List<Map<String,Object>> maps, Class<?> clazz){
		List<Object> result = new ArrayList<Object>();
		if(maps != null && !maps.isEmpty() && clazz != null)
			for(Map<String, Object> map : maps){
				Object t = mapToObject(map,clazz);
				if(t != null)
					result.add(t);
			}
		return result;
	}
	
	/**
	 * map转化成object
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static Object mapToObject(Map<String,Object> map, Class<?> clazz){
		Object result = null;
		if(map != null && !map.isEmpty() && clazz != null){
			try {
				result = clazz.newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Map<String, Field> fields = ReflectUtil.getFields(clazz);
			if(fields != null && !fields.isEmpty()){
				outter:for(String prop : fields.keySet()){
					for(String upper : map.keySet()){
						if(upper.equalsIgnoreCase(prop)){
							Field field = fields.get(prop);
							Object value = map.get(upper);
							Class<?> type = field.getType();
							if(field != null){
								Object castedValue = castBigDecimal(value, type);
								try {
									field.set(result, castedValue);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								continue outter;
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	public static Object castBigDecimal(Object value,Class<?> type){
		Object result = value;
		if(value != null && value.getClass() == BigDecimal.class){
			if(type == int.class || type == Integer.class){
				result = ((BigDecimal)value).intValue();
			}  else if(type == long.class || type == Long.class){
				result = ((BigDecimal)value).longValue();
			}  else if(type == float.class || type == Float.class){
				result = ((BigDecimal)value).floatValue();
			}  else if(type == double.class || type == Double.class){
				result = ((BigDecimal)value).doubleValue();
			}  else if(type == short.class || type == Short.class){
				result = ((BigDecimal)value).shortValue();
			}  else if(type == byte.class || type == Byte.class){
				result = ((BigDecimal)value).byteValue();
			}
		}
		return result;
	}
}
