package com.example.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctor.entity.DoctorEntity;
import com.example.doctor.service.DoctorService;

@RestController
public class DoctorController {
	
	@Autowired
	private	DoctorService doctorService;
	

	
	@PostMapping("/saveDoc")
	public DoctorEntity saveDoctor(@RequestBody DoctorEntity doctor) {
		return doctorService.docDataSave(doctor);
	}	
	@GetMapping("/docId/{docId}")
	public DoctorEntity getDoctor(@PathVariable int docId) {
		return doctorService.findById(docId);
	}
	@PutMapping("/updateDoc")
	public DoctorEntity update(@RequestBody DoctorEntity doctor) {
		return doctorService.updateDoc(doctor,doctor.getDocId());
	}
	@DeleteMapping("/deleteDoc/{docId}")
	public void delete(@PathVariable int docId) {
		 doctorService.deleteDoc(docId);
	}
	
	
}
