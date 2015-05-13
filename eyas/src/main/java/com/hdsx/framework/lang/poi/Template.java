package com.hdsx.framework.lang.poi;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

public class Template {

	/**
	 * @author Administrator
	 * @create time:2014-3-2
	 * @version:1.0
	 * @description:用于POI生成excel
	 * @param args
	 * @throws Exception 
	 */
	public static void exportExcel(String path, List<Object> lists, Callback callback) throws Exception {
		FileOutputStream os = new FileOutputStream(path);
		//计算列数
		List<String> columnNames = callback.getColumnNames();
		List<Integer> columnsWidths = callback.getColumnsWidths();
		int columns = callback.getColumns();
		//合并列的序号
		List<Integer> mergeIndexs = callback.getMergeIndexs();
		//合并列的序号2
		List<Integer> secondMergeIndexs = callback.getSecondMergeIndexs();
		
		
		//创建工作空间xls,包含多个工作簿
		HSSFWorkbook work = new HSSFWorkbook();
		
		//创建工作簿
		HSSFSheet sheet = work.createSheet(callback.getTitle());
		
		for(int i = 0; i < columns; i++){
			sheet.setColumnWidth(i, columnsWidths.get(i)*256);
		}
		//========title区=========
		
		/**** row0 **/
		//创建第一行title1
		HSSFRow row = sheet.createRow(0);
		row.setHeight((short)800);
		//创建样式(row0)
		HSSFCellStyle row0CellStyle = row0Style(work);
		//创建单元格
		for(int i = 0; i < columns; i++){
			HSSFCell row0Cell = row.createCell(i);
			row0Cell.setCellStyle(row0CellStyle);
			//给单元格赋值
			if(i == 0)
				row0Cell.setCellValue(callback.getTitle());
		}
		//合并单元格
		CellRangeAddress title1CellRangeAddress=new CellRangeAddress(0, 0, 0, columns - 1);//合并后只显示第一个单元格
		sheet.addMergedRegion(title1CellRangeAddress);
		
		/**** row1 **/
		HSSFRow row1 = sheet.createRow(1);
		row1.setHeight((short)400);
		//创建样式(row1)
		HSSFCellStyle row1CellStyle = row1Style(work);
		//创建单元格
		for(int i = 0; i < columns; i++){
			HSSFCell row1Cell = row1.createCell(i);
			row1Cell.setCellStyle(row1CellStyle);
		}
		
		/**** row2 **/
		//创建样式(row2)
		HSSFRow row2 = sheet.createRow(2);
		HSSFCellStyle row2CellStyle = row2Style(work);
		//创建单元格
		for(int i = 0; i < columns; i++){
			HSSFCell row2Cell = row2.createCell(i);
			row2Cell.setCellStyle(row2CellStyle);
			//给单元格赋值
			if(i == columns-3)
				row2Cell.setCellValue(Callback.ZBDW);
		}
		
		/**** row3 **/
		//创建样式(row3)
		HSSFRow row3 = sheet.createRow(3);
		HSSFCellStyle row3CellStyle = row3Style(work);
		//创建单元格
		for(int i = 0; i < columns; i++){
			HSSFCell row3Cell = row3.createCell(i);
			row3Cell.setCellStyle(row3CellStyle);
			//给单元格赋值
			if(i == 0)
				row3Cell.setCellValue(Callback.TBDW_TBSJ);
		}
		
				
		//==========head区row4===========
		int countHead = 0;
		/**** row4 **/
		//创建四行head
		HSSFRow headRow = sheet.createRow(4);
		countHead++;
		//创建样式(head)
		HSSFCellStyle headCellStyle = headStyle(work);//创建空间样式
	    //设置head单元格名字和样式
	    for(int i = 0; i < columns; i++){
			HSSFCell headCell = headRow.createCell(i);
			headCell.setCellValue(columnNames.get(i));
			headCell.setCellStyle(headCellStyle);
		}
	    for(int k : mergeIndexs){
		    //合并单元格
			CellRangeAddress headCell1RangeAddress=new CellRangeAddress(4, 4, k, k + 1);
			sheet.addMergedRegion(headCell1RangeAddress);
	    }
	    
	  /**** row5 **/ 
	  //创建五行head
	  HSSFRow headRow2 = sheet.createRow(5);
	  countHead++;
	  //设置head单元格名字和样式
	  for(int i = 0; i < columns; i++){
			HSSFCell headCell = headRow2.createCell(i);
			if(mergeIndexs.contains(i)){
				headCell.setCellValue("代码");
			} else if(secondMergeIndexs.contains(i)){
				headCell.setCellValue("描述");
			}
			headCell.setCellStyle(headCellStyle);
		}
	  
	  for(int i = 0; i< columns; i++){
		  if(!mergeIndexs.contains(i)){
			  if(!secondMergeIndexs.contains(i)){
				  CellRangeAddress headCell2RangeAddress=new CellRangeAddress(4, 5, i, i);
				  sheet.addMergedRegion(headCell2RangeAddress);
			  }
		  }
	  }
	  
	  /**** row6 **/ 
	  //创建列号行
	  HSSFRow row6 = sheet.createRow(6);
	  //设置head单元格名字和样式
	  for(int i = 0; i < columns; i++){
		  HSSFCell row6Cell = row6.createCell(i);
		  row6Cell.setCellValue(i);
		  row6Cell.setCellStyle(headCellStyle);
	  }
	  
	    
			    
				//=============数据区==============
			    
			    //创建样式(data)
				HSSFCellStyle dataCellStyle = dataCellStyle(work);//创建空间样式
			    for(int j = 0; j < lists.size(); j++){
			    	HSSFRow dataRow = sheet.createRow(j + 6);
			    	int skip = 0;
				    for(int i = 0; i < columns; i++){
						HSSFCell dataCell = dataRow.createCell(i);
						 for(int k : mergeIndexs){
						    	if(i == k + 1){
						    		skip++;
						    		dataCell.setCellValue("");
						    	} else {
						    		dataCell.setCellValue(callback.getColumnValues(lists.get(j)).get(i - skip));
						    	}
						 }  
						dataCell.setCellStyle(dataCellStyle);
					}
			    }
			    
			    //head区3行删掉占位行
			    if(countHead == 3)
			    	sheet.removeRow(sheet.getRow(1));
			    
				os.flush();
				//写出文件
				work.write(os);
				os.close();
			}
	
