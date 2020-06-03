package com.wiley.covidtracker.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
@DiscriminatorValue("1")
public class MedicalStaff extends User {

	@ManyToOne
	private MedicalInstitute medicalInstitute;

	@Column(name="medical_institute_id")
	public MedicalInstitute getMedicalInstitute() {
		return medicalInstitute;
	}

	public void setMedicalInstitute(MedicalInstitute medicalInstitute) {
		this.medicalInstitute = medicalInstitute;
	}
}
