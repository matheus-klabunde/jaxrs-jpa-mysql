package com.mtk.jaxrs.repositories;

public class UserRepositoryFactory {

	public static UserRepository createUserRepository() {
		return new UserRepositoryImpl();
	}
}
