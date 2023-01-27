package com.example.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor.entity.DoctorEntity;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
	DoctorEntity findById(int i);
}
