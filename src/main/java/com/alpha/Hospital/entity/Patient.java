package com.alpha.Hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {
	     @Id
         @GeneratedValue(strategy = GenerationType.AUTO)
	     //@Positive
	     //@Min(value = 200)
		 private int id;
	     //@Length(max=30,min=3)
		 private String name;
	     private int age;
	     //@Length(max=30,min=3)
		 private String disease;
	     private String bgroup;
	     private int bp;
	     private int sugarlevel;
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
		 public String getBgroup() {
			 return bgroup;
		 }
		 public void setBgroup(String bgroup) {
			 this.bgroup = bgroup;
		 }
		 public int getBp() {
			 return bp;
		 }
		 public void setBp(int bp) {
			 this.bp = bp;
		 }
		 public int getSugarlevel() {
			 return sugarlevel;
		 }
		 public void setSugarlevel(int sugarlevel) {
			 this.sugarlevel = sugarlevel;
		 }
		 public Patient(int id, String name, int age, String disease, String bgroup, int bp, int sugarlevel) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.disease = disease;
			this.bgroup = bgroup;
			this.bp = bp;
			this.sugarlevel = sugarlevel;
		 }
		 public Patient() {
			super();
 }
 @Override
 public String toString() {
 return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", disease=" + disease + ", bgroup=" + bgroup
					+ ", bp=" + bp + ", sugarlevel=" + sugarlevel + "]";
	 }

	

	
}
