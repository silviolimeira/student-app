package com.sl.manytoone;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class University {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private int universityId;
//
//	@Column(name = "university_name")
//	private String universityName;
//
//	//@OneToMany(mappedBy = "university")
//	private List<Student> students;
//
//	private University() {
//		this.students = new ArrayList<>();
//	}
//
//	public University(String universityName) {
//		this();
//		this.universityName = universityName;
//	}
//
//	public void addStudent(Student s) {
//		this.students.add(s);
//	}
//
//	public int getUniversityId() {
//		return universityId;
//	}
//
//	public void setUniversityId(int universityId) {
//		this.universityId = universityId;
//	}
//
//	public String getUniversityName() {
//		return universityName;
//	}
//
//	public void setUniversityName(String universityName) {
//		this.universityName = universityName;
//	}
//
//	public List<Student> getStudents() {
//		return students;
//	}
//
//	public void setStudents(List<Student> students) {
//		this.students = students;
//	}

}
