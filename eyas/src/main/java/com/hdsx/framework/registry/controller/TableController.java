package com.hdsx.framework.registry.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.hdsx.framework.base.BaseController;
import com.hdsx.framework.registry.bean.RegistryColumn;
import com.hdsx.framework.registry.bean.RegistryTable;
import com.hdsx.framework.registry.service.TableService;
import com.hdsx.framework.util.JsonUtils;
import com.hdsx.framework.util.UIModel;

@Controller
@RequestMapping(value="registry")
public class TableController extends BaseController{
	
	@Resource
	private TableService tableService;
	
	@RequestMapping(value="/queryTree.do",method=RequestMethod.POST)
	@ResponseBody
	public void queryTree(@RequestParam("classify") int classify){
		List<RegistryTable> tables= tableService.queryTables(classify);
		try {
			JsonUtils.write(tables, response.getWriter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/queryTable.do",method=RequestMethod.POST)
	public void queryTable(@RequestParam("id") String  id){
		RegistryTable table=tableService.queryTable(id);
		try {
			JsonUtils.write(table, response.getWriter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/queryColumns.do",method=RequestMethod.POST)
	@ResponseBody
	public void queryColumns(@RequestParam("tableName") String  tableName,@RequestParam("page") int  page,@RequestParam("rows") int  rows){
		if(tableName.isEmpty())return;
		UIModel<RegistryColumn> model=new UIModel<RegistryColumn>(page,rows);
		Map<String,Object> map=model.getParameter();
		map.put("tableName", tableName);
		List<RegistryColumn> columns=tableService.queryColumns(map);
		int count=tableService.count(map);
		model.setRows(columns);
		model.setTotal(count);
		try {
			JsonUtils.write(model, response.getWriter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/modify.do",method=RequestMethod.POST)
	@ResponseBody
	public void modify(@ModelAttribute RegistryTable table,@RequestParam("file") MultipartFile file,@RequestParam("text") String text)throws Exception{
		if(!file.isEmpty())	{
			table.setSymbol(file.getBytes());
		}
		if(text!=null &&!text.isEmpty()){
			List<RegistryColumn> columns=JSON.parseArray(text, RegistryColumn.class);
			table.setColumns(columns);
		}
		if(table.getId()==null||table.getId().isEmpty()){
			boolean status=tableService.addTable(table);
			message.setStatus(status);
		}
		write();
	}
	
	@RequestMapping(value="/delTable.do",method=RequestMethod.POST)
	@ResponseBody
	public void delTable(@RequestParam("id") String  id){
		message.setMessage(tableService.delTable(id));
		write();
	}
	@RequestMapping(value="/delColumns.do",method=RequestMethod.POST)
	@ResponseBody
	public void delColumns(@RequestParam("ids") String  ids){
		message.setMessage(tableService.delColumns(ids));
		write();
	}
}
