package com.hdsx.framework.author.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.framework.author.bean.Dept;
import com.hdsx.framework.author.mapper.orcl.DeptMapper;
import com.hdsx.framework.author.service.DeptService;
import com.hdsx.framework.util.StringUtile;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

	@Resource
	private DeptMapper mapper;
	@Override
	public Dept selectOne(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return mapper.selectOne(param);
	}
	
	@Override
	public int insert(Dept dept){
		// TODO Auto-generated method stub
		return mapper.insert(dept);
	}
	
	@Override
	public int update(Dept dept){
		// TODO Auto-generated method stub
		return mapper.update(dept);
	}
	
	@Override
	public int delete(Map<String, Object> param){
		// TODO Auto-generated method stub
		return mapper.delete(param);
	}

	@Override
	public List<Dept> selectList(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return mapper.selectList(param);
	}

	@Override
	public int count(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return mapper.count(param);
	}

	@Override
	public Dept selectById(String id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public List<Dept> treeForAll(String id) {
		// TODO Auto-generated method stub
		List<Dept> tree = new ArrayList<Dept>();
		if(StringUtile.isEmptyString(id)){
			tree = mapper.selectTop();
			if(tree != null && tree.size() > 0){
				for(Dept dept : tree){
					setChildren(dept);
				}
			}
		} else {
			Dept one = mapper.selectById(id);
			if(one != null){
				tree.add(one);
				setChildren(one);
			}
		}
		return tree;
	}

	@Override
	public List<Dept> treeForChildren(String id) {
		// TODO Auto-generated method stub
		List<Dept> tree = new ArrayList<Dept>();
		if(StringUtile.isEmptyString(id)){
			tree = mapper.selectTop();
			if(tree != null && tree.size() > 0){
				for(Dept dept : tree){
					setChildren(dept);
				}
			}
		} else {
			Dept one = mapper.selectById(id);
			if(one != null && one.getChildren() != null && one.getChildren().size() > 0){
				tree = one.getChildren();
				for(Dept dept : one.getChildren()){
					setChildren(dept);
				}
			}
		}
		return tree;
	}
	
	/**
	 * 子单位赋值
	 * @param dept
	 */
	private void setChildren(Dept dept){
		if(dept != null && !StringUtile.isEmptyString(dept.getId())){
			List<Dept> children = mapper.selectChildren(dept.getId());
			dept.setChildren(children);
			if(children != null && children.size() > 0){
				for(Dept child : children){
					setChildren(child);
				}
			}
		}
	}
}
