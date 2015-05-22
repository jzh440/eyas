package com.hdsx.framework.registry.mapper;

import java.util.List;
import java.util.Map;

import com.hdsx.framework.dao.Mapper;
import com.hdsx.framework.registry.bean.RegistryColumn;
import com.hdsx.framework.registry.bean.RegistryTable;

@Mapper
public interface TableMapper {
	
	int addTable(RegistryTable table);
	
	void addColumns(List<RegistryColumn> columns);
	
	RegistryTable queryTable(String id);
	List<RegistryTable> queryTables(int classify);
	
	int count(Map<String,Object> map);
	List<RegistryColumn> queryColumns(Map<String,Object> map);
	
	int delTables(String id);
	int delColumns(String ids);
}
