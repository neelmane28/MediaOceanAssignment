package com.assignment.service;

import java.util.List;

import com.assignment.model.User;


public interface UserService {
	
	User findById(int id);

	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(int id);

	List<User> findAllUsers();
}