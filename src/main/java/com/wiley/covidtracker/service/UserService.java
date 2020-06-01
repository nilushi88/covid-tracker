package com.wiley.covidtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.covidtracker.exception.ResourceNotFound;
import com.wiley.covidtracker.model.MedicalStaff;
import com.wiley.covidtracker.model.User;
import com.wiley.covidtracker.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();	
	}
	
	public User getUser(long id) throws ResourceNotFound {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("User not found for the id : " + id));
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(User updatedUser, long id) throws ResourceNotFound {
		User user = getUser(id);

		user.setUserName(updatedUser.getUserName());
		user.setPassword(updatedUser.getPassword());
		user.setRoles(updatedUser.getRoles());
		user.setActive(updatedUser.isActive());
		
		if(user instanceof MedicalStaff && updatedUser instanceof MedicalStaff)
		{
			((MedicalStaff) user).setMedicalInstitute(((MedicalStaff) updatedUser).getMedicalInstitute());
		}

		return userRepository.save(user);
	}
}
