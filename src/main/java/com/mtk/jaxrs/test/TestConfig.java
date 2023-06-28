package com.mtk.jaxrs.test;

import com.mtk.jaxrs.model.User;
import com.mtk.jaxrs.repositories.UserRepository;
import com.mtk.jaxrs.repositories.UserRepositoryFactory;

public class TestConfig {

	public static void main(String[] args) {
		
		User u1 = new User(null, "Matheus Klabunde", "matheus@gmail.com");
		User u2 = new User(null, "João Paulo", "joao@gmail.com");
		User u3 = new User(null, "Lucas Souza", "lucas@gmail.com");
		User u4 = new User(null, "Julia Coelho", "julia@gmail.com");
		
		UserRepository repository = UserRepositoryFactory.createUserRepository();
		
		/*
		repository.delete(1L);
		repository.delete(2L);
		repository.delete(3L);
		repository.delete(4L);
		*/
	
		repository.save(u1);
		repository.save(u2);
		repository.save(u3);
		repository.save(u4);
		
		System.out.println("Users Successfully saved!");
	}
}
