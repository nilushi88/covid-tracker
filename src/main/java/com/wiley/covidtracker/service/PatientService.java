package com.wiley.covidtracker.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.covidtracker.exception.ResourceNotFound;
import com.wiley.covidtracker.model.Patient;
import com.wiley.covidtracker.model.StatusHistory;
import com.wiley.covidtracker.repository.PatientRepository;
import com.wiley.covidtracker.repository.StatusHistoryRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository; 
	
	@Autowired
	private StatusHistoryRepository statusHistoryRepository;
	
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();	
	}
	
	public Patient getPatient(long id) throws ResourceNotFound {
		return patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Patient not found for the id : " + id));
	}
	
	public Patient addPatient(Patient patient) {
		Patient createdPatient = patientRepository.save(patient);
		updateHistory(createdPatient);
		return createdPatient;
	}
	
	public Patient updatePatient(Patient updatedPatient, long id) throws ResourceNotFound {
		Patient patient = getPatient(id);

		patient.setFirstName(updatedPatient.getFirstName());
		patient.setLastName(updatedPatient.getLastName());
		patient.setDob(updatedPatient.getDob());
		patient.setNic(updatedPatient.getNic());
		
		if(updatedPatient.getPatientStatus() != patient.getPatientStatus()) {
			updateHistory(patient);
		}
		
		patient.setPatientStatus(updatedPatient.getPatientStatus());

		return patientRepository.save(patient);
	}
	
	private void updateHistory(Patient patient) {	
		StatusHistory	statusHistory	=	new StatusHistory(new Date(), patient.getPatientStatus(), patient);
		statusHistoryRepository.save(statusHistory);
	}
}