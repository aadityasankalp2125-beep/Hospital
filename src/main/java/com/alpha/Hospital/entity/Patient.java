package com.alpha.Hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Patient {
	@Id
	private int id;
	private String name;
	private String diseases;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiseases() {
		return diseases;
	}
	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", diseases=" + diseases + "]";
	}
	public Patient() {
		super();
	}
	public Patient(int id, String name, String diseases) {
		super();
		this.id = id;
		this.name = name;
		this.diseases = diseases;
	}

}
