package com.hdsx.framework.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;

import com.hdsx.framework.lang.FieldMeta;
/**
 * 导出Excel
 * @author jingzh
 * */
public class ExcelExport {
	
	/**
	   * 获取HSSFWorkbook.
	   *
	   * @param names 属性名称
	   * @param codes 属性编码
	   * @param list  结果集
	   * @return HSSFWorkbook
	   */
	public static <T> HSSFWorkbook export(String[] names,String[] codes,List<T> list){
		
		return export(names,codes,"yyyy-MM-dd",list);
	}
	/**
	   * 获取HSSFWorkbook.
	   *
	   * @param names 属性名称
	   * @param codes 属性编码
	   * @param list  结果集
	   * @param datePattern 日期格式
	   * @return HSSFWorkbook
	   */
	public static <T> HSSFWorkbook export(String[] names,String[] codes,String datePattern,List<T> list){
		HSSFWorkbook wb = new HSSFWorkbook();  
		HSSFSheet sheet = wb.createSheet("sheet1"); 
		HSSFCellStyle style = wb.createCellStyle();  
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("h:mm:ss"));  
		style.setWrapText(true);// 自动换行  
		style.setAlignment(CellStyle.ALIGN_CENTER);//水平居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中
		HSSFFont font = wb.createFont();    
		font.setFontName("仿宋_GB2312");    
		font.setFontHeightInPoints((short) 12);    
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示    
		//style.setFont(font);//选择需要用到的字体格式 
		HSSFRow row = sheet.createRow(0);  //设定title
		row.setHeight((short) 500);// 设定行的高度  
		for(int i=0,len=names.length;i<len;i++)
		{
			sheet.setColumnWidth(i, 5000);  
			sheet.setDefaultColumnStyle(i, style);
			HSSFCell cell = row.createCell(i);  
			cell.setCellValue(names[i]);  
		}
		HSSFCell cell ;
		for(int i=0,size=list.size();i<size;i++){
			row = sheet.createRow(i+1); 
			T o=list.get(i);
			for(int j=0,len=codes.length;j<len;j++)
			{
				cell = row.createCell(j); 
				Object value=ReflectUtil.getValue(codes[j], o);
				if(value instanceof Date)
				{
					SimpleDateFormat format=new SimpleDateFormat(datePattern);
					value=format.format(value);
				}
				cell.setCellValue(value==null?"":value+"");
			}
		}
		return wb;
	}
	/**
	   * 输出到浏览器.
	   *
	   * @param response 返回请求
	   * @param wb 工作簿
	   * @param filename  文件名称
	   */
	public static void exportExcel(HttpServletResponse response,HSSFWorkbook wb,String filename) throws IOException {
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.setHeader("Content-disposition", "attachment;filename="+ new String((filename+".xls").getBytes("GBK"),"ISO-8859-1"));
		wb.write(response.getOutputStream());
	} 
	
	/**
	   * 获取HSSFWorkbook.
	   *
	   * @param names 属性名称
	   * @param codes 属性编码
	   * @param list  结果集
	   * @param datePattern 日期格式
	   * @return HSSFWorkbook
	   */
	public static HSSFWorkbook export(List<FieldMeta> fieldMeta, String[] codes,String[] names, String datePattern,List<Map<String,Object>> list){
		HSSFWorkbook wb = new HSSFWorkbook();  
		HSSFSheet sheet = wb.createSheet("sheet1"); 
		HSSFCellStyle style = wb.createCellStyle();  
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("h:mm:ss"));  
		style.setWrapText(true);// 自动换行  
		style.setAlignment(CellStyle.ALIGN_CENTER);//水平居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中
		HSSFFont font = wb.createFont();    
		font.setFontName("仿宋_GB2312");    
		font.setFontHeightInPoints((short) 12);    
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示    
		//style.setFont(font);//选择需要用到的字体格式 
		HSSFRow row = sheet.createRow(0);  //设定title
		row.setHeight((short) 500);// 设定行的高度  
		for(int i=0;i<fieldMeta.size();i++)
		{
			sheet.setColumnWidth(i, 5000);  
			sheet.setDefaultColumnStyle(i, style);
			HSSFCell cell = row.createCell(i);  
			cell.setCellValue(fieldMeta.get(i).getName());  
		}
		for(int i=0;i<names.length;i++)
		{
			sheet.setColumnWidth(fieldMeta.size() + i, 5000);  
			sheet.setDefaultColumnStyle(fieldMeta.size() + i, style);
			HSSFCell cell = row.createCell(fieldMeta.size() + i);  
			cell.setCellValue(names[i]);  
		}
		HSSFCell cell ;
		for(int i=0;i<list.size();i++){
			row = sheet.createRow(i+1); 
			Map<String,Object> data=list.get(i);
			for(int j=0;j<fieldMeta.size();j++)
			{
				cell = row.createCell(j); 
				String code = fieldMeta.get(j).getCode().toUpperCase();
				Object value= data.get(code);
				if(value instanceof Date)
				{
					SimpleDateFormat format=new SimpleDateFormat(datePattern);
					value=format.format(value);
				}
				cell.setCellValue(value==null?"":value+"");
			}
			for(int k=0; k<codes.length; k++){
				cell = row.createCell(fieldMeta.size() + k); 
				Object value= data.get(codes[k]);
				if(value instanceof Date)
				{
					SimpleDateFormat format=new SimpleDateFormat(datePattern);
					value=format.format(value);
				}
				cell.setCellValue(value==null?"":value+"");
			}
		}
		return wb;
	}
}
