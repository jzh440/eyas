package com.hdsx.framework;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hdsx.framework.common.ExecutorMapper;

public class ExecutorTest {
	private static ApplicationContext act;
	private ExecutorMapper mapper =(ExecutorMapper) act.getBean("executorMapper");
//	private ExecutorService service =(ExecutorService) act.getBean("executorServiceImpl");
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		act=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void mapperSelectTest() throws Exception{
		String[] integers_ = {"sxxfx","dllxbm","qlkjfldm","asynxfldm","sjhzdjdm","qljszkpddm","ldmclxdm","sfyfgsbmbm","dmdm","cdsl",
				"ldjsdjbmbm","sdfl","lx","sfzlx","zczlx","gczlx","gcfx","qbblx","sbsyzt","jksslx","yyclpbs",
				"ryzs","rfbc","syxz","zdjb","lxjsdj","lxxzdj","jglx","bplx"};
		List<String> integers = Arrays.asList(integers_);
		String[] notmeiju_ = {"ryzs","rfbc","yyclpbs"};
		List<String> notmeiju = Arrays.asList(notmeiju_);
		String[] shorts_ ={"mtbwgs"};
		List<String> shorts = Arrays.asList(shorts_);
		String sql = "SELECT DISTINCT NAME,CODE, TYPE,SORT FROM fields_meta_data where code not in "
				+ "('ID','QDPY','ZDPY','DWMC','DRSJ','DRR','OBJECTID','PYZH'"
				+ ",'OPERATIONTYPE','EXIST','CJZT','SHZT','SBZT','SHZT','SHZT') and TYPE NOT IN "
				+ "('BLOB')";
		@SuppressWarnings("unused")
		String nottable = " and tablename not in ('SDE_LOGFILE_DATA','SDE_LOGFILES',"
				+ "'GIS_XZQH','GIS_LJLM','GIS_LDSF','GIS_LDMCLX','GIS_JSDJ',"
				+ "'GIS_DMDX','GIS_CFLD','GIS_CDSL','GIS_LDSS','GIS_YFGS','GIS_BZBP')";
		String order = " order by sort";
		String[][] classname = {
				{"com.hdsx.giscj.road.bean.GISLine","GIS_LX"},
				{"com.hdsx.giscj.road.bean.GISNclx","GIS_NCLX"},
				{"com.hdsx.giscj.zygzw.bean.GisSd","GIS_SD"},
				{"com.hdsx.giscj.zygzw.bean.GisQl","GIS_QL"},
				{"com.hdsx.giscj.yxss.bean.GisSfz","GIS_SFZ"},
				{"com.hdsx.giscj.yxss.bean.GISJtlg","GIS_JTLGCZ"},
				{"com.hdsx.giscj.yxss.bean.GisKbqbb","GIS_KBQBB"},
				{"com.hdsx.giscj.yxss.bean.GisJksssb","GIS_JKSSSB"},
				{"com.hdsx.giscj.yxss.bean.GISFwq","GIS_FWQ"},
				{"com.hdsx.giscj.yxss.bean.GISCrk","GIS_CRK"},
				{"com.hdsx.giscj.yxss.bean.GisZcz","GIS_ZCZ"},
				{"com.hdsx.giscj.cskyzt.bean.GISCzctkd","GIS_CZCTKD"},
				{"com.hdsx.giscj.cskyzt.bean.GISGdzd","GIS_CSGDJTYYZD"},
				{"com.hdsx.giscj.cskyzt.bean.GISGdlx","GIS_CSGDJTYYXL"},
				{"com.hdsx.giscj.cskyzt.bean.GISQcby","GIS_GGDQCTCBYC"},
				{"com.hdsx.giscj.cskyzt.bean.GISQclx","GIS_CGGGQCYYXL"},
				{"com.hdsx.giscj.cskyzt.bean.GISQczd","GIS_CGGGQCYYZD"},
				{"com.hdsx.giscj.slzt.bean.GisGk","GIS_GK"},
				{"com.hdsx.giscj.dlyszt.bean.GISClwx","GIS_CLWXQY"},
				{"com.hdsx.giscj.dlyszt.bean.GISHyz","GIS_HYZD"},
				{"com.hdsx.giscj.dlyszt.bean.GISKyz","GIS_KYZD"},
				{"com.hdsx.giscj.dlyszt.bean.GISKybx","GIS_KYBX"},
				{"com.hdsx.giscj.dlyszt.bean.GISHyzz","GIS_HYZZYTQY"},
				{"com.hdsx.giscj.dlyszt.bean.GisYsqy","GIS_YSQY"},
				{"com.hdsx.giscj.dlyszt.bean.GisYsgljg","GIS_YSGLJG"},
				{"com.hdsx.giscj.dlyszt.bean.GISJpjg","GIS_JPJG"},
				{"com.hdsx.giscj.slzt.bean.GisNhhd","GIS_NHHD"},
				{"com.hdsx.giscj.slzt.bean.GisMt","GIS_MT"},
				{"com.hdsx.giscj.slzt.bean.GisZddk","GIS_ZDDK"},
				{"com.hdsx.giscj.lzzt.bean.Dmgzw","GIS_DMGZW"},
				{"com.hdsx.giscj.lzzt.bean.Fglbz","GIS_FGLBZ"},
				{"com.hdsx.giscj.lzzt.bean.Ggp","GIS_GGP"},
				{"com.hdsx.giscj.lzzt.bean.Kyglss","GIS_KYGLSS"},
				{"com.hdsx.giscj.lzzt.bean.Gxzcz","GIS_ZCZ"},
				{"com.hdsx.giscj.lzzt.bean.Zfbm","GIS_ZFBM"},
				{"com.hdsx.giscj.yxss.bean.GisBzbp","GIS_BZBP"}};
		String placeholder = "	   ";
		FileWriter fw = new FileWriter(new File("d:/temp/xls-config.xml"));
		PrintWriter out = new PrintWriter(fw);   
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<root xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"xls-config.xsd\">");
		for(String[] str : classname){
			String tablename = str[1];
			String tables_sql = tablename;
			List<Map<String,Object>> results_ = null;
			if(!"GIS_LX".equals(tablename)){
			  results_= mapper.select(sql + " and tablename='" + tables_sql + "'"+ order);
			}else{
				tables_sql = "('GIS_LX','GIS_XZQH','GIS_LJLM','GIS_LDSF','GIS_LDMCLX',"
						+ "'GIS_JSDJ','GIS_DMDX','GIS_CFLD','GIS_CDSL','GIS_LDSS','GIS_YFGS')";
				results_= mapper.select(sql + " and tablename in " + tables_sql + order);
			}
			if(results_ == null || results_.isEmpty()) continue;
			out.println(placeholder + "<table id=\""+tablename + "\" rowStart=\"7\" totalRows=\"0\" className=\"" + str[0] + "\" >");
			int i = 0;
			for(Map<String,Object> result:results_){
				String field = ((String)result.get("CODE")).toLowerCase();
				String name = (String)result.get("NAME");
				String type = (String)result.get("TYPE");
				if("NVARCHAR2".equals(type)){
					type="String";
				}else if("NUMBER".equals(type)){
					if(integers.contains(field)){
						type = "Integer";
					}else if(shorts.contains(field)){
						type = "Short";
					}else
						type = "Double";
				}else if("DATE".equals(type)){
					type="Date";
				}else if("NCLOB".equals(type)){
					type="String";
				}
				out.print(placeholder + placeholder + 
						"<column cellType=\""+type+"\" cellCode=\"cell_"+i+"\" "
								+ "cellName=\""+name+"\" xlsField=\""+field+"\" ");
				
				String[][] shpf_ = {{"lxdm","lxbm"},{"lxmc","lxmc"},{"qdzh","qdzh"},
						{"zdzh","zdzh"},{"lc","tjlc"},{"dllxbm","dllx"},{"lddm","lxbm"},
						{"qldm","fsbm"},{"qlzxzh","wzzh"},{"sdbm","fsbm"},{"sdzxzh","wzzh"},
						{"zh","wzzh"},{"crkbm","fsbm"},{"fwqbm","fsbm"},{"sfzbm","fsbm"},
						{"dwzh","wzzh"},{"zczbm","fsbm"},{"gczbm","fsbm"},{"qbbbm","fsbm"},
						{"jkssbh","fsbm"},{"bpbm","fsbm"}};
				String[] keyf_ = {"lxdm","dllxbm","lddm","qldm","qlzxzh","sdbm","sdzxzh","zh",
						"crkbm","fwqbm","sfzbm","dwzh","zczbm","gczbm","qbbbm","jkssbh","bpbm"};
				
				Map<String,String> shpf = new HashMap<String, String>();
				for(String[] shpf__ : shpf_){
					shpf.put(shpf__[0], shpf__[1]);
				}
				List<String> keyf = Arrays.asList(keyf_);
				
				
				String shapefield = "";
				boolean isKey = true;
				
				if(shpf.containsKey(field) && !field.equals("lxmc")){
					shapefield = shpf.get(field);
				}else if(field.equals("lxmc") && tablename.contains("GIS_LX")){
					shapefield = shpf.get(field);
				}
				if (!keyf.contains(field)){
					isKey = !isKey;
				}
				
				String shapeString = "shpField=\""+shapefield+"\"";
				String isKeyString = " isKey=\"true\"";
				
				String shp = "";
				if(!"".equals(shapefield) && !isKey){
					shp = shapeString;
				}else if(!"".equals(shapefield) && isKey){
					shp = shapeString + isKeyString;
				}
				out.print(shp);				
				out.println("/>");
				i++;
				if("Integer".equals(type) && !notmeiju.contains(field)){
					i++;
				}
			}
			out.println(placeholder + placeholder + "<column cellType=\"Geometry\" cellName=\"SHAPE\" xlsField=\"shape\" shpField=\"shape\" replace=\"true\"/>");
			out.println(placeholder + "</table>");
		}
		out.println("</root>");
		out.flush();
		out.close();
	}
}
