package com.alpha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.hospital.ResponseStructure;
import com.alpha.hospital.dto.PatientDto;
import com.alpha.hospital.entity.Doctor;
import com.alpha.hospital.entity.Patient;
import com.alpha.hospital.exception.InvalidDataException;
import com.alpha.hospital.service.HospitalService;

import jakarta.validation.Valid;

@RestController
public class HospitalController {
	
	@Autowired
	private HospitalService hs;
	
	@PostMapping("/saveDoctor")
	public ResponseStructure<Doctor> saveDoctor(@RequestBody @Valid Doctor d)
	{
		return hs.saveDoctor(d);
	}
	
	@PostMapping("/savePatient")
	public ResponseStructure<Patient> savePatient(@RequestBody @Valid PatientDto p)
	{
		System.err.println("THIS IS PATIENT SAVE" + p);
		return hs.savePatient(p);
	}
    @GetMapping("/findDoctor")
    public ResponseStructure<Doctor> findDoctor(@RequestParam int id) {
        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        return hs.findDoctor(id);
    }
    
	@PutMapping("/updateDoctor")
	public ResponseStructure<Doctor> updateDoctor(@RequestParam int id,@RequestParam String newname) throws InvalidDataException  {
		return hs.updateDoctor(id, newname);
	}
	
	@DeleteMapping("/deleteDoctor")
	public ResponseStructure<String> deleteDoctor(@RequestParam int id) {
		if (id <= 0) 
		{
	        throw new IllegalArgumentException();
	     }
	    return hs.deleteDoctor(id);
	}
	
	@PostMapping("/savePatient1")
	public ResponseStructure<Patient> savePatient1(@RequestBody @Valid PatientDto pdto)
	{
		return hs.savePatient1(pdto);
	}
}
