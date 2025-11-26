package com.alpha.Hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.Hospital.ResponseStructure;
import com.alpha.Hospital.PatientService.HospitalService;
import com.alpha.Hospital.entity.Doctor;

@RestController
public class HospitalController {
@Autowired
private HospitalService hs;
@PostMapping("/savedoctor")
public ResponseStructure<Doctor> saveDoctor(@RequestBody Doctor d){
	return hs.savedoctor(d);
} 
}
