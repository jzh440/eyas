package com.hdsx.framework.util;

import java.util.UUID;

public class UUIDUtil {
	/**
	 * tanni
	 * @return 随机生成一个id 作为申请单id
	 */
	public static String getSqdID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static String getID(){
		return getSqdID();
	}

}
