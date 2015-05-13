package com.hdsx.framework.author.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 单位
 * @author xiongxt
 * @2015年3月13日
 */

public class Dept implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//唯一标识
	private String id;
	//单位名称
	private String deptName;
	//单位地址
	private String address;
	//负责人
	private String leader;
	//电话
	private String tel;
	//行政区划编码
	private String distCode;
	//邮编
	private String postCode;
	//传真
	private String fax;
	//上级标识
	private String pid;
	//区划名称
	private String qhmc;
	/*关系属性*/
	//行政区划编码对象
	private DistCode xzqhbm;
	//下级单位
	private List<Dept> children = new ArrayList<Dept>();
	//拥有图层
	private List<Layer> layers = new ArrayList<Layer>();
	//拥有用户
	private List<User> users = new ArrayList<User>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDistCode() {
		return distCode;
	}
	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}
	public String getQhmc() {
		return qhmc;
	}
	public void setQhmc(String qhmc) {
		this.qhmc = qhmc;
	}
	public DistCode getXzqhbm() {
		return xzqhbm;
	}
	public void setXzqhbm(DistCode xzqhbm) {
		this.xzqhbm = xzqhbm;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public List<Dept> getChildren() {
		return children;
	}
	public void setChildren(List<Dept> children) {
		this.children = children;
	}
	public List<Layer> getLayers() {
		return layers;
	}
	public void setLayers(List<Layer> layers) {
		this.layers = layers;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptName=" + deptName + ", address="
				+ address + ", leader=" + leader + ", tel=" + tel
				+ ", distCode=" + distCode + ", postCode=" + postCode
				+ ", fax=" + fax + ", pid=" + pid + ", qhmc=" + qhmc
				+ ", xzqhbm=" + xzqhbm + ", children=" + children + ", layers="
				+ layers + ", users=" + users + "]";
	}
}
