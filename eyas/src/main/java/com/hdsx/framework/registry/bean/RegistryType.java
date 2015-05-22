package com.hdsx.framework.registry.bean;

import java.io.Serializable;

public class RegistryType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int type;
	private String code;
	private String name;
	private String descibe;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescibe() {
		return descibe;
	}
	public void setDescibe(String descibe) {
		this.descibe = descibe;
	}
	
}
