package com.hdsx.framework.author.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hdsx.framework.author.bean.LoginLog;
import com.hdsx.framework.author.bean.User;
/**
 * user业务层
 * @author xiongxt
 * @2015年3月28日 下午9:46:18
 */
public interface UserService {

	/**
	 * 查询一条数据
	 * @param id
	 * @return
	 */
	User selectOne(Map<String, Object> param);
	
	/**
	 * 查询一条数据（没有赋值关系属性）
	 * @param id
	 * @return
	 */
	User selectById(String id);
	
	/**
	 * 添加一条数据
	 * @param user
	 * @return
	 */
	int insert(User user);
	
	/**
	 * 修改一条数据
	 * @param user
	 * @return
	 */
	int update(User user);
	
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
	List<User> selectList(Map<String, Object> param);
	
	/**
	 * 统计条数
	 * @param param
	 * @return
	 */
	int count(Map<String, Object> param);
	
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
