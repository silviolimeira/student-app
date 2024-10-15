package com.sl.api.admin.model;

import com.sl.api.admin.entity.Tree;

import jakarta.validation.constraints.NotEmpty;

public class TreeDTO {

	Long id;
	String type;

	@NotEmpty
	String title;

	String hint;

	String description;

	Integer width;
	Integer height;

	public TreeDTO() {
	}

	public TreeDTO(Tree tree) {
		this.id = tree.getId();
		this.type = new TreeTypeBean().getById(tree.getType()).getName();
		this.title = tree.getTitle();
		this.hint = tree.getHint();
		this.description = tree.getDescription();
		this.width = tree.getWidth();
		this.height = tree.getHeight();
	}
	
	public TreeDTO(Long id, TreeTypeBean type, @NotEmpty String title, String hint, String description, Integer width,
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

	@Override
	public String toString() {
		return "SectionDTO [id=" + id + ", type=" + type + ", title=" + title + ", hint=" + hint + ", description="
				+ description + ", width=" + width + ", height=" + height + "]";
	}

}
