package com.example.doctor.junitService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.doctor.entity.DoctorEntity;
import com.example.doctor.impl.DoctorServiceImpl;
import com.example.doctor.repository.DoctorRepository;
import com.example.doctor.service.DoctorService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DoctorServiceTest {
	public DoctorEntity getDoctor() {
		DoctorEntity doctor = new DoctorEntity();
		doctor.setDocId(1);
		doctor.setDocName("abx");
		return doctor;
		} 
	@Mock
	private DoctorRepository doctorRepository;
	
	@Mock
	private DoctorService docService;
	
	@InjectMocks
	private DoctorServiceImpl doctorService;
	
	DoctorEntity doctor = new DoctorEntity();
	
	@BeforeEach
	void setup()
	{doctor=getDoctor();}
	
	@Test
	public void getDoctorById() {
		when(doctorService.findById(Mockito.anyInt())).thenReturn(doctor);
		assertNotNull(doctor);
	}
	@Test
	public void updateDoctor() {
		when(doctorService.updateDoc(doctor, Mockito.anyInt())).thenReturn(doctor);
		assertNotNull(doctor);
	}
	@Test
	public void deleteDoctor() {
		int id = 2;
		doctorService.deleteDoc(id);
		verify(doctorRepository,times(1)).deleteById(id);
		assertNotNull(doctor.getDocId());
	}
	@Test
	public void saveDoctor() {
		when(doctorRepository.save(doctor)).thenReturn(doctor);
		assertEquals(doctor, doctorService.docDataSave(doctor));
	}
}


