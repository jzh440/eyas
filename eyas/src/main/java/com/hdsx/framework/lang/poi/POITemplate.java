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

public class POITemplate<T> {

	/**
	 * @author Administrator
	 * @create time:2014-3-2
	 * @version:1.0
	 * @description:用于POI生成excel
	 * @param args
	 * @throws Exception 
	 */
	public void getPOI(String path, List<T> lists, POICallback<T> poiCallback) throws Exception {
		
//		//获取输出流
//		response.setContentType("application/x-msdownload;charset=utf-8");
//		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(poiCallback.getTitle() + ".xls", "UTF-8"));
//		
//		OutputStream os = response.getOutputStream();
		FileOutputStream os = new FileOutputStream(path);
		//计算列数
		int columns = poiCallback.getColumnWidths().length;
		
		//创建工作空间xls,包含多个工作簿
		HSSFWorkbook work = new HSSFWorkbook();
		
		//创建工作簿
		HSSFSheet sheet = work.createSheet(poiCallback.getTitle());
		
		 //======设置列宽==============================
		
//	    sheet.setColumnWidth(0, 5*256);
//	    sheet.setColumnWidth(1, 8*256);
//	    sheet.setColumnWidth(2, 5*256);
//	    sheet.setColumnWidth(3, 5*256);
//	    sheet.setColumnWidth(4, 15*256);
		for(int i = 0; i < columns; i++){
			sheet.setColumnWidth(i, poiCallback.getColumnWidths()[i]*256);
		}
		//========title区=========
		
		//创建第一行title
		HSSFRow row = sheet.createRow(0);
		
		//创建样式(title)
		HSSFCellStyle titleCellStyle = work.createCellStyle();//创建空间样式
		
		titleCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //设置边框样式
		titleCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		titleCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		titleCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		
		titleCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置字体居中
		
		HSSFFont titleFont = work.createFont(); //设置字体
	    titleFont.setColor(HSSFColor.BLUE.index);//字体颜色
	    titleFont.setFontHeight((short)250);//字体高度
	    titleFont.setFontName("华文新魏");//字体样式
	    titleFont.setBoldweight((short)20);//字体粗细
	    titleCellStyle.setFont(titleFont);//设置单元格字体
	    
	    //设置填充模式
	    titleCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		//设置前景色
		titleCellStyle.setFillForegroundColor(HSSFColor.BLACK.index);
		//创建单元格
		for(int i = 0; i < columns; i++){
			HSSFCell titleCell = row.createCell(i);
			titleCell.setCellStyle(titleCellStyle);
			//给单元格赋值
			if(i == 0)
				titleCell.setCellValue(poiCallback.getTitle());
		}
		
		//合并单元格
				CellRangeAddress titleCellRangeAddress=new CellRangeAddress(0, 0, 0, columns - 1);//合并后只显示第一个单元格
				sheet.addMergedRegion(titleCellRangeAddress);
				
				//==========head区===========
				
				//创建二行head
				HSSFRow headRow = sheet.createRow(1);
				
				//创建样式(head)
				HSSFCellStyle headCellStyle = work.createCellStyle();//创建空间样式
				
				headCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //设置边框样式
				headCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
				headCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				headCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
				
				headCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置字体居中
				
				HSSFFont headFont = work.createFont(); //设置字体
			    headFont.setColor(HSSFColor.BLUE.index);//字体颜色
			    headFont.setFontHeight((short)250);//字体高度
			    headFont.setFontName("楷体");//字体样式
			    headFont.setBoldweight((short)20);//字体粗细
			    headCellStyle.setFont(headFont);//设置单元格字体
			    
			    //创建单元格
//			    HSSFCell stu_id = headRow.createCell(0);//学号
//			    stu_id.setCellValue("学号");
//			    
//			    HSSFCell stu_name = headRow.createCell(1);//姓名
//			    stu_name.setCellValue("姓名");
//			    
//			    HSSFCell stu_sex=headRow.createCell(2);//性别
//			    stu_sex.setCellValue("性别");
//			    
//			    HSSFCell stu_age=headRow.createCell(3);//年婚
//			    stu_age.setCellValue("年龄");
//			    
//			    HSSFCell stu_tel=headRow.createCell(4);//电话
//			    stu_tel.setCellValue("电话");
				
			    //设置样式
//			    stu_id.setCellStyle(headCellStyle);
//			    stu_name.setCellStyle(headCellStyle);
//			    stu_sex.setCellStyle(headCellStyle);
//			    stu_age.setCellStyle(headCellStyle);
//			    stu_tel.setCellStyle(headCellStyle);
			    //设置head单元格名字和样式
			    for(int i = 0; i < columns; i++){
					HSSFCell headCell = headRow.createCell(i);
					headCell.setCellValue(poiCallback.getColumnNames()[i]);
					headCell.setCellStyle(headCellStyle);
				}
				//=============数据区==============
			    
			    //创建样式(data)
				HSSFCellStyle dataCellStyle = work.createCellStyle();//创建空间样式
				
				dataCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //设置边框样式
				dataCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
				dataCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				dataCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
				
				dataCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置字体居中
				
				HSSFFont dataFont = work.createFont(); //设置字体
			    //dataFont.setColor(HSSFColor.BLUE.index);//字体颜色
			    //dataFont.setFontHeight((short)250);//字体高度
			    dataFont.setFontName("宋体");//字体样式
			    dataFont.setBoldweight((short)15);//字体粗细
			    dataCellStyle.setFont(dataFont);//设置单元格字体
			    
			    //设置数据区单元格值和样式
//			    HSSFCell dataCell = dataRow.createCell(0);
//			    dataCell.setCellValue("25");
//			    dataCell.setCellStyle(dataCellStyle);
			    
			    //重复
//			    dataRow.createCell(1).setCellValue("去淘淘");
//			    dataRow.createCell(2).setCellValue("女");
//			    dataRow.createCell(3).setCellValue("24");
//			    dataRow.createCell(4).setCellValue("1152926812");
			    for(int j = 0; j < lists.size(); j++){
			    	HSSFRow dataRow = sheet.createRow(j + 2);
				    for(int i = 0; i < columns; i++){
						HSSFCell dataCell = dataRow.createCell(i);
						dataCell.setCellValue(poiCallback.getColumnValues(lists.get(j))[i]);
						dataCell.setCellStyle(dataCellStyle);
					}
			    }
				//生成目标文件
//				FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator.WIN-20130926JXK\\Desktop\\通讯录.xls");
				os.flush();
				//写出文件
				work.write(os);
			}
		}

