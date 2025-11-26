package com.alpha.Hospital.PatientRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.Hospital.entity.Doctor;

	@Repository
	public interface HospitalRepository extends JpaRepository<Doctor, Integer>{
		

	}

