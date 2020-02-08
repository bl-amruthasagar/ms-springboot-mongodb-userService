package com.ams.userapis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ams.userapis.dao.UserRepo;
import com.ams.userapis.model.UserModel;
import com.ams.userapis.service.SequenceGeneratorUserService;





@RestController
@RequestMapping("/userapi")
public class UserController {

	@Autowired
	UserRepo repo;
	
	@Autowired
	SequenceGeneratorUserService seqGeneratorUserService;
	
	@PostMapping("/create")
	public UserModel create(@RequestBody UserModel newObject) {
		newObject.setId(seqGeneratorUserService.generateSequence(UserModel.SEQUENCE_NAME));
		return repo.save(newObject);
	}
	
	@GetMapping("/read")
	public List<UserModel> read(){
		return repo.findAll();
	}
	

	@GetMapping("/read/{id}")
	public UserModel read(@PathVariable Long id) {
		Optional<UserModel> userObj = repo.findById(id);
		if(userObj.isPresent()) {
			return userObj.get();
		}else {
			throw new RuntimeException("Employee not found with id "+id);
		}
	}
	
	@PutMapping("/update")
	public UserModel update(@RequestBody UserModel modifiedObject) {
		return repo.save(modifiedObject);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		Optional<UserModel> userObj = repo.findById(id);
		if(userObj.isPresent()) {
			repo.delete(userObj.get());
			return "Employee deleted with id "+id;
		}else {
			throw new RuntimeException("Employee not found for id "+id);
		}
	}
	
	
	
	@GetMapping("/verifyuser/{userId}")
	public boolean isUserAvailable(@PathVariable Long userId) {
		System.out.println(userId);
		Optional<UserModel> b= repo.findById(userId);
		 
		 if(b.isPresent())
		 return true;
		 else
			 return false; 
		
	}
	
}

