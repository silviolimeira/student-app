package com.sl.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.sl.jpa");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Student s = new Student("Adam", 54);
		
		entityManager.persist(s);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
		
		
		
		
	}
	
}
