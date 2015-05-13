package com.hdsx.framework.common;

import java.util.List;

/**
 * 执行器服务层
 * @author xiongxt
 * @2015年3月24日
 */
public interface ExecutorService {
	/**
	 * 查询
	 * @param sql
	 * @return
	 */
	List<Object> select(String sql,Class<?> cla);
	
	/**
	 * 添加
	 * @param sql
	 * @return
	 */
	int insert(String sql);
}
