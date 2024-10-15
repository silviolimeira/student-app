package com.sl.admin.type;

import java.util.ArrayList;
import java.util.List;

public class TreeTypeBean {

	List<TreeTypeBean> list;

	int id;
	String name;

	public TreeTypeBean() {
		list = new ArrayList<>();
		
		for (TreeType t : TreeType.values()) { 
		    list.add(new TreeTypeBean(t.getValue(), t.getName())); 
		}
	}
	
	public TreeTypeBean getById(int id) {
		for (TreeTypeBean t : list) { 
		    if (t.getId() == id) return t; 
		}
		return null;
	}
	
	public TreeTypeBean getByName(String name) {
		for (TreeTypeBean t : list) { 
		    if (t.getName().equalsIgnoreCase(name)) return t; 
		}
		return null;
	}	
	
	public TreeTypeBean(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public List<TreeTypeBean> names() {
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

	@Override
	public String toString() {
		return "TreeTypeBean [name=" + name + "]";
	}
	
	
	
}
