package com.hdsx.framework.author.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色
 * @author xiongxt
 * @2015年3月15日
 */
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//唯一标识
	private String id;
	//角色名称
	private String roleName;
	//角色描述
	private String describe;
	
	/*关系属性*/
	//角色资源
	private List<Resource> resources = new ArrayList<Resource>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", describe="
				+ describe + ", resources=" + resources + "]";
	}
	
}
