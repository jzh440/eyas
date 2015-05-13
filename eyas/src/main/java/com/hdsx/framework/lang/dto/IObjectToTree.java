package com.hdsx.framework.lang.dto;

import java.util.List;
import java.util.Map;

/**
 * 对象到树属性映射
 * @author xiongxt
 * @2015年3月25日
 */
public interface IObjectToTree {
	/**
	 * 获取标识
	 * @return
	 */
	String getId();
	/**
	 * 获取文本
	 * @return
	 */
	String getText();
	/**
	 * 获取开合状态
	 * @return
	 */
	String getState();
	/**
	 * 获取选中状态
	 * @return
	 */
	boolean getChecked();
	/**
	 * 获取辅助属性
	 * @return
	 */
	Map<String, Object> getAttributes();
	/**
	 * 获取子节点
	 * @return
	 */
	List<ComboTree> getChildren();
}
