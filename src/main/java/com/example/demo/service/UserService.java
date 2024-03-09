package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
	
	public User addUser(User user);
	
	public List<User> getAllUser();
	
	public User getById(long id);

	public String deleteById(long id);
	
	public User UpdateUser(long id ,User user);
}
