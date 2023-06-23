package com.mtk.jaxrs.repositories;

import java.util.List;

import com.mtk.jaxrs.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

public class UserRepositoryImpl implements UserRepository{

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public UserRepositoryImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@Override
	public List<User> findAll(){
		return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
	}
	
	@Override
	public User findById(Long id) {
		return entityManager.find(User.class, id);
	}

	@Transactional
	@Override
	public void save(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}
	
	@Transactional
	@Override
	public void update(User user) {
		entityManager.getTransaction().begin();
		entityManager.merge(user);
		entityManager.getTransaction().commit();
	}
	
	@Transactional
	@Override
	public void delete(Long id) {
		entityManager.getTransaction().begin();
		User obj = findById(id);
		entityManager.remove(obj);
		entityManager.getTransaction().commit();
	}
	
	public void closeConnection() {
		entityManager.close();
		entityManagerFactory.close();
	}
}

