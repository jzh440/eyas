package com.hdsx.framework.registry.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.framework.registry.bean.RegistryColumn;
import com.hdsx.framework.registry.bean.RegistryTable;
import com.hdsx.framework.registry.mapper.TableMapper;
@Service
@Transactional
public class TableServiceImpl implements TableService {

	@Resource
	private TableMapper tableMapper;
	
	@Override
	public boolean addTable(RegistryTable table) {
		String id=UUID.randomUUID().toString();
		table.setId(id);
		for(RegistryColumn column:table.getColumns())
		{
			column.setTableName(id);
		}
		boolean result=tableMapper.addTable(table)>0;
		tableMapper.addColumns(table.getColumns());
		return result;
	}

	@Override
	public List<RegistryTable> queryTables(int classify) {
		return tableMapper.queryTables(classify);
	}

	@Override
	public int count(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RegistryTable queryTable(String id) {
		// TODO Auto-generated method stub
		return tableMapper.queryTable(id);
	}

	@Override
	public List<RegistryColumn> queryColumns(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return tableMapper.queryColumns(map);
	}

	@Override
	public boolean delTable(String id) {
		// TODO Auto-generated method stub
		return tableMapper.delTables(id)>0;
	}

	@Override
	public boolean delColumns(String ids) {
		// TODO Auto-generated method stub
		return tableMapper.delColumns(ids)>0;
	}

}
