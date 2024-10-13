package com.sl.admin.model;

import com.sl.api.admin.type.TreeType;

import jakarta.validation.constraints.NotEmpty;

public class TreeDTO {

	//@JsonProperty("id")
	Long id;
	//@JsonProperty("type")
	String type;

	//@JsonProperty("title")
	@NotEmpty
	String title;

	//@JsonProperty("hint")
	String hint;

	//@JsonProperty("description")
	String description;

	//@JsonProperty("width")
	Integer width;
	//@JsonProperty("height")
	Integer height;

	public TreeDTO(Tree tree) {
		this.id = tree.getId();
		this.type = tree.getType().getName();
		this.hint = tree.getHint();
		this.description =  tree.getDescription();
		this.width = tree.getWidth();
		this.height = tree.getHeight();
	}
	
	public TreeDTO(Long id, TreeType type, @NotEmpty String title, String hint, String description, Integer width,
			Integer height) {
		this.id = id;
		this.type = type.getName();
		this.title = title;
		this.hint = hint;
		this.description = description;
		this.width = width;
		this.height = height;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
