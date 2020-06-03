package com.wiley.covidtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.wiley.covidtracker.exception.ResourceNotFound;
import com.wiley.covidtracker.model.MedicalInstitute;
import com.wiley.covidtracker.model.Patient;
import com.wiley.covidtracker.service.MedicalInstituteService;
import com.wiley.covidtracker.service.PatientService;

@RestController
@RequestMapping("/api")
public class MedicalInstituteController {

	@Autowired
	private MedicalInstituteService miService;
	
	@GetMapping("/medicalInstitutes")
	public List<MedicalInstitute> getAllMedicalInstitutes() {
		return miService.getAllMedicalInstitutes();
	}
	
	@GetMapping("/medicalInstitutes/{id}")
	public ResponseEntity<MedicalInstitute> getPatient(@PathVariable long id) throws ResourceNotFound {
		return ResponseEntity.ok(miService.getMedicalInstitute(id));
	}
	
	@PostMapping("/medicalInstitutes")
	public MedicalInstitute addPatient(@Validated @RequestBody MedicalInstitute medicalInstitute) {
		return miService.addMedicalInstitute(medicalInstitute);
	}
	
	@PutMapping("/medicalInstitutes/{id}")
	public ResponseEntity<MedicalInstitute> updatePatient(@Validated @RequestBody MedicalInstitute medicalInstitute, @PathVariable long id) throws ResourceNotFound {
		return ResponseEntity.ok(miService.updateMedicalInstitute(medicalInstitute, id));
	}
}
