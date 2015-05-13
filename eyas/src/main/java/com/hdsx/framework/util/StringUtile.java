package com.hdsx.framework.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 字符串工具类
 * @author kemi
 *
 */
public class StringUtile {
	/**
	 * 格式化首字母
	 * @return
	 */
	public static String lowerInitial(String word)
	{
		if(word==null)
		{
			return null;
		}
		String afertInitial=word.substring(0,1).toLowerCase();
		String afertStr=afertInitial+word.substring(1);
		return afertStr;
	}

	/**
	 * 格式化首字母
	 * @return
	 */
	public static String upperInitial(String word)
	{
		if(word==null)
		{
			return null;
		}
		String afertInitial=word.substring(0,1).toUpperCase();
		String afertStr=afertInitial+word.substring(1);
		return afertStr;
	}
	public static String setInitial(String word)
	{
		if(word==null)
		{
			return null;
		}
		String afertInitial=word.substring(0,1).toUpperCase();
		String afertStr="set"+afertInitial+word.substring(1);
		return afertStr;
	}
	public static String getInitial(String word)
	{
		if(word==null)
		{
			return null;
		}
		String afertInitial=word.substring(0,1).toUpperCase();
		String afertStr="get"+afertInitial+word.substring(1);
		return afertStr;
	}
	//判断对象是否为空
	public static boolean isEmpty(Object obj){
		if (obj == null) { return true;}
		else if (obj instanceof String && (obj.equals(""))) {return true;}
		else if (obj instanceof Number && ((Number) obj).doubleValue() == 0) {return true; }
		else if (obj instanceof Boolean && !((Boolean) obj)) {return true;}
		else if (obj instanceof Collection && ((Collection<?>) obj).isEmpty()){return true;}
		else if (obj instanceof Map && ((Map<?, ?>) obj).isEmpty()) {return true;}
		else if (obj instanceof Object[] && ((Object[]) obj).length == 0) {return true;}
		return false;
	}
	
	public static boolean isNotNull(String str) {
		// TODO Auto-generated method stub
		if(str==null||"".equals(str.trim())||"NULL".equals(str.trim().toUpperCase())){
			return false ;
		}
		return true;
	}
	/**
	 * 检查页面参数是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmptyString(String str) {
		if(str == null) return true;
		String str_ = str.replace(" ", "");
		if("".equals(str_)||"NULL".equalsIgnoreCase(str_)||"undefined".equalsIgnoreCase(str_)){
			return true ;
		}
		return false;
	}
	/**
	 * 前台参数转变成list
	 * @param ids
	 * @return
	 */
	public static List<String> toList(String ids){
		List<String> ids_ = new ArrayList<String>();
		if(!isEmptyString(ids)){
			String[] temp = ids.replace(" ", "").split(",");
			ids_ = Arrays.asList(temp);
		}
		return ids_;
	}
	
	public static String listToString(List<String> list){
		if(list == null || list.size() == 0) return "";
		StringBuffer sb = new StringBuffer();
		for(String li : list){
			sb.append(li + ",");
		}
		String result = sb.toString();
		if(result.length() > 0) result = result.substring(0, result.length() - 1);
		return result;
	}
}
