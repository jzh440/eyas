package com.hdsx.framework.author.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 图层
 * @author xiongxt
 * @2015年3月15日
 */
public class Layer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//唯一标识
	private String id;
	//图层名称
	private String layerName;
	//数据集
	private String dataSet;
	//下级图层
	private List<Layer> children = new ArrayList<Layer>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLayerName() {
		return layerName;
	}
	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}
	public String getDataSet() {
		return dataSet;
	}
	public void setDataSet(String dataSet) {
		this.dataSet = dataSet;
	}
	public List<Layer> getChildren() {
		return children;
	}
	public void setChildren(List<Layer> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Layer [id=" + id + ", layerName=" + layerName + ", dataSet="
				+ dataSet + ", children=" + children + "]";
	}
	
}
