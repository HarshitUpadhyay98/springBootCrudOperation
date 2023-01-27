package com.example.doctor.impl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.doctor.entity.DoctorEntity;
import com.example.doctor.repository.DoctorRepository;
import com.example.doctor.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService  {

	@Autowired
	private	DoctorRepository docRepository;
	
	@Override
	public DoctorEntity docDataSave(DoctorEntity doctorEntity) {
		
		return docRepository.save(doctorEntity);
	}
	
	@Override
	public DoctorEntity findById(int docId) {
		return docRepository.findById(docId);
	}
    
	@Override
    public DoctorEntity updateDoc(DoctorEntity doctorEntity, int docId) {
    	return docRepository.save(doctorEntity);
    }
    
	@Override
    public int deleteDoc(int docId) {
    	 docRepository.deleteById(docId);
    	 return docId;
    }


}

