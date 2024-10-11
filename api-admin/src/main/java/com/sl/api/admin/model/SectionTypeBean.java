package com.sl.api.admin.model;

import java.util.ArrayList;
import java.util.List;

import com.sl.api.admin.type.SectionType;

public class SectionTypeBean {

	List<SectionTypeBean> list;

	int id;
	String name;

	public SectionTypeBean() {
		list = new ArrayList<>();
		
		for (SectionType t : SectionType.values()) { 
		    list.add(new SectionTypeBean(t.getValue(), t.getName())); 
		}
	}
	
	public SectionTypeBean(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public List<SectionTypeBean> names() {
		return list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public SectionTypeBean getById(int id) {
		for (SectionTypeBean t : list) { 
		    if (t.getId() == id) return t; 
		}
		return null;
	}
	
	public SectionTypeBean getByName(String name) {
		for (SectionTypeBean t : list) { 
		    if (t.getName().equalsIgnoreCase(name)) return t; 
		}
		return null;
	}
	
	
	
}
