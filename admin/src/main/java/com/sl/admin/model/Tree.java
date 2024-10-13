package com.sl.admin.model;

import com.sl.admin.type.TreeTypeBean;

import jakarta.validation.constraints.NotEmpty;

public class Tree implements EntityDomain {

	Long id;
	TreeTypeBean type;

	@NotEmpty
	String title;

	String hint;

	String description;

	Integer width;
	Integer height;
	
	@Override
	public String[] getColumns() {
		return new String[]{"id", "type", "hint", "description", "width", "height"};
	}

	public Tree() {
	}

	public Tree(Long id, TreeTypeBean type, @NotEmpty String title, String hint, String description, Integer width,
			Integer height) {
		this.id = id;
		this.type = type;
		this.title = title;
		this.hint = hint;
		this.description = description;
		this.width = width;
		this.height = height;
	}

	public Tree(TreeDTO dto) {
		this.id = dto.id;
		this.type = new TreeTypeBean().getByName(dto.getType());
		this.title = dto.title;
		this.hint = dto.hint;
		this.description = dto.description;
		this.width = dto.width;
		this.height = dto.height;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TreeTypeBean getType() {
		return type;
	}

	public void setType(TreeTypeBean type) {
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
