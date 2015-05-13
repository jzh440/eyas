package com.hdsx.framework.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hdsx.framework.dao.Mapper;
/**
 * 用户执行拼接sql语句
 * @author xiongxt
 * @2015年3月24日
 */
@Mapper
public interface ExecutorMapper {
	/**
	 * 查询
	 * @param sql
	 * @return
	 */
	List<Map<String,Object>> select(@Param("sql")String sql);
	/**
	 * 插入数据
	 * @return
	 */
	int insert(@Param("sql")String sql);
}
