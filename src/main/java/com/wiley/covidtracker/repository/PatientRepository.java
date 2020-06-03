package com.wiley.covidtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.covidtracker.model.MedicalInstitute;
import com.wiley.covidtracker.model.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long> {

	public List<Patient> findByMedicalInstitute(MedicalInstitute medicalInstitute);
}
