package com.hdsx.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 添加一些反射工具
 * @author xiongxt
 * @2015年3月28日 上午11:22:42
 */
public class ReflectUtil {
	/**
	 * 判断是不是自定义类型
	 * @param clazz
	 * @return
	 */
    public static boolean isCustomType(Class<?> clazz){
    	boolean result = true;
    	if(clazz == null) result = false;
    	if(clazz.isPrimitive()) result = false;
    	String name = clazz.getName();
    	if(name.startsWith("java")) result = false;
    	if(name.startsWith("javax")) result = false;
    	return result;
    }
    
	/**
	 * 获取属性值
	 * 
	 * @param name
	 * @param obj
	 * @return
	 */
	public static Object getValue(String name, Object obj) {
		Object result = null;
		try {
			if (name != null && obj != null && obj.getClass() != Object.class) {
				Class<?> cl = obj.getClass();
				Method method = cl.getMethod("get" + StringUtile.upperInitial(name));
				result = method.invoke(obj);
			}
		} catch (Exception e) {
			System.out.println("-----反射获取属性值异常------");
		}

		return result;
	}
    
    /**
     * 获取单一属性
     * @param name
     * @param clazz 父类
     * @return
     */
	public static Field getField(String name, Class<?> clazz) {
		Field result = null;
		if (name != null && clazz != null && clazz != Object.class) {
			try {
				result = clazz.getDeclaredField(name);
				result.setAccessible(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				result = getField(name, clazz.getSuperclass());
			}
		}

		return result;
	}
	
	/**
	 * 获取所有属性
	 * @param clazz
	 * @return
	 */
	public static Map<String,Field> getFields(Class<?> clazz){
		Map<String,Field> map=new HashMap<String, Field>();
		
		if(clazz != null && clazz != Object.class){
			Field[] fields= clazz.getDeclaredFields(); 
			for (Field field : fields) {
		    	field.setAccessible(true);
				map.put(field.getName(),field);
			}
			map.putAll(getFields(clazz.getSuperclass()));
		}
	    
	    return map;
		
	}
	/**
	 * 给泛型对象t的属性name赋值
	 * @param name
	 * @param t
	 * @param obj
	 * @return
	 */
	public static <T> T ConverObjec(String name, T t, Object obj) {
		T result = null;
		try {
			if (!StringUtile.isEmptyString(name) && t != null) {
				Class<?> cl = t.getClass();
				Method method = cl.getMethod("set" + StringUtile.upperInitial(name));
				method.invoke(t, obj);
			}
		} catch (Exception e) {
			System.out.println("-----赋值失败-----");
		}
		return result;
	}
}