	 private static HSSFCellStyle row0Style(HSSFWorkbook work){
		//创建样式(title1)
			HSSFCellStyle row0CellStyle = work.createCellStyle();//创建空间样式
			
			row0CellStyle.setBorderBottom(HSSFCellStyle.BORDER_NONE);//BORDER_THIN); //设置边框样式
			row0CellStyle.setBorderTop(HSSFCellStyle.BORDER_NONE);//BORDER_THIN);
			row0CellStyle.setBorderLeft(HSSFCellStyle.BORDER_NONE);//BORDER_THIN);
			row0CellStyle.setBorderRight(HSSFCellStyle.BORDER_NONE);//BORDER_THIN);
			
			row0CellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置字体居中
			row0CellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			
			HSSFFont row0Font = work.createFont(); //设置字体
		    row0Font.setColor(HSSFColor.BLACK.index);//字体颜色
		    row0Font.setFontHeight((short)300);//字体高度
		    row0Font.setFontName("黑体");//字体样式
		    row0Font.setBoldweight((short)26);//字体粗细
		    row0CellStyle.setFont(row0Font);//设置单元格字体
		    
		    //设置填充模式
//		    title1CellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			//设置前景色
//			title1CellStyle.setFillForegroundColor(HSSFColor.BLACK.index);
		return row0CellStyle;
	}
	 
