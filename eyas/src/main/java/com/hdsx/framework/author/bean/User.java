package com.hdsx.framework.author.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户
 * @author xiongxt
 * @2015年3月15日
 */
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//唯一标识
	private /*transient*/ String id;
	//登录名称
	private String userName;
	//真实姓名
	private String realName;
	//密码
	private String password;
	//单位标识
	private String deptId;
	//联系地址
	private String post;
	//手机
	private String mobile;
	//电子邮箱
	private String email;
	
	private String deptName;
	
	/*关系属性*/
	//所在单位
	private Dept dept;
	//拥有图层
	private List<Layer> layers = new ArrayList<Layer>();
	//拥有角色
	private List<Role> roles = new ArrayList<Role>();
	//拥有资源
	private List<Resource> resources = new ArrayList<Resource>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public List<Layer> getLayers() {
		return layers;
	}
	public void setLayers(List<Layer> layers) {
		this.layers = layers;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", realName="
				+ realName + ", password=" + password + ", deptId=" + deptId
				+ ", post=" + post + ", mobile=" + mobile + ", email=" + email
				+ ", deptName=" + deptName + ", dept=" + dept + ", layers="
				+ layers + ", roles=" + roles + ", resources=" + resources
				+ "]";
	}
}
