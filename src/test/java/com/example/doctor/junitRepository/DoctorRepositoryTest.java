package com.example.doctor.junitRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.example.doctor.entity.DoctorEntity;
import com.example.doctor.repository.DoctorRepository;

@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class DoctorRepositoryTest {

	@Autowired
	DoctorRepository doctorRepository;

	@Rollback(value=false)
	@Test
	public void saveDoctor() {
		DoctorEntity doctorC=new DoctorEntity(11,"DSA");
		doctorRepository.save(doctorC);
		Assertions.assertThat(doctorC.getDocId());
	}
	@Test
	public void getDoctor() {
		DoctorEntity doctorG=doctorRepository.findById(11);
		Assertions.assertThat(doctorG.getDocId());
	}
	@Test
	public void update() {
		DoctorEntity doctorU=doctorRepository.findById(11);
		doctorU.setDocId(240);
		DoctorEntity updateData=doctorRepository.save(doctorU);
		assertThat(updateData.getDocId());
	}
	@Test
	public void deleteDoc() {
		DoctorEntity doctorD=doctorRepository.findById(11);
		doctorRepository.delete(doctorD);
		Optional<DoctorEntity> optionalDoctorEntity = Optional.ofNullable(doctorRepository.findById(11));
		 Assertions.assertThat(optionalDoctorEntity).isEmpty();
		}
}
