package com.alpha.Hospital.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.Hospital.ResponseStructure;
import com.alpha.Hospital.PatientRepository.HospitalRepository;
import com.alpha.Hospital.entity.Doctor;

@Service
public class HospitalService {
	@Autowired
	private HospitalRepository hr;

	public ResponseStructure<Doctor> savedoctor(Doctor d) {
	
		 Doctor saved = hr.save(d);

	        ResponseStructure<Doctor> rs = new ResponseStructure<>();
	        rs.setStatuscode(HttpStatus.CREATED.value());    
	        rs.setMessage("Doctor saved successfully");
	        rs.setData(saved);

	        return rs;
	}

}
