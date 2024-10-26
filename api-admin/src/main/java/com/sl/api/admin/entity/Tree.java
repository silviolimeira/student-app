package com.sl.api.admin.entity;

import java.util.ArrayList;
import java.util.List;

import com.sl.api.admin.model.TreeDTO;
import com.sl.api.admin.model.TreeTypeBean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SL_TREE")
public class Tree {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long treeId;

	Integer type;
	String title;
	String hint;
	String description;
	Integer width;
	Integer height;
	
	@OneToMany(mappedBy = "tree")
	List<Branch> brancs;

	public Tree() {
		this.brancs = new ArrayList<>();
	}
	
	public <T> Tree(T dto) {
		this.treeId = ((TreeDTO) dto).getId();
		this.type = new TreeTypeBean().getByName(((TreeDTO) dto).getType()).getId();
		this.title = ((TreeDTO) dto).getTitle();
		this.hint = ((TreeDTO) dto).getHint();
		this.description = ((TreeDTO) dto).getDescription();
		this.width = ((TreeDTO) dto).getWidth();
		this.height = ((TreeDTO) dto).getHeight();
	}
	public void addGroup(Branch branch) {
		this.brancs.add(branch);
	}
	
	public List<Branch> getGroups() {
		return brancs;
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
		return treeId;
	}

	public void setId(Long id) {
		this.treeId = id;
	}

	@Override
	public String toString() {
		return "Tree [treeId=" + treeId + ", type=" + type + ", title=" + title + ", hint=" + hint + ", description="
				+ description + ", width=" + width + ", height=" + height + "]";
	}

}
