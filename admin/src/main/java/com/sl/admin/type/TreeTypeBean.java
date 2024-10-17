package com.sl.admin.type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeTypeBean {

	List<TreeTypeBean> list;

	int id;
	String name;
	String title;

	public TreeTypeBean() {
		list = new ArrayList<>();

		for (TreeType t : TreeType.values()) {
			list.add(new TreeTypeBean(t.getValue(), t.getName(), t.getTitle()));
		}
	}

	public TreeTypeBean getById(int id) {
		for (TreeTypeBean t : list) {
			if (t.getId() == id)
				return t;
		}
		return null;
	}

	public TreeTypeBean getByName(String name) {
		for (TreeTypeBean t : list) {
			if (t.getName().equalsIgnoreCase(name))
				return t;
		}
		return null;
	}
	
	public TreeTypeBean getByTitle(String title) {
		for (TreeTypeBean t : list) {
			if (t.getName().equalsIgnoreCase(title))
				return t;
		}
		return null;
	}	

	public TreeTypeBean(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public TreeTypeBean(int id, String name, String title) {
		this.id = id;
		this.name = name;
		this.title = title;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "TreeTypeBean [name=" + name + "]";
	}

}
