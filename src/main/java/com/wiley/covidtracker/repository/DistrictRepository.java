package com.wiley.covidtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.covidtracker.model.District;


public interface DistrictRepository extends JpaRepository<District, Long> {

}
