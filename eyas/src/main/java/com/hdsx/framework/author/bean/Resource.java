package com.hdsx.framework.author.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 资源
 * @author xiongxt
 * @2015年3月15日
 */
public class Resource implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//唯一标识
	private String id;
	//资源名称
	private String name;
	//信息描述
	private String info;
	//对应路径
	private String uri;
	//上级标识
	private String parent;
	/*关系属性*/
	//下级资源
	private List<Resource> children = new ArrayList<Resource>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public List<Resource> getChildren() {
		return children;
	}
	public void setChildren(List<Resource> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", info=" + info
				+ ", uri=" + uri + ", parent=" + parent + ", children="
				+ children + "]";
	}
	
}
