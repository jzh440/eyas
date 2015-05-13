package com.hdsx.framework.dao;

import java.util.List;

/**
 * 核心dao接口
 * @author wusq
 *
 */
public interface Dao<T> {
	
	/**
	 * 保存
	 * @param o
	 * @return
	 */
	 int insert(T o);
	
	 /**
	  * 批量保存
	  * @param list
	  * @return
	  */
	int insertBath(List<T> list);
	/**
	 * 更新
	 * @param o
	 * @return
	 */
	 int update(T o);
	
	/**
	 * 删除
	 * @param parameter
	 * @return
	 */
	int delete(Object parameter);
	
	/**
	 * 禁用
	 * @param parameter
	 * @return
	 */
	int ban(Object parameter);
	
	/**
	 * 恢复
	 * @param parameter
	 * @return
	 */
	int resume(Object parameter);
	
	/**
	 * 查询单条记录
	 * @param parameter
	 * @return
	 */
	 T selectOne(Object parameter);
	/**
	 * 查询数量
	 * @return
	 */
	int count(Object parameter);
	
	/**
	 * 查询全部记录
	 * @return
	 */
	 List<T> selectList();
	
	/**
	 * 条件查询
	 * @param parameter
	 * @return
	 */
	 List<T> selectList(Object parameter);
}
