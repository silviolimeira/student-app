package com.sl.api.admin.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SL_GROUP")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long groupId;

	Integer type;
	String title;
	String hint;
	String description;
	Integer width;
	Integer height;
	
	@ManyToOne
	@JoinColumn(name = "sectionId")
	private Section section;

	public Group() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Long getId() {
		return groupId;
	}

	public void setId(Long id) {
		this.groupId = id;
	}

	@Override
	public String toString() {
		return "Group [id=" + groupId + ", type=" + type + ", title=" + title + ", hint=" + hint + ", description="
				+ description + ", width=" + width + ", height=" + height + "]";
	}

}
