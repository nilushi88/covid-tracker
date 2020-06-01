package com.wiley.covidtracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wiley.covidtracker.model.User;
import com.wiley.covidtracker.repository.UserRepository;
import com.wiley.covidtracker.security.SystemUserDetails;

@Service
public class SystemUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository UserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user	= UserRepository.findByUserName(userName);
		
		user.orElseThrow(() -> new UsernameNotFoundException("User not found: " + userName));
		
		return user.map(SystemUserDetails::new).get();
	}
}
