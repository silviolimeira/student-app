package com.sl.jpa;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

	private static final Logger logger = LogManager.getLogger(App.class);

	public static <T> void save(T entity, EntityManager em) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	
	public static <T> void save(T[] entity, EntityManager em) {
		em.getTransaction().begin();
		for (T t : entity) {
			em.persist(t);
		}
		em.getTransaction().commit();
	}
	
	public static <T> T find(int id, EntityManager em) {
		return (T) em.find(Person.class, id);
	}

	//JPQL
	public static <T> T findAll(EntityManager em) {
		// TODO 29.Java Persistence Query Language (JPQL) 4:36 / 8:35
		Query query = em.createQuery("SELECT p FROM Person p");
		return (T) query.getResultList(); 
	}
	
	//JPQL
	public static <T> T findWhereMinor(EntityManager em, int age) {
		// TODO 29.Java Persistence Query Language (JPQL) 4:36 / 8:35
		Query query = em.createQuery("SELECT p FROM Person p WHERE p.age < ?1 ORDER BY p.name DESC");
		query.setParameter(1, age);
		return (T) query.getResultList(); 
	}
	
	// Native Query
	public static <T> T findWhereMinorNative(EntityManager em, int age) {
		// TODO 29.Java Persistence Query Language (JPQL) 4:36 / 8:35
		Query query = em.createNativeQuery("SELECT * FROM PERSON_NAME P WHERE P.AGE < ?1 ORDER BY P.NAME ASC");
		query.setParameter(1, age);
		return (T) query.getResultList(); 
	}
	
	
	public static void remove(int id, EntityManager em) {
		em.getTransaction().begin();
		Object entity = find(id, em);
		em.remove(entity);
		em.getTransaction().commit();
	}
	
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.sl.jpa");
		EntityManager entityManager = factory.createEntityManager();
		
		Student student = new Student("Cesar", 10);
		save(student, entityManager);
		
		Person p1 = new Person("Joe", "joe@gmail.com", 10);
		Person p2 = new Person("Cesar", "cesar@gmail.com", 50);
		Person p3 = new Person("Silvio", "silvio@gmail.com", 50);
		save(new Person[] {p1, p2, p3}, entityManager);
		
		Person f = find(1, entityManager);
		logger.info("Find Person: {}", f);
		
		remove(2, entityManager);
		
		List<Person> peoples = findAll(entityManager);
		
		logger.info("Lista de Pessoas: \n{}", peoples.toString());
		int ct = 1;
		Iterator it = peoples.stream().iterator();
		while (it.hasNext()) {
			logger.info("{}) Pessoa - {}", ct++, it.next());
		}

		Person p4 = new Person("Maria", "maria@gmail.com", 25);
		Person p5 = new Person("Carolina", "carolina@gmail.com", 25);
		save(new Person[] {p4, p5}, entityManager);
		
		List<Person> menoresQue50 = findWhereMinor(entityManager, 50);
		ct = 1;
		it = menoresQue50.stream().iterator();
		while (it.hasNext()) {
			logger.info("{}) Pessoa < {} - {}", ct++, 50, it.next());
		}
		
		menoresQue50 = findWhereMinorNative(entityManager, 50);
		ct = 1;
		it = menoresQue50.stream().iterator();
		while (it.hasNext()) {
			logger.info("{}) Native Query - Pessoa < {} - {}", ct++, 50, it.next());
		}

		logger.info("======================================================");
		Query query = entityManager.createNamedQuery("person.getAll");
		List<Person> pp = query.getResultList(); 
		ct = 1;
		it = pp.stream().iterator();
		while (it.hasNext()) {
			logger.info("{}) Named Query - Pessoa - {}", ct++, it.next());
		}
		logger.info("======================================================");
		
		entityManager.close();
		factory.close();
		
	}
	
}
