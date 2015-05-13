package com.hdsx.framework.module.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.framework.module.demo.bean.TUser;
import com.hdsx.framework.module.demo.mapper.TUserMapper;
@Service
@Transactional
public class TUserServiceImpl implements TUserService {

	@Resource
	private TUserMapper mapper;
	@Override
	public List<TUser> selectList() {
		// TODO Auto-generated method stub
		return mapper.selectList();
	}

}
