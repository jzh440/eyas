package com.hdsx.framework.author.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 行政区划编码
 * @author xiongxt
 * @2015年3月13日
 */
public class DistCode  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//行政区划编码
	private String code;
	//上级行政区划编码
	private String parent;
	//行政区划编码名称
	private String name;
	/*关系属性*/
	//下级行政区划编码对象
	private List<DistCode> children = new ArrayList<DistCode>();
	//拥有单位
	private List<Dept> depts = new ArrayList<Dept>();
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DistCode> getChildren() {
		return children;
	}
	public void setChildren(List<DistCode> children) {
		this.children = children;
	}
	public List<Dept> getDepts() {
		return depts;
	}
	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}
	@Override
	public String toString() {
		return "DistCode [code=" + code + ", parent=" + parent + ", name="
				+ name + ", children=" + children + ", depts=" + depts + "]";
	}
}
