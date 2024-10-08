package com.sl.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECTS")
public class ResearchProject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int projectId;

	@Column(name = "project_name")
	private String projectName;

	@ManyToMany
	@JoinTable(name = "PROF_PROJECTS", joinColumns = @JoinColumn(name = "projectId"), inverseJoinColumns = @JoinColumn(name = "professorId"))
	private List<Professor> professors;

	public ResearchProject() {
		this.professors = new ArrayList<>();
	}

	public ResearchProject(String projectName) {
		this();
		this.projectName = projectName;
	}

	public void assignProfessorToProject(Professor professor) {
		this.professors.add(professor);
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

}
