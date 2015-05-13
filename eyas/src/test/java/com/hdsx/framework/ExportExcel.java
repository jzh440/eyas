package com.hdsx.framework;

import static com.hdsx.framework.lang.poi.Callback.CLASSNAME;
import static com.hdsx.framework.lang.poi.Callback.INTEGERS;
import static com.hdsx.framework.lang.poi.Callback.NOTMEIJU;
import static com.hdsx.framework.lang.poi.Callback.SHORTS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hdsx.framework.common.ExecutorMapper;
import com.hdsx.framework.lang.poi.Callback;
import com.hdsx.framework.lang.poi.Template;
import com.hdsx.framework.util.ReflectUtil;

public class ExportExcel {
	private static ApplicationContext act;
	private ExecutorMapper mapper =(ExecutorMapper) act.getBean("executorMapper");
//	private ExecutorService service =(ExecutorService) act.getBean("executorServiceImpl");
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		act=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void mapperSelectTest() throws Exception{
		String sql = "SELECT DISTINCT NAME,CODE, TYPE,SORT FROM fields_meta_data where code not in "
				+ "('ID','QDPY','ZDPY','DWMC','DRSJ','DRR','OBJECTID','PYZH'"
				+ ",'OPERATIONTYPE','EXIST','CJZT','SHZT','SBZT','SHZT','SHZT') and TYPE NOT IN "
				+ "('BLOB')";
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		String order = " order by sort";
		
		
		
		for (final String[] str : CLASSNAME) {
			String tablename = str[1];
			String path = "d:/temp/" + str[0] + ".xls";
			final List<Map<String, Object>> results_;
			if (!"GIS_LX".equals(tablename)) {
				results_ = mapper.select(sql + " and tablename='" + tablename + "'" + order);
			} else {
				tablename = "('GIS_LX','GIS_XZQH','GIS_LJLM','GIS_LDSF','GIS_LDMCLX',"
						+ "'GIS_JSDJ','GIS_DMDX','GIS_CFLD','GIS_CDSL','GIS_LDSS','GIS_YFGS')";
				results_ = mapper.select(sql + " and tablename in " + tablename + order);
			}
			
			//计算列数
			final List<String> columnNames = new ArrayList<String>();
			final List<Integer> columnsWidths = new ArrayList<Integer>();
			//合并列的序号
			final List<Integer> mergeIndexs = new ArrayList<Integer>();
			//合并列的序号
			final List<Integer> secondMergeIndexs = new ArrayList<Integer>();
			
			final List<String> fields = new ArrayList<String>();
			
			
			int num = 0;
			for(Map<String,Object> result : results_){
					String field = ((String)result.get("CODE")).toLowerCase();
					fields.add(field);
					
					String name = (String)result.get("NAME");
					//标题获取（有序）
					columnNames.add(name);
					String type = (String)result.get("TYPE");
					if("NVARCHAR2".equals(type)){
						type="String";
						columnsWidths.add(15);
					}else if("NUMBER".equals(type)){
						if(INTEGERS.contains(field)){
							type = "Integer";
							columnsWidths.add(10);
						}else if(SHORTS.contains(field)){
							type = "Short";
							columnsWidths.add(8);
						}else{
							type = "Double";
							columnsWidths.add(12);
						}
					}else if("DATE".equals(type)){
						type="Date";
						columnsWidths.add(15);
					}else if("NCLOB".equals(type)){
						type="String";
						columnsWidths.add(30);
					}
					
					if(INTEGERS.contains(field) && !NOTMEIJU.contains(field)){
						mergeIndexs.add(num);
						secondMergeIndexs.add(num + 1);
						num++;
						//被合并的列
						columnNames.add("");
						columnsWidths.add(10);
					}
					num++;
			}
			final int columns = num;
			if(columns == 0) continue;
			
			Callback callback = new Callback() {
				
				
				@Override
				public String getTitle() {
					// TODO Auto-generated method stub
					return str[0]+"明细表";
				}
				
				@Override
				public int getHeadRows() {
					// TODO Auto-generated method stub
					return 2;
				}
				
				@Override
				public List<String> getColumnValues(Object o) {
					// TODO Auto-generated method stub
					List<String> result = new ArrayList<String>();
					for(String field : fields){
						Object value = ReflectUtil.getValue(field, o);
//						if(Date.class.isAssignableFrom(value.getClass())){
						if(value instanceof Date){
							String dateValue = sdf.format((Date)value);
							result.add(dateValue);
						}else{
							result.add(value.toString());
						}
					}
					return result;
				}

				@Override
				public List<String> getColumnNames() {
					// TODO Auto-generated method stub
					return columnNames;
				}

				@Override
				public List<Integer> getColumnsWidths() {
					// TODO Auto-generated method stub
					return columnsWidths;
				}

				@Override
				public int getColumns() {
					// TODO Auto-generated method stub
					return columns;
				}

				@Override
				public List<Integer> getMergeIndexs() {
					// TODO Auto-generated method stub
					return mergeIndexs;
				}

				@Override
				public List<String> getFields() {
					// TODO Auto-generated method stub
					return fields;
				}

				@Override
				public List<Integer> getSecondMergeIndexs() {
					// TODO Auto-generated method stub
					return secondMergeIndexs;
				}
			};
			
			Template.exportExcel(path, new ArrayList<Object>(), callback);
			
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(Date.class.isAssignableFrom(java.sql.Date.class));;
	}
}
