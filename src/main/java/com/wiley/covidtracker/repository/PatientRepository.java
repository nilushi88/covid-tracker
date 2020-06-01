package com.wiley.covidtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.covidtracker.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
