package com.wiley.covidtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.covidtracker.exception.ResourceNotFound;
import com.wiley.covidtracker.model.MedicalInstitute;
import com.wiley.covidtracker.repository.MedicalInstituteRepository;

@Service
public class MedicalInstituteService {

	@Autowired
	private MedicalInstituteRepository miRepository; 
	
	public List<MedicalInstitute> getAllMedicalInstitutes() {
		return miRepository.findAll();	
	}
	
	public MedicalInstitute getMedicalInstitute(long id) throws ResourceNotFound {
		return miRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Patient not found for the id : " + id));
	}
	
	public MedicalInstitute addMedicalInstitute(MedicalInstitute medicalInstitute) {
		return miRepository.save(medicalInstitute);
	}
	
	public MedicalInstitute updateMedicalInstitute(MedicalInstitute updatedMI, long id) throws ResourceNotFound {
		MedicalInstitute medicalInstitute = getMedicalInstitute(id);

		medicalInstitute.setName(updatedMI.getName());
		medicalInstitute.setAddress(updatedMI.getAddress());
		medicalInstitute.setDistrict(updatedMI.getDistrict());
		medicalInstitute.setType(updatedMI.getType());
		
		return miRepository.save(medicalInstitute);
	}
}
