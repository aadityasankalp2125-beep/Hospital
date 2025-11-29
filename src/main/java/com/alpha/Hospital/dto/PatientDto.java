package com.alpha.hospital.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Positive;

public class PatientDto {

	@Length(max = 30, min = 3)
	private String name;
	@Positive
	private int age;
	@Length(max = 30, min = 2)
	private String disease;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public PatientDto(String name, int age, String disease) {
		super();
		this.name = name;
		this.age = age;
		this.disease = disease;
	}

	public PatientDto() {
		super();
	}

	@Override
	public String toString() {
		return "PatientDto [name=" + name + ", age=" + age + ", disease=" + disease + "]";
	}
}
