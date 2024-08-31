package com.sl.inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	
	private static final Logger logger = LogManager.getLogger(App.class);
	
	public static <T> void save(T entity, EntityManager em) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}	
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.sl.inheritance");
		EntityManager entityManager = factory.createEntityManager();

		logger.info("Single Inheritance JPA");

		Vehicle bus = new Bus("Name of Bus", 200);
		Car car = new Car("Name of Car", 150);
		
		save(car, entityManager);
		save(bus, entityManager);
		
		Person person = new Person();
		person.setName("Kevin");
		person.setAge(23);
		person.setDrivingLicence("XHB175");
		
		save(person, entityManager);
		
		entityManager.close();
		factory.close();

	}

}
