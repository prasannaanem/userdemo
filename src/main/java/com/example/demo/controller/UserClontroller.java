package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserClontroller {
	
	@Autowired
	private UserServiceImpl userRepo;
	

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		
		return new ResponseEntity<>(userRepo.addUser(user),HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getall(){
		List<User> listUser= userRepo.getAllUser();
		  return new ResponseEntity<List<User>>(listUser,HttpStatus.OK);
		
	}
	
	@GetMapping("getbyid/{id}")
	public ResponseEntity<User> getById(@PathVariable long id) {
		
		User userid= userRepo.getById(id);
		return new ResponseEntity<User>(userid,HttpStatus.OK);
	}
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
		
		String userdel =userRepo.deleteById(id);
		
		return new ResponseEntity<>("Success Fully Delated Your id  :"+id,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id , @RequestBody User user){
		
		User userupdate= userRepo.UpdateUser(id, user);
		return new ResponseEntity<User>(userupdate, HttpStatus.OK);
	}
}





