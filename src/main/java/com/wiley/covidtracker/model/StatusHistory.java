package com.wiley.covidtracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "status_history")
public class StatusHistory {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
	private Date date;
	private PatientStatus status;
	
	@ManyToOne
	private Patient patient;
	
	public enum PatientStatus{
		SUSPECTED, POSITIVE, NEGATIVE, RECOVERED, DEAD
	}

	public StatusHistory() {
		super();
	}

	public StatusHistory(Date date, PatientStatus status, Patient patient) {
		super();
		this.date = date;
		this.status = status;
		this.patient = patient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "date", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "patient_status", nullable = false)
	public PatientStatus getStatus() {
		return status;
	}

	public void setStatus(PatientStatus status) {
		this.status = status;
	}

	@Column(name = "patient_id", nullable = false)
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
