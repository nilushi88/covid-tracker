package com.wiley.covidtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.covidtracker.model.District;
import com.wiley.covidtracker.service.UtilityService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/")
@RestController
public class UtilityController {
	
	@Autowired
	private UtilityService utilityService;
	
	@GetMapping("/districts")
	public List<District> getAllDistricts() {
		return utilityService.getAllDistricts();
	}
}
