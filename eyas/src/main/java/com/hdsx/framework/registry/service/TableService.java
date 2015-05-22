package com.hdsx.framework.registry.service;

import java.util.List;
import java.util.Map;

import com.hdsx.framework.registry.bean.RegistryColumn;
import com.hdsx.framework.registry.bean.RegistryTable;

public interface TableService {

	boolean addTable(RegistryTable table);
	
	RegistryTable queryTable(String id);
	
	List<RegistryTable> queryTables(int classify);
	
	int count(Map<String,Object> map);
	
	List<RegistryColumn> queryColumns(Map<String,Object> map);
	
	boolean delTable(String id);
	
	boolean delColumns(String ids);
}
