package com.wiley.covidtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.covidtracker.model.MedicalInstitute;

public interface MedicalInstituteRepository extends JpaRepository<MedicalInstitute, Long> {

}
