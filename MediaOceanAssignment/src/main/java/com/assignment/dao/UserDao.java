package com.assignment.dao;

import java.util.List;

import com.assignment.model.User;


public interface UserDao {

	User findById(int id);

	void save(User user);
	
	void deleteById(int id);
	
	List<User> findAllUsers();

}

