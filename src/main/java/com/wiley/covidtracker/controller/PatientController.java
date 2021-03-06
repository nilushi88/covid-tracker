package com.wiley.covidtracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.wiley.covidtracker.exception.ResourceNotFound;
import com.wiley.covidtracker.model.Patient;
import com.wiley.covidtracker.service.PatientService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/")
@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@GetMapping("/patients")
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}
	
	@GetMapping("/mi/{id}/patients")
	public List<Patient> getAllMedicalInstitutePatients(@Valid @PathVariable long id) throws ResourceNotFound{
		return patientService.getAllMedicalInstitutePatients(id);
	}
	
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable long id) throws ResourceNotFound {
		return ResponseEntity.ok(patientService.getPatient(id));
	}
	
	@PostMapping("/patients")
	public Patient addPatient(@Valid @RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}
	
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updatePatient(@Validated @RequestBody Patient patient, @PathVariable long id) throws ResourceNotFound {
		return ResponseEntity.ok(patientService.updatePatient(patient, id));
	}
}
