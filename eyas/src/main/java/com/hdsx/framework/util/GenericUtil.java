package com.hdsx.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.hdsx.framework.author.bean.Dept;

/**
 * 泛型获取工具
 * @author xiongxt
 * @2015年3月25日
 */
public class GenericUtil {
	  /** 
     * 通过反射, 获得定义Class时声明的父类的泛型参数的类型. 如无法找到, 返回Object.class. 
     *  
     *@param clazz 
     * @param index start from 0
     * @return
     */  
    public static Class<?> getSuperClassGenricType(final Class<?> clazz, final int index) {  
        if(clazz == null) return Object.class;
    	
        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。  
        Type genType = clazz.getGenericSuperclass();  
  
        if (!(genType instanceof ParameterizedType)) {  
           return Object.class;  
        }  
        //返回表示此类型实际类型参数的 Type 对象的数组。  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
  
        if (index >= params.length || index < 0) {  
                     return Object.class;  
        }  
        if (!(params[index] instanceof Class)) {  
              return Object.class;  
        }  
  
        return (Class<?>) params[index];  
    }  
    
    /** 
     * 通过反射, 获得定义Class时声明的接口的泛型参数的类型. 如无法找到, 返回Object.class. 
     *  
     *@param clazz 
     * @param index start from 0
     * @return
     */  
    public static Class<?> getInterfaceGenricType(final Class<?> clazz, final int face,final int gene) {  
        if(clazz == null) return null;
    	
        //返回表示此 Class 所表示的接口的 Type。  
        Type[] types = clazz.getGenericInterfaces(); 
        if(types == null || types.length <= face) return null;
        	Type genType = types[face];
	        if (!(genType instanceof ParameterizedType)) {  
	           return null;  
	        }  
	        //返回表示此类型实际类型参数的 Type 对象的数组。  
	        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
	  
	        if (gene >= params.length || gene < 0) {  
	                     return null;  
	        }  
	        if (!(params[gene] instanceof Class)) {  
	              return null;  
	        }  
  
        return (Class<?>) params[gene];  
    }
    /**
     * 获取属性泛型类型全名
     * @param name
     * @param clazz
     * @return
     */
    public static Map<String, String> getFieldGenericTypeName(Class<?> clazz){
    	
    	Map<String, String> result = new HashMap<String, String>();
    	
    	if(ReflectUtil.isCustomType(clazz)){//自定义类型
	    	Map<String, Field> fs = ReflectUtil.getFields(clazz); // 得到所有的fields 
	    	if(fs != null && !fs.isEmpty()){ 
				for(String field : fs.keySet()){
					Field f = fs.get(field);
					
					if(f == null) 
						continue;
					
					Class<?> fieldClazz = f.getType(); // 得到field的class及类型全路径  
					
					if(fieldClazz.isPrimitive())  continue;  
					
					if(fieldClazz.getName().startsWith("java.lang")) continue;
					
					Type fc = f.getGenericType(); // 得到其Generic的类型  
					
					if(fc == null) continue; 
					
					if(fc instanceof ParameterizedType){ // 带泛型参数的类型  
						ParameterizedType pt = (ParameterizedType) fc; 
						Type[] types = pt.getActualTypeArguments();
						
						for(int i = 0; i < types.length; i++){
							Type type = pt.getActualTypeArguments()[i]; //泛型里的类型对象。
							if(type == null) continue;
							Class<?> genericClazz = (Class<?>)type;
							result.put(f.getName(), genericClazz.getName()); 
						}
					}
				}
	    	}
    	}
    	return result;
    }
    
    /**
     * 获取属性泛型类型
     * @param name
     * @param clazz
     * @return
     */
public static Map<String, Map<Integer,Class<?>>> getFieldGenericType(Class<?> clazz){
    	
	 Map<String, Map<Integer,Class<?>>> result = new HashMap<String, Map<Integer,Class<?>>>();
    	
    	if(ReflectUtil.isCustomType(clazz)){//自定义类型
	    	Map<String, Field> fs = ReflectUtil.getFields(clazz); // 得到所有的fields 
	    	if(fs != null && !fs.isEmpty()){ 
				for(String field : fs.keySet()){
					Field f = fs.get(field);
					
					if(f == null) 
						continue;
					
					Class<?> fieldClazz = f.getType(); // 得到field的class及类型全路径  
					
					if(fieldClazz.isPrimitive())  continue;  
					
					if(fieldClazz.getName().startsWith("java.lang")) continue;
					
					Type fc = f.getGenericType(); // 得到其Generic的类型  
					
					if(fc == null) continue; 
					
					if(fc instanceof ParameterizedType){ // 带泛型参数的类型  
						ParameterizedType pt = (ParameterizedType) fc; 
						Type[] types = pt.getActualTypeArguments();
						
						Map<Integer,Class<?>> types_ = null;
						for(int i = 0; i < types.length; i++){
							types_ = new HashMap<Integer,Class<?>>();
							
							Type type = pt.getActualTypeArguments()[i]; //泛型里的类型对象。
							if(type == null) {
								types_.put(i, null);
								continue;
							}
							Class<?> genericClazz = (Class<?>)type;
							types_.put(i, genericClazz);
						}
						result.put(f.getName(), types_);
					}
				}
	    	}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	Map<String, Map<Integer, Class<?>>> fieldGenericType = getFieldGenericType(Dept.class);
    	for(String key :fieldGenericType.keySet()){
    		System.out.println(key+":" + fieldGenericType.get(key));
    	}
	}
}