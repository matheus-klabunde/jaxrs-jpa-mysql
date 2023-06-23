package com.mtk.jaxrs.test;

import com.mtk.jaxrs.model.User;
import com.mtk.jaxrs.repositories.UserRepository;

public class TestConfig {

	public static void main(String[] args) {
		
		User u1 = new User(null, "Matheus Klabunde", "matheus@gmail.com");
		User u2 = new User(null, "João Paulo", "joao@gmail.com");
		User u3 = new User(null, "Lucas Souza", "lucas@gmail.com");
		User u4 = new User(null, "Julia Coelho", "julia@gmail.com");
		
		UserRepository userRepository = new UserRepository();
		
		/*
		userRepository.delete(1L);
		userRepository.delete(2L);
		userRepository.delete(3L);
		userRepository.delete(4L);
		*/
	
		userRepository.save(u1);
		userRepository.save(u2);
		userRepository.save(u3);
		userRepository.save(u4);
		
		System.out.println("Users Successfully saved!");
		
		userRepository.closeConnection();
	}
}
