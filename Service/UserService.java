package com.crud.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Model.User;
import com.crud.Repository.UserRepo;

@Service
public class UserService {

 

	@Autowired
	UserRepo userRepo;

    
	
	//get user
	public List<User> getuser()
	{
		return userRepo.findAll();	
	}
	
	
	//getbyid
	public User getbyid(long id)
	{
		 User data = userRepo.findById(id).get();
		return data;
	}
	
	//add
	public User adduser(User user)
	{
		return  userRepo.save(user);
		
				
	}
	
	//update
	public User  updateuser(long id , User data) throws Exception
	{
		 User data2 = userRepo.findById(id).orElseThrow(() -> new Exception("User with ID " + id + " not found"));
		
	
		data2.setUserid(id);
	data2.setUsername(data.getUsername());
	data2.setAge(data.getAge());
	
	
	
	userRepo.save(data2);		
	
	return data2;
		
		
	}
	
	
	//delete
	public User deleteuser(long id) throws Exception
	{
		User data = userRepo.findById(id).orElseThrow(() -> new Exception("id not present"));
		userRepo.deleteById(id);		
		return data;
	}
	
	
	
	
	
	
	
}
