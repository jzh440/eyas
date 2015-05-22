package com.hdsx.framework.registry.bean;

import java.io.Serializable;

public class RegistryCoordinate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int number;
	private String name;
	private String type;
	private String definition;
	private String organization;
	private String desciption;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	
}
