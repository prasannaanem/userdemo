package com.example.demo.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getById(long id) {
		
		return userRepository.findById(id).get();
	}

	@Override
	public String deleteById(long id) {
		 userRepository.deleteById(id);
		 return "Success fully Delated My Id  :"+id;
	}

	@Override
	public User UpdateUser(long id,User user) {

		User exuser =userRepository.findById(id).get();
		exuser.setName(user.getName());
		exuser.setEmail(user.getEmail());
		exuser.setCity(user.getCity());
		exuser.setAddress(user.getAddress());
		
		return userRepository.save(exuser);
	}

	
	

}
