package com.example.doctor.service;

import com.example.doctor.entity.DoctorEntity;

public interface DoctorService {
	
	public DoctorEntity docDataSave(DoctorEntity doctorEntity);
	public DoctorEntity findById(int docId);
	DoctorEntity updateDoc(DoctorEntity doctorEntity, int docId);
	public int deleteDoc(int docId);

}
