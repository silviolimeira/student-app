package com.sl.api.admin.repository;

import org.springframework.stereotype.Repository;

import com.sl.api.admin.entity.Tree;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class TreeCustomRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Tree customFindMethod(Long id) {
		return (Tree) entityManager.createQuery("FROM Tree t WHERE t.id = :id")
				.setParameter("id", id)
				.getSingleResult();
	}
	
	
}
