package com.sl.api.admin.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import com.sl.api.admin.model.TreeDTO;
import com.sl.api.admin.model.TreeTypeBean;
import com.sl.api.admin.type.TreeType;

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
	Set<Branch> branchs;

	public Tree() {
		this.branchs = new HashSet<>();
	}
	
	public Tree(TreeDTO dto) {
		this.treeId = dto.getId();
		this.type = new TreeTypeBean().getByName(dto.getType()).getId();
		this.title = dto.getTitle();
		this.hint = dto.getHint();
		this.description = dto.getDescription();
		this.width = dto.getWidth();
		this.height = dto.getHeight();
	}
	public void addBranch(Branch branch) {
		this.branchs.add(branch);
	}
	
	public Set<Branch> getBranchs() {
		return branchs;
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

}
