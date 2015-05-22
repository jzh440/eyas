package com.hdsx.framework.registry.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RegistryTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private String alias;
	
	private boolean hasM;
	
	private boolean hasZ;
	
	private int coordinate;
	
	private byte[] symbol;
	
	private int featureType;
	
	private String owner;
	
	private String source;
	
	private Date updateTime;
	
	private int sort;

	private String frequency;
	
	private int classify;
	
	private List<RegistryColumn> columns;
	
	public RegistryTable(){}
	
	
	public RegistryTable(String id, String name, String alias, boolean hasM,
			boolean hasZ, byte[] symbol, int featureType, String source,
			Date updateTime, String owner,String frequency,int classify,int sort,List<RegistryColumn> columns) {
		super();
		this.id = id;
		this.name = name;
		this.alias = alias;
		this.hasM = hasM;
		this.hasZ = hasZ;
		this.symbol = symbol;
		this.featureType = featureType;
		this.source = source;
		this.updateTime = updateTime;
		this.owner=owner;
		this.frequency=frequency;
		this.classify=classify;
		this.sort=sort;
		this.columns = columns;
	}

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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public boolean isHasM() {
		return hasM;
	}

	public void setHasM(boolean hasM) {
		this.hasM = hasM;
	}

	public boolean isHasZ() {
		return hasZ;
	}

	public void setHasZ(boolean hasZ) {
		this.hasZ = hasZ;
	}


	public int getCoordinate() {
		return coordinate;
	}


	public void setCoordinate(int coordinate) {
		this.coordinate = coordinate;
	}


	public byte[] getSymbol() {
		return symbol;
	}

	public void setSymbol(byte[] symbol) {
		this.symbol = symbol;
	}


	public int getFeatureType() {
		return featureType;
	}

	public void setFeatureType(int featureType) {
		this.featureType = featureType;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<RegistryColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<RegistryColumn> columns) {
		this.columns = columns;
	}

	public String getFrequency() {
		return frequency;
	}


	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}


	public int getClassify() {
		return classify;
	}


	public void setClassify(int classify) {
		this.classify = classify;
	}


	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
}
