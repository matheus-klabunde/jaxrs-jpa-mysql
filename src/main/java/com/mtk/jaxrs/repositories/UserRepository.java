package com.mtk.jaxrs.repositories;

import java.util.List;

import com.mtk.jaxrs.model.User;

public interface UserRepository {

	List<User> findAll();
	User findById(Long id);
	void save(User user);
	void update(User user);
	void delete(Long id);
}
