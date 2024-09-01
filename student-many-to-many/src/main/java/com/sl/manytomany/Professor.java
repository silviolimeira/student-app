package com.sl.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int profesorId;

	@Column(name = "name")
	private String professorName;

	@ManyToMany(mappedBy = "professors")
	private List<ResearchProject> projects;

	public Professor() {
		this.projects = new ArrayList<>();
	}

	public Professor(String professorName) {
		this();
		this.professorName = professorName;
	}

	public void assignProjectToProfessor(ResearchProject project) {
		this.projects.add(project);
	}

	public int getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(int profesorId) {
		this.profesorId = profesorId;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public List<ResearchProject> getProjects() {
		return projects;
	}

	public void setProjects(List<ResearchProject> projects) {
		this.projects = projects;
	}

}
