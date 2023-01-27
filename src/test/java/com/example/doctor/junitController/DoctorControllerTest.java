package com.example.doctor.junitController;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.doctor.controller.DoctorController;
import com.example.doctor.entity.DoctorEntity;
import com.example.doctor.service.DoctorService;
import com.fasterxml.jackson.databind.ObjectMapper;
public class DoctorControllerTest {
	
	@Mock
	DoctorService doctorService;
	
	@InjectMocks
	DoctorController doctorController;
	
	private  MockMvc mockMvc;
	
	ObjectMapper objectMapper =new ObjectMapper();
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(doctorController).build();
	}
	
	DoctorEntity doctorEntity = new DoctorEntity();
	
	@Test
	public void saveDoctor() throws Exception{
		
		doctorEntity.setDocId(1);
		doctorEntity.setDocName("Test");
		String jsonRequest = objectMapper.writeValueAsString(doctorEntity);
		when(doctorService.docDataSave(Mockito.any(DoctorEntity.class))).thenReturn(doctorEntity);
		MvcResult mvcResult = mockMvc.perform(post("/saveDoc").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
.andExpect(status().isOk()).andReturn();
				String exceptedOutput=mvcResult.getResponse().getContentAsString();
				DoctorEntity exceptedOutputUser=objectMapper.readValue(exceptedOutput, DoctorEntity.class);
				assertEquals(exceptedOutputUser.getDocId(),doctorEntity.getDocId());
	}
	
	@Test
	public void updateDoctor() throws Exception{
		doctorEntity.setDocId(11);
		doctorEntity.setDocName("Harshit");
		String jsonRequest = objectMapper.writeValueAsString(doctorEntity);
		when(doctorService.updateDoc(Mockito.any(DoctorEntity.class),Mockito.anyInt())).thenReturn(doctorEntity);
		MvcResult mvcResult = mockMvc.perform(put("/updateDoc").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String exceptedOutput=mvcResult.getResponse().getContentAsString();
		DoctorEntity exceptedOutputUser=objectMapper.readValue(exceptedOutput, DoctorEntity.class);
		assertEquals(exceptedOutputUser.getDocId(),doctorEntity.getDocId());
	}
	
	@Test
	public void deleteDoctor () throws Exception{
		String jsonRequest = String.valueOf(1);
		MvcResult mvcResult= mockMvc
				.perform(delete("/deleteDoc/1"))
					.andExpect(status().isOk()).andReturn();
		assertNotNull(doctorEntity.getDocId(), jsonRequest);
	   
	}
	 @Test
	public void getDoctor () throws Exception{
		 doctorEntity.setDocId(11);
		doctorEntity.setDocName("Harshit");
		String jsonRequest = objectMapper.writeValueAsString(doctorEntity);
		 when(doctorService.findById(1)).thenReturn(doctorEntity);
		 MvcResult mvcResult = mockMvc.perform(get("/docId/1").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk()).andReturn();
		 assertNotNull(doctorEntity.getDocId(), jsonRequest);
	 }

}
