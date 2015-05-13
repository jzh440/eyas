package com.hdsx.framework.lang.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 树结构
 * @author xiongxt
 * @2015年3月25日
 */
public class ComboTree {
	/** 数据唯一标识 */
	private String id;
	/** 显示文本  */
	private String text;
	/** 是否打开  closed open */ 
	private String state;
	/** 是否选中  */
	private boolean checked;
	/** 其他属性  */
	private Map<String, Object> attributes = new HashMap<String, Object>();
	/** 子节点  */
	private List<ComboTree> children = new ArrayList<ComboTree>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public List<ComboTree> getChildren() {
		return children;
	}
	public void setChildren(List<ComboTree> children) {
		this.children = children;
	}
	
	public ComboTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ComboTree(String id, String text, String state, boolean checked,
			Map<String, Object> attributes, List<ComboTree> children) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.checked = checked;
		this.attributes = attributes;
		this.children = children;
	}
	
}
