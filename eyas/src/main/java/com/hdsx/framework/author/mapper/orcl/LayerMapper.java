package com.hdsx.framework.author.mapper.orcl;

import java.util.List;
import com.hdsx.framework.author.bean.Layer;
import com.hdsx.framework.dao.Dao;
import com.hdsx.framework.dao.Mapper;
/**
 * 图层持久层
 * @author xiongxt
 * @2015年3月15日
 */
@Mapper
public interface LayerMapper extends Dao<Layer> {
	/**
	 * 单位图层
	 * @param deptId
	 * @return
	 */
	List<Layer> selectByDeptId(String deptId);
	/**
	 * 用户图层
	 * @param userId
	 * @return
	 */
	List<Layer> selectByUserId(String userId);
	/**
	 * 查询子图层
	 * @param id
	 * @return
	 */
	List<Layer> selectChildren(String id);
}
