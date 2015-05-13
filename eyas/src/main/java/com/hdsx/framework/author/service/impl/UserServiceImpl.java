package com.hdsx.framework.author.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.framework.author.bean.LoginLog;
import com.hdsx.framework.author.bean.User;
import com.hdsx.framework.author.mapper.orcl.UserMapper;
import com.hdsx.framework.author.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper mapper;
	
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory factory;
	
	@Override
	public User selectOne(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return mapper.selectOne(param);
	}
	
	@Override
	public User selectById(String id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}
	
	@Override
	public int insert(User user){
		// TODO Auto-generated method stub
		return mapper.insert(user);
	}
	
	@Override
	public int update(User user){
		// TODO Auto-generated method stub
		return mapper.update(user);
	}
	
	@Override
	public int delete(Map<String, Object> param){
		// TODO Auto-generated method stub
		return mapper.delete(param);
	}

	@Override
	public List<User> selectList(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return mapper.selectList(param);
	}

	@Override
	public int count(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return mapper.count(param);
	}

	@Override
	public int error(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return mapper.error(param);
	}

	@Override
	public int insertLog(LoginLog log) {
		// TODO Auto-generated method stub
		return mapper.insertLog(log);
	}

	@Override
	public Date lastUnlock(String userName) {
		// TODO Auto-generated method stub
		return mapper.lastUnlock(userName);
	}

}
