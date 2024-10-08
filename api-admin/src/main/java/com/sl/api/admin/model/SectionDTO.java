package com.sl.api.admin.model;

import com.sl.api.admin.entity.Section;
import com.sl.api.admin.type.SectionType;

import jakarta.validation.constraints.NotEmpty;

public class SectionDTO {

	Long id;
	SectionType type;

	@NotEmpty
	String title;

	String hint;

	String description;

	Integer width;
	Integer height;

	public SectionDTO() {
	}

	public SectionDTO(Section section) {
		this.id = section.getId();
		this.type = SectionType.valueOf(section.getType());
		this.hint = section.getHint();
		this.description = section.getDescription();
		this.width = section.getWidth();
		this.height = section.getHeight();
	}
	
	public SectionDTO(Long id, SectionType type, @NotEmpty String title, String hint, String description, Integer width,
			Integer height) {
		super();
		this.id = id;
		this.type = SectionType.valueOf(type.getValue());
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

	public SectionType getType() {
		return this.type;
	}

	public void setType(SectionType type) {
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
