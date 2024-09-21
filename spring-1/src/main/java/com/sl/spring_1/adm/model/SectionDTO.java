package com.sl.spring_1.adm.model;

import com.sl.spring_1.adm.jpa.Section;

import jakarta.validation.constraints.NotEmpty;

public class SectionDTO {

	Long id;
	Integer type;

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
		this.type = section.getType();
		this.hint = section.getHint();
		this.description = section.getDescription();
		this.width = section.getWidth();
		this.height = section.getHeight();
	}
	
	public SectionDTO(Long id, Integer type, @NotEmpty String title, String hint, String description, Integer width,
			Integer height) {
		super();
		this.id = id;
		this.type = type;
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
		return type;
	}

	public void setType(Integer type) {
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
