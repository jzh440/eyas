package com.hdsx.framework.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.framework.util.MapToObjectUtil;

/**
 * 执行器服务层
 * @author xiongxt
 * @2015年3月24日
 * @param <T>
 */
@Transactional
@Service
public class ExecutorServiceImpl implements ExecutorService {

	@Resource
	private ExecutorMapper mapper;
	
	@Override
	public List<Object> select(String sql,Class<?> cla) {
		// TODO Auto-generated method stub
		List<Object> result = new ArrayList<Object>();
		List<Map<String, Object>> select = mapper.select(sql);
		if(select != null && !select.isEmpty() && cla != null){
			result = MapToObjectUtil.listSimpleMapToObject(select, cla);
		}
		return result;
	}

	@Override
	public int insert(String sql) {
		// TODO Auto-generated method stub
		return mapper.insert(sql);
	}
}
