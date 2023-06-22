package com.mtk.jaxrs.test;

import com.mtk.jaxrs.model.User;
import com.mtk.jaxrs.repositories.UserRepository;

public class TestConfig {

	public static void main(String[] args) {
		User u1 = new User(1L, "Matheus Klabunde", "matheus@gmail.com");
		User u2 = new User(2L, "João Paulo", "joao@gmail.com");
		User u3 = new User(3L, "Lucas Souza", "lucas@gmail.com");
		
		UserRepository userRepository = new UserRepository();
		
		userRepository.save(u1);
		userRepository.save(u2);
		userRepository.save(u3);
		
		System.out.println("Users Successfully saved!");
		
		userRepository.closeConnection();
	}
}
