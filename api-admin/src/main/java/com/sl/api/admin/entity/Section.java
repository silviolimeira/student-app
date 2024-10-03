package com.sl.api.admin.entity;

import java.util.ArrayList;
import java.util.List;

import com.sl.api.admin.model.SectionDTO;
import com.sl.api.admin.type.SectionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SL_SECTION")
public class Section {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long sectionId;

	Integer type;
	String title;
	String hint;
	String description;
	Integer width;
	Integer height;
	
	@OneToMany(mappedBy = "section")
	List<Group> groups;

	public Section() {
		this.groups = new ArrayList<>();
	}
	
	public Section(SectionDTO dto) {
		this();
		this.sectionId = dto.getId();
		this.type = dto.getType().getValue();
		this.title = dto.getTitle();
		this.hint = dto.getHint();
		this.description = dto.getDescription();
		this.width = dto.getWidth();
		this.height = dto.getHeight();
	}
	public void addGroup(Group group) {
		this.groups.add(group);
	}
	
	public List<Group> getGroups() {
		return groups;
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
		return sectionId;
	}

	public void setId(Long id) {
		this.sectionId = id;
	}

	@Override
	public String toString() {
		return "Section [sectionId=" + sectionId + ", type=" + type + ", title=" + title + ", hint=" + hint + ", description="
				+ description + ", width=" + width + ", height=" + height + "]";
	}

}
