package com.hdsx.framework.author.mapper.orcl;

import java.util.List;

import com.hdsx.framework.author.bean.Role;
import com.hdsx.framework.dao.Dao;
import com.hdsx.framework.dao.Mapper;
/**
 * 角色持久层
 * @author xiongxt
 * @2015年3月15日
 */
@Mapper
public interface RoleMapper extends Dao<Role>{
	/**
	 * 查询用户角色
	 * @param distCode
	 * @return
	 */
	List<Role> selectByUserId(String userId);
	
}
