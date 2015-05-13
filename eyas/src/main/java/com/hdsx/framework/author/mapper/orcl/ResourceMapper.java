package com.hdsx.framework.author.mapper.orcl;

import java.util.List;

import com.hdsx.framework.author.bean.Resource;
import com.hdsx.framework.dao.Dao;
import com.hdsx.framework.dao.Mapper;
/**
 * 资源持久层
 * @author xiongxt
 * @2015年3月15日
 */
@Mapper
public interface ResourceMapper extends Dao<Resource>{
	/**
	 * 查询用户资源
	 * @param distCode
	 * @return
	 */
	List<Resource> selectByUserId(String userId);
	/**
	 * 查询角色资源
	 * @param distCode
	 * @return
	 */
	List<Resource> selectByRoleId(String roleId);
	
	/**
	 * 查询下级资源
	 * @param distCode
	 * @return
	 */
	List<Resource> selectChildren(String id);
	
}
