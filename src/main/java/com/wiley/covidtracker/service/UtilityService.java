package com.wiley.covidtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.covidtracker.model.District;
import com.wiley.covidtracker.repository.DistrictRepository;

@Service
public class UtilityService {
	
	@Autowired
	private DistrictRepository districtRepository;;
	
	public List<District> getAllDistricts() {
		return districtRepository.findAll();	
	}
}
