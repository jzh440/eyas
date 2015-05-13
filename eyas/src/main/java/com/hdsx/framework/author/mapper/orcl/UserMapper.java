package com.hdsx.framework.author.mapper.orcl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hdsx.framework.author.bean.LoginLog;
import com.hdsx.framework.author.bean.User;
import com.hdsx.framework.dao.Dao;
import com.hdsx.framework.dao.Mapper;
/**
 * 用户持久层
 * @author xiongxt
 * @2015年3月15日
 */
@Mapper
public interface UserMapper extends Dao<User> {
	/**
	 * 用户成员
	 * @param deptId
	 * @return
	 */
	List<User> selectByUserId(String deptId);
	
	/**
	 * 查询单条用户（没有赋值关系属性）
	 * @param parameter
	 * @return
	 */
	 User selectById(String id);
	 /**
	  * 登录错误次数
	  * @param param
	  * @return
	  */
	 int error(Map<String, Object> param);
	 /**
	  * 添加登录日记
	  * @param log
	  * @return
	  */
	 int insertLog(LoginLog log);
	 /**
	 * 上次解锁时间
	 * @param userName
	 * @return
	 */
	 Date lastUnlock(String userName);
}
