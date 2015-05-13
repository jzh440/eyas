package com.hdsx.framework.module.demo.mapper;

import java.util.List;

import com.hdsx.framework.dao.Mapper;
import com.hdsx.framework.module.demo.bean.TUser;

@Mapper
public interface TUserMapper {
	
	List<TUser> selectList();
	
}
