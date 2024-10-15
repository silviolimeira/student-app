package com.sl.admin.model;

import com.sl.admin.type.SectionTypeBean;

import jakarta.validation.constraints.NotEmpty;

public class Section {

	Long id;
	SectionTypeBean type;

	@NotEmpty
	String title;

	String hint;

	String description;

	Integer width;
	Integer height;

	public Section() {
	}

	public Section(Long id, SectionTypeBean type, @NotEmpty String title, String hint, String description, Integer width,
			Integer height) {
		this.id = id;
		this.type = type;
		this.title = title;
		this.hint = hint;
		this.description = description;
		this.width = width;
		this.height = height;
	}

	public Section(SectionDTO dto) {
		this.id = dto.id;
		this.type = new SectionTypeBean().getByName(dto.getType());
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

	public SectionTypeBean getType() {
		return type;
	}

	public void setType(SectionTypeBean type) {
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
