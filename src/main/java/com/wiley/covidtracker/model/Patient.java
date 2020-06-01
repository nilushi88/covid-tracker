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
	private String address;
	
	@ManyToOne
	private District district;
	
	@ManyToOne
	private MedicalInstitute medicalInstitute;
	
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
	
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getNic() {
		return nic;
	}
	
	public void setNic(String nic) {
		this.nic = nic;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Column(name = "patient_status")
	public PatientStatus getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(PatientStatus patientStatus) {
		this.patientStatus = patientStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@Column(name="medical_institute")
	public MedicalInstitute getMedicalInstitute() {
		return medicalInstitute;
	}

	public void setMedicalInstitute(MedicalInstitute medicalInstitute) {
		this.medicalInstitute = medicalInstitute;
	}	
}
