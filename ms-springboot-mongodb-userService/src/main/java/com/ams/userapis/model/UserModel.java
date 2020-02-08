package com.ams.userapis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class UserModel {

public static final String SEQUENCE_NAME = "user_sequence"; 
	
	@Id
	private Long id;
	
	private String name;
	
	private String gender;
	
	private String dob;
	
	private String country;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", country="
				+ country + "]";
	}
	
}