	 private static HSSFCellStyle row1Style(HSSFWorkbook work){
			//创建样式(title1)
				HSSFCellStyle row1CellStyle = work.createCellStyle();//创建空间样式
				
				row1CellStyle.setBorderBottom(HSSFCellStyle.BORDER_NONE);//BORDER_THIN); //设置边框样式
				row1CellStyle.setBorderTop(HSSFCellStyle.BORDER_NONE);//BORDER_THIN);
				row1CellStyle.setBorderLeft(HSSFCellStyle.BORDER_NONE);//BORDER_THIN);
				row1CellStyle.setBorderRight(HSSFCellStyle.BORDER_NONE);//BORDER_THIN);
			return row1CellStyle;
		}
	 
	 private static HSSFCellStyle row2Style(HSSFWorkbook work){
			//创建样式(title1)
				HSSFCellStyle row2CellStyle = work.createCellStyle();//创建空间样式
				
				row2CellStyle.setBorderBottom(HSSFCellStyle.BORDER_NONE);//BORDER_THIN); //设置边框样式
				row2CellStyle.setBorderTop(HSSFCellStyle.BORDER_NONE);//BORDER_THIN);
				row2CellStyle.setBorderLeft(HSSFCellStyle.BORDER_NONE);//BORDER_THIN);
				row2CellStyle.setBorderRight(HSSFCellStyle.BORDER_NONE);//BORDER_THIN);
				
				row2CellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);//设置字体左对齐
				row2CellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//设置垂直居中
				
				HSSFFont row2Font = dataFont(work);//创建字体
			    row2CellStyle.setFont(row2Font);//设置单元格字体				
				
			return row2CellStyle;
		}
	 
	 private static HSSFCellStyle row3Style(HSSFWorkbook work){
		 //创建样式(title1)
		 HSSFCellStyle row3CellStyle = work.createCellStyle();//创建空间样式
		 
		 row3CellStyle.setBorderBottom(HSSFCellStyle.BORDER_NONE);//BORDER_THIN); //设置边框样式
		 row3CellStyle.setBorderTop(HSSFCellStyle.BORDER_NONE);//BORDER_THIN);
		 row3CellStyle.setBorderLeft(HSSFCellStyle.BORDER_NONE);//BORDER_THIN);
		 row3CellStyle.setBorderRight(HSSFCellStyle.BORDER_NONE);//BORDER_THIN);
		 
		 row3CellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);//设置字体左对齐
		 row3CellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//设置垂直居中
		 
		 HSSFFont row3Font = dataFont(work);//创建字体
		 row3CellStyle.setFont(row3Font);//设置单元格字体				
		 
		 return row3CellStyle;
	 }
	 private static HSSFCellStyle headStyle(HSSFWorkbook work){
		 HSSFCellStyle headCellStyle = work.createCellStyle();//创建空间样式
		 
		 headCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);//BORDER_THIN); //设置边框样式
		 headCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//BORDER_THIN);
		 headCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//BORDER_THIN);
		 headCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//BORDER_THIN);
		 
		 headCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置字体居中
		 headCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//设置垂直居中
		 
		 HSSFFont headFont = dataFont(work);//创建字体
		 headCellStyle.setFont(headFont);//设置单元格字体				
		 
		 return headCellStyle;
	 }
	 
	 private static HSSFCellStyle dataCellStyle(HSSFWorkbook work){
			 HSSFCellStyle dataCellStyle = work.createCellStyle();//创建空间样式
			 
			 dataCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);//BORDER_THIN); //设置边框样式
			 dataCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//BORDER_THIN);
			 dataCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//BORDER_THIN);
			 dataCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//BORDER_THIN);
			 
			 dataCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置字体居中
			 dataCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//设置垂直居中
			 
			 HSSFFont headFont = dataFont(work);//创建字体
			 dataCellStyle.setFont(headFont);//设置单元格字体				
			 
			 return dataCellStyle;
		 }
	 private static HSSFFont dataFont(HSSFWorkbook work){
		 HSSFFont font = work.createFont(); //设置字体
		 font.setColor(HSSFColor.BLACK.index);//字体颜色
		 font.setFontHeight((short)200);//字体高度
		 font.setFontName("宋体");//字体样式
		 font.setBoldweight((short)9);//字体粗细
		 return font;
	 }
}

