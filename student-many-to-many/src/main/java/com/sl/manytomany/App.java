package com.sl.manytomany;

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
		
		/*
		 * select pp.professorId, f.name, pp.projectId, p.project_name from prof_projects as pp 
		 * inner join professor as f on pp.professorId = f.id 
		 * inner join projects as p on pp.projectId = p.id;
		 */
		
		logger.info("Salvando professores e seus projetos");
		
		entityManager.close();
		factory.close();
		
	}
}

