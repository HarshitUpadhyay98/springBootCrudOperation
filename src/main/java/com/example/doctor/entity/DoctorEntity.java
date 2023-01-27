package com.example.doctor.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DoctorEntity {
	@Id
	private int docId;
	private String docName;

	public DoctorEntity() {
		super();
	}
	public DoctorEntity(int docId, String docName) {
		super();
		this.docId = docId;
		this.docName = docName;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}
	@Override
	public String toString() {
		return "DoctorEntity [docId=" + docId + ", docName=" + docName + "]";
	}
	

}
