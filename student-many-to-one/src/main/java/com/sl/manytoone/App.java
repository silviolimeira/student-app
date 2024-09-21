package com.sl.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

	private static final Logger logger = LogManager.getLogger(App.class);

	public static <T> void save(T[] entity, EntityManager em) {
		em.getTransaction().begin();
		for (T t : entity) {
			em.persist(t);
		}
		em.getTransaction().commit();
	}

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.sl.manytoone");
		EntityManager entityManager = factory.createEntityManager();

		//University university = new University("MIT");
		
//		Student s1 = new Student();
//		s1.setStudentName("Kevin");
//		s1.setUniversity(university);
//		
//		Student s2 = new Student();
//		s2.setStudentName("Joe");
//		s2.setUniversity(university);
		
//		save(new Object[] {university, s1, s2}, entityManager);
		
		entityManager.close();
		factory.close();

	}
}
