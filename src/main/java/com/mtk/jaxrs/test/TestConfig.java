package com.mtk.jaxrs.test;

import com.mtk.jaxrs.model.User;
import com.mtk.jaxrs.repositories.UserRepositoryImpl;

public class TestConfig {

	public static void main(String[] args) {
		
		User u1 = new User(null, "Matheus Klabunde", "matheus@gmail.com");
		User u2 = new User(null, "João Paulo", "joao@gmail.com");
		User u3 = new User(null, "Lucas Souza", "lucas@gmail.com");
		User u4 = new User(null, "Julia Coelho", "julia@gmail.com");
		
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
		
		/*
		userRepository.delete(1L);
		userRepository.delete(2L);
		userRepository.delete(3L);
		userRepository.delete(4L);
		*/
	
		userRepositoryImpl.save(u1);
		userRepositoryImpl.save(u2);
		userRepositoryImpl.save(u3);
		userRepositoryImpl.save(u4);
		
		System.out.println("Users Successfully saved!");
		
		userRepositoryImpl.closeConnection();
	}
}
