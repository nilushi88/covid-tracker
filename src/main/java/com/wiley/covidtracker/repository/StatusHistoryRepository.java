package com.wiley.covidtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.covidtracker.model.Patient;
import com.wiley.covidtracker.model.StatusHistory;

public interface StatusHistoryRepository extends JpaRepository<StatusHistory, Long> {

}
