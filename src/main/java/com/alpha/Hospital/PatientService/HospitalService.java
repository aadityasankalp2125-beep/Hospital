package com.alpha.Hospital.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.Hospital.ResponseStructure;
import com.alpha.Hospital.PatientRepository.HospitalRepository;
import com.alpha.Hospital.entity.Doctor;
import com.alpha.Hospital.excepitions.DoctorNotFoundExpection;

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

	public ResponseStructure<Doctor> finddoctor(int id) {
		Doctor doc = hr.findById(id).orElseThrow(() -> new DoctorNotFoundExpection());
		ResponseStructure<Doctor> rs = new ResponseStructure<>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Doctor with id " +id+ " found successfully");
		rs.setData(doc);
		
	    return rs;
	}

	public ResponseStructure<Doctor> deletedoctor(int id) {
	    Doctor existing = hr.findById(id).orElseThrow(() -> new DoctorNotFoundExpection());
	    hr.deleteById(id);
	    ResponseStructure<Doctor> rs = new ResponseStructure<>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Doctor deleted successfully");
		rs.setData(existing);

		return rs;
	}

	public void updateDoctor(int id, String newname) {
		Doctor d = hr.findById(id).get();
		if(d!=null)
		{
			d.setName(newname);
		}
		hr.save(d);
	}
	
	

}
