package com.sl.api.admin.model;

import com.sl.api.admin.entity.Status;

public class StatusDTO {

	Long id;
	String name;
	String title;

	public StatusDTO() {
	}

	public StatusDTO(Status status) {
		this.id = status.getId();
		this.name = status.getName();
		this.title = status.getTitle();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
}
