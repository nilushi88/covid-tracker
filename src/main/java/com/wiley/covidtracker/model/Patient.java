package com.wiley.covidtracker.model;

import java.util.Date;

import javax.persistence.*;

import com.wiley.covidtracker.model.StatusHistory.PatientStatus;

@Entity
@Table(name = "patient")
public class Patient {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	private String firstName;
	private String lastName; 
	private String nic;
	private Date dob;
	private Gender gender;
	private PatientStatus patientStatus;
	
	public enum Gender{
		MALE, FEMALE	
	}
	
	public Patient() {
		super();
	}
	
	public Patient(String firstName, String lastName, String nic, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.dob = dob;
		this.setPatientStatus(PatientStatus.SUSPECTED);
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "nic")
	public String getNic() {
		return nic;
	}
	
	public void setNic(String nic) {
		this.nic = nic;
	}
	
	@Column(name = "dob", nullable = false)
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Column(name = "gender", nullable = false)
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Column(name = "patient_status", nullable = false)
	public PatientStatus getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(PatientStatus patientStatus) {
		this.patientStatus = patientStatus;
	}	
}
