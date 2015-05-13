package com.hdsx.framework.lang.poi;
/**
 * poi导出excel接口
 * @author xiongxt
 * @2015年3月26日
 * @param <T>
 */
public interface POICallback<T> {
	/**
	 * 标题（文件名）
	 * @return
	 */
	String getTitle();
	/**
	 * 列宽
	 * @return
	 */
	int[] getColumnWidths();
	/**
	 * 列名
	 * @return
	 */
	String[] getColumnNames();
	/**
	 * 数据
	 * @param t
	 * @return
	 */
	String[] getColumnValues(T t);
}
