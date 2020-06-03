package com.wiley.covidtracker.model.response;

import java.util.List;

import com.wiley.covidtracker.model.MedicalInstitute;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String username;
	private List<String> roles;
	
	private MedicalInstitute medicalInstitute;

	public JwtResponse(String accessToken, String username, List<String> roles, MedicalInstitute medicalInstitute) {
		this.token = accessToken;
		this.username = username;
		this.roles = roles;
		this.medicalInstitute = medicalInstitute;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public MedicalInstitute getMedicalInstitute() {
		return medicalInstitute;
	}

	public void setMedicalInstitute(MedicalInstitute medicalInstitute) {
		this.medicalInstitute = medicalInstitute;
	}
}
