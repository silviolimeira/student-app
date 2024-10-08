package com.sl.admin.model;

import com.sl.admin.type.SectionType;

import jakarta.validation.constraints.NotEmpty;

public class SectionDTO {

	Long id;
	//SectionType type;
	Integer type;

	@NotEmpty
	String title;

	String hint;

	String description;

	Integer width;
	Integer height;

	public SectionDTO() {
	}

	public SectionDTO(Long id, SectionType type, @NotEmpty String title, String hint, String description, Integer width,
			Integer height) {
		super();
		this.id = id;
		this.type = type.getValue();
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

	public Integer getType() {
		return this.type;
	}

	public void setType(SectionType type) {
		this.type = type.getValue();
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
