package com.alpha.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.hospital.ResponseStructure;
import com.alpha.hospital.dto.PatientDto;
import com.alpha.hospital.entity.Doctor;
import com.alpha.hospital.entity.Patient;
import com.alpha.hospital.exception.DoctorFoundException;
import com.alpha.hospital.exception.DoctorNotFoundException;
import com.alpha.hospital.exception.InvalidDataException;
import com.alpha.hospital.repository.HospitalRepo;
import com.alpha.hospital.repository.PatientRepo;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepo hr;
	
	@Autowired
	private PatientRepo pr;
	
	public ResponseStructure<Doctor> saveDoctor(Doctor d) {
		
		if(hr.existsById(d.getId()))
		{
			throw new DoctorFoundException();
		}		
		ResponseStructure<Doctor> rs= new ResponseStructure<Doctor>();		
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setMessage("Doctor is saved" + d);
		rs.setData(d);
		hr.save(d);
		return rs;
	}
	
	public ResponseStructure<Patient> savePatient(Patient p) {
		
		if(pr.existsById(p.getId()))
		{
			throw new DoctorFoundException();
		}		
		ResponseStructure<Patient> rs= new ResponseStructure<Patient>();		
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setMessage("Patient is saved" + p);
		rs.setData(p);
		pr.save(p);
		return rs;
	}
	
	public ResponseStructure<Doctor> findDoctor(int id) {

        Doctor d = hr.findById(id).orElseThrow(() -> new DoctorNotFoundException());

        ResponseStructure<Doctor> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.FOUND.value());
        rs.setMessage("Doctor with ID " + id + " found");
        rs.setData(d);

        return rs;
    }
	
	public ResponseStructure<Doctor> updateDoctor(int id, String newname) throws InvalidDataException {
	    if (id <= 0) {
	        throw new IllegalArgumentException("ID cannot be zero or negative");
	    }
	    if (newname == null || newname.trim().isEmpty()) {
	        throw new InvalidDataException();
	    }
	    Doctor d = hr.findById(id).orElseThrow(() -> new DoctorNotFoundException());

	    d.setName(newname);  
	    hr.save(d);   
	    ResponseStructure<Doctor> rs = new ResponseStructure<>();
	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMessage("Doctor updated successfully");
	    rs.setData(d);
	    return rs;
	}
	
    public ResponseStructure<String> deleteDoctor(int id) {

        Doctor d = hr.findById(id).orElseThrow(() -> new DoctorNotFoundException());
        hr.delete(d);

        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.OK.value());
        rs.setMessage("Doctor deleted");
        rs.setData("Doctor with ID " + id + " removed");

        return rs;
    }

	public ResponseStructure<Patient> savePatient1(PatientDto pdto) {
		Patient p = new Patient();
		p.setName(pdto.getName());
		p.setAge(pdto.getAge());
		p.setDisease(pdto.getDisease());
		pr.save(p);
		ResponseStructure<Patient> rs = new ResponseStructure<Patient>();
		rs.setStatuscode(HttpStatus.ACCEPTED.value());
		rs.setMessage("Patient Added");
		rs.setData(p);
		return rs;
	}

	
}
