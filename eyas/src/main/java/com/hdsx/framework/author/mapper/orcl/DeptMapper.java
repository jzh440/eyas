package com.hdsx.framework.author.mapper.orcl;

import java.util.List;

import com.hdsx.framework.author.bean.Dept;
import com.hdsx.framework.dao.Dao;
import com.hdsx.framework.dao.Mapper;
/**
 * 单位持久层
 * @author xiongxt
 * @2015年3月15日
 */
@Mapper
public interface DeptMapper extends Dao<Dept>{
	/**
	 * 查询子单位
	 * @param id
	 * @return
	 */
	List<Dept> selectChildren(String id);
	/**
	 * 查询区划代码下单位
	 * @param distCode
	 * @return
	 */
	List<Dept> selectByDistCode(String distCode);
	
	/**
	 * 查询单条单位（没有赋值关系属性）
	 * @param parameter
	 * @return
	 */
	 Dept selectById(String id);
	 
	/**
	 * 查询顶级单位
	 * @return
	 */
	List<Dept> selectTop();
}
