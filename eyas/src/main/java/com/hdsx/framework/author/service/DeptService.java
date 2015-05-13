package com.hdsx.framework.author.service;

import java.util.List;
import java.util.Map;

import com.hdsx.framework.author.bean.Dept;
/**
 * 单位业务层
 * @author xiongxt
 * @2015年3月17日
 */
public interface DeptService {
	/**
	 * 查询一条数据
	 * @param id
	 * @return
	 */
	Dept selectOne(Map<String, Object> param);
	
	/**
	 * 查询一条数据（没有赋值关系属性）
	 * @param id
	 * @return
	 */
	Dept selectById(String id);
	
	/**
	 * 添加一条数据
	 * @param dept
	 * @return
	 */
	int insert(Dept dept);
	
	/**
	 * 修改一条数据
	 * @param dept
	 * @return
	 */
	int update(Dept dept);
	
	/**
	 * 删除数据
	 * @param param
	 * @return
	 */
	int delete(Map<String, Object> param);
	
	/**
	 * 分页查询
	 * @param param
	 * @return
	 */
	List<Dept> selectList(Map<String, Object> param);
	
	/**
	 * 统计条数
	 * @param param
	 * @return
	 */
	int count(Map<String, Object> param);
	
	/**
	 * 查询单位，并查询子单位
	 * @param id
	 * @return
	 */
	List<Dept> treeForAll(String id);
	
	/**
	 * 查询单位的子单位
	 * @param id
	 * @return
	 */
	List<Dept> treeForChildren(String id);
	
}
