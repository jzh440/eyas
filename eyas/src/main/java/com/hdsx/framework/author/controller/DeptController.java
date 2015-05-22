/*package com.hdsx.framework.author.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hdsx.framework.author.bean.Dept;
import com.hdsx.framework.author.service.DeptService;
import com.hdsx.framework.base.BaseController;
import com.hdsx.framework.lang.UIPage;
import com.hdsx.framework.lang.dto.ComboTree;
import com.hdsx.framework.lang.dto.DtoUtil;
import com.hdsx.framework.util.ExcelExport;
import com.hdsx.framework.util.Iso2UtfUtil;
import com.hdsx.framework.util.StringUtile;
*//**
 * 单位控制器
 * @author xiongxt
 * @2015年3月21日
 *//*
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController {
	@Resource
	private DeptService service;
	
	*//**
	 * 根据id查询单位
	 * @param id
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="get/{id}",method=RequestMethod.GET)
	public void selectOne(@PathVariable("id")String id){
		param.put("id", id);
		Dept bean = service.selectOne(param);
		message.setMessage(bean);
		write();
	}
	
	*//**
	 * 根据id查询单位
	 * @param id
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="info/{id}",method=RequestMethod.GET)
	public void selectById(@PathVariable("id")String id){
		Dept bean = service.selectById(id);
		message.setMessage(bean);
		write();
	}
	
	*//**
	 * 增加单位
	 * @param id
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="add",method=RequestMethod.POST)
	public void insert(@ModelAttribute @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss:sss") Dept dept){
		int result = service.insert(dept);
		message.setMessage(result);
		write();
	}
	
	*//**
	 * 根据id修改单位
	 * @param id
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="modify",method=RequestMethod.POST)
	public void update(@ModelAttribute @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss:sss") Dept dept){
		int result = service.update(dept);
		message.setMessage(result);
		write();
	}
	
	*//**
	 * 根据ids删除单位
	 * @param ids
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="remove",method=RequestMethod.POST)
	public void delete(@RequestParam String ids){
		String[] ids_ = null;
		if(!StringUtile.isEmptyString(ids)) {
			ids_ = ids.replaceAll(" ", "").split(",");
		}
		//param.put("ids", ids_);
		//int result = service.delete(param);
		//message.setMessage(result);
		write();
	}
	
	*//**
	 * 分页查询
	 * @param order 排序sql语句
	 * @param page  第几页
	 * @param rows  每页数
	 * @param dept  查询条件
	 * @throws UnsupportedEncodingException 
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="query",method=RequestMethod.GET)
	public void selectList(@RequestParam(defaultValue="DEPTNAME DESC",required=false) String order,@RequestParam(defaultValue="0",required=false) int page, @RequestParam(defaultValue="0",required=false) int rows, @ModelAttribute @DateTimeFormat(pattern="yyyy-MM-dd") Dept dept) throws UnsupportedEncodingException{
		UIPage<Dept> uipage = new UIPage<Dept>(page, rows);
		Iso2UtfUtil.converToUTF(dept);
		param = uipage.getParameter();//put begin和end
		param.put("deptName", dept.getDeptName());
		param.put("address", dept.getAddress());
		param.put("order", order);//排序
		List<Dept> results = service.selectList(param);
		int total = service.count(param);
		uipage.setRows(results);
		uipage.setTotal(total);
		message.setMessage(uipage);
		write();
	}
	
	*//**
	 * 导出
	 * @param order 排序sql语句
	 * @param dept  查询条件
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="export",method=RequestMethod.GET)
	public void export(@RequestParam(defaultValue="DEPTNAME DESC",required=false) String order, @RequestParam(required=false) String ids, 
			@ModelAttribute @DateTimeFormat(pattern="yyyy-MM-dd") Dept dept){
		param.put("order", order);//排序
		if (!StringUtile.isEmptyString(ids)) {
			String[] ids_ = ids.replace(" ", "").split(",");
			param.put("ids", ids_);
		} else {
			Iso2UtfUtil.converToUTF(dept);//查询条件转码成UTF-8
			param.put("deptName", dept.getDeptName());
			param.put("address", dept.getAddress());
		}
		List<Dept> list = service.selectList(param);
		String[] codes={"deptName", "leader", "address", "tel", "postCode", "fax", "distCode","qhmc"};
		String[] names={"单位名称", "负责人", "单位地址", "电话","邮编", "传真", "行政区划编码", "行政区划名称"};
		HSSFWorkbook export = ExcelExport.export(names, codes, "yyyy年MM月dd日", list);
		try {
			ExcelExport.exportExcel(response, export, "单位");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			clear();
		}
	}
	
	*//**
	 * 根据当前用户查询所有单位树结构（包括本单位）
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="allTree",method=RequestMethod.GET)
	public void treeForAll(){
		//String deptId = getDeptId();
		//List<Dept> all = service.treeForAll(deptId);
		//List<ComboTree> listToList = DtoUtil.listToList(all, new ArrayList<String>(), deptId, new String[]{"id","deptName","children"});
		//message.setMessage(listToList);
		//write();
	}
	
	*//**
	 * 根据当前用户查询所有单位树结构（不包括本单位）
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="childTree",method=RequestMethod.GET)
	public void treeForChildren(){
		//String deptId = getDeptId();
		//List<Dept> children = service.treeForChildren(deptId);
		//List<ComboTree> listToList = DtoUtil.listToList(children, new ArrayList<String>(), deptId, new String[]{"id","deptName","children"});
		//message.setMessage(listToList);
		//write();
	}
	
}
*/