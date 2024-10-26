package com.sl.api.admin.entity;

import com.sl.api.admin.model.StatusDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SL_STATUS")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String name;
	String title;

	public Status() {
	}

	public Status(Long id, String name, String title) {
		this.id = id;
		this.name = name;
		this.title = title;
	}

	public <T> Status(T dto) {
		this.id = ((StatusDTO) dto).getId();
		this.name = ((StatusDTO) dto).getName();
		this.title = ((StatusDTO) dto).getTitle();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
