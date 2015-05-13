package com.hdsx.framework.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5
 * @author wusq
 *
 */
public class MD5Util {
	/**
	 * MD5加密
	 * @param str
	 * @return
	 */
	public static String encrypt(String str){
		
		String result = "传入空值了，哈哈！";
		if(str == null || str.length() == 0) return result;
		
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(str.getBytes());  
			result = toHex(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** 
     * 将16位byte[] 转换为32位String 
     *  
     * @param buffer 
     * @return 
     */  
    private static String toHex(byte[] buffer) {  
        StringBuffer sb = new StringBuffer(buffer.length * 2);  
        for (int i = 0; i < buffer.length; i++) {  
            sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));  
            sb.append(Character.forDigit(buffer[i] & 15, 16));  
        }  
        return sb.toString();  
    } 
}
