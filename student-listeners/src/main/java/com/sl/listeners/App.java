package com.sl.listeners;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
		return (T) em.find(Article.class, id);
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
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.sl.listeners");
		EntityManager entityManager = factory.createEntityManager();
		

 		logger.info("======================================================");
		Article article = new Article("Albert Einstein - Relativity");
		save(article, entityManager);
		
		entityManager.close();
		factory.close();
		
	}

}
