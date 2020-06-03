package com.wiley.covidtracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "medical_institute")
public class MedicalInstitute {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	private String address;
	
	@ManyToOne
	private District district;
	
	private MedicalInstituteType type;
	
	public enum MedicalInstituteType{
		STATE_HOSPITAL, PRIVATE_HOSPITAL, CLINIC	
	}
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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

	public MedicalInstituteType getType() {
		return type;
	}

	public void setType(MedicalInstituteType type) {
		this.type = type;
	}
}
