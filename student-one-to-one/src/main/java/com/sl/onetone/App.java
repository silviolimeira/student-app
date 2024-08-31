package com.sl.onetone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.onetoone.Address;
import com.sl.onetoone.Employee;

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
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.sl.onetoone");
		EntityManager entityManager = factory.createEntityManager();
	
		Address address = new Address();
		address.setAddressName("Wall Street");
		address.setZipCode(111);
		
		Employee employee = new Employee();
		employee.setEmployeeName("Joe Smith");
		employee.setAddress(address);
		
		address.setEmployee(employee);
		
		save(new Object[] {address, employee}, entityManager);
		
		logger.info("Salvando employee with your address");
		
		entityManager.close();
		factory.close();
		
	}

}
