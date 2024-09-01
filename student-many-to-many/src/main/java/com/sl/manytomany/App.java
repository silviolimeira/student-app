package com.sl.manytomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

	public static <T> T find(int id, EntityManager em) {
		return (T) em.find(Professor.class, id);
	}
	
	public static void remove(int id, EntityManager em) {
		em.getTransaction().begin();
		Object entity = find(id, em);
		em.remove(entity);
		em.getTransaction().commit();
	}
	
	// Native Query
	public static <T> T findAllProfessorProjects(EntityManager em) {
		// TODO 29.Java Persistence Query Language (JPQL) 4:36 / 8:35
		Query query = em.createNativeQuery(
				"select pp.professorId, f.name, pp.projectId, p.project_name from prof_projects as pp "
				+ " inner join professor as f on pp.professorId = f.id "
				+ "	inner join projects as p on pp.projectId = p.id;"
		);
		return (T) query.getResultList(); 
	}

	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.sl.manytomany");
		EntityManager entityManager = factory.createEntityManager();
	
		Professor f1 = new Professor("Stephen Hawking");
		Professor f2 = new Professor("Albert Einstein");
		
		ResearchProject p1 = new ResearchProject("Black Hole Project");
		ResearchProject p2 = new ResearchProject("Quantum Field Theory Project");
		ResearchProject p3 = new ResearchProject("Thermodyname Fluctuations Project");
		
		f1.assignProjectToProfessor(p1);
		f1.assignProjectToProfessor(p2);
		f2.assignProjectToProfessor(p3);
		f2.assignProjectToProfessor(p1);
		
		p1.assignProfessorToProject(f1);
		p1.assignProfessorToProject(f2);
		p2.assignProfessorToProject(f1);
		p3.assignProfessorToProject(f2);
		
		save(new Object[] {f1, f2, p1, p2, p3}, entityManager);
		
		List<Object> result = findAllProfessorProjects(entityManager);
		logger.info("Professor projects =====> {}", result);
		
		remove(f1.getProfesorId(), entityManager);
		
		result = findAllProfessorProjects(entityManager);
		logger.info("Professor projects removed professor 1 =====> {}", result);

		/*
		 select pp.professorId, f.name, pp.projectId, p.project_name from prof_projects as pp 
		 inner join professor as f on pp.professorId = f.id 
		 inner join projects as p on pp.projectId = p.id;
		 */
		
		logger.info("Salvando professores e seus projetos");
		
		entityManager.close();
		factory.close();
		
	}
}

