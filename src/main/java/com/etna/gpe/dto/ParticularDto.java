package com.etna.gpe.dto;

import java.util.Date;

import org.springframework.lang.NonNull;

import com.etna.gpe.model.Particular;

public class ParticularDto {
	int particularId;
	 private String particularName;
	 private String particularFirstName;
	 private String particularPassword;
	 private String particularPhonenumber;
	 private String particularEmail;
	 private Date particularCreateDate;
	 private Date particularUpdateDate;
	 private boolean particularIsDeleted;
	 private String particularLocation;
	 private String photo;
	 private String category;
	 
	 public ParticularDto() {
		// TODO Auto-generated constructor stub
	}
	 
	 public ParticularDto(@NonNull Particular particular) {
		 this.setParticularId(particular.getParticularId());
		 this.setParticularCreateDate(particular.getParticularCreateDate());
		 this.setParticularEmail(particular.getParticularEmail());
		 this.setParticularFirstName(particular.getParticularFirstName());
		 this.setParticularIsDeleted(particular.isParticularIsDeleted());
		 this.setParticularName(particular.getParticularName());
		 this.setParticularPassword(particular.getParticularPassword());
		 this.setParticularPhonenumber(particular.getParticularPhonenumber());
		 this.setParticularUpdateDate(particular.getParticularUpdateDate());
		 this.setParticularLocation(particular.getParticularLocation());
		 this.setCategory(particular.getCategory());
		 this.setPhoto(particular.getPhoto());
		}

	public int getParticularId() {
		return particularId;
	}

	public void setParticularId(int particularId) {
		this.particularId = particularId;
	}

	public String getParticularName() {
		return particularName;
	}

	public void setParticularName(String particularName) {
		this.particularName = particularName;
	}

	public String getParticularFirstName() {
		return particularFirstName;
	}

	public void setParticularFirstName(String particularFirstName) {
		this.particularFirstName = particularFirstName;
	}

	public String getParticularPassword() {
		return particularPassword;
	}

	public void setParticularPassword(String particularPassword) {
		this.particularPassword = particularPassword;
	}

	public String getParticularPhonenumber() {
		return particularPhonenumber;
	}

	public void setParticularPhonenumber(String particularPhonenumber) {
		this.particularPhonenumber = particularPhonenumber;
	}

	public String getParticularEmail() {
		return particularEmail;
	}

	public void setParticularEmail(String particularEmail) {
		this.particularEmail = particularEmail;
	}

	public Date getParticularCreateDate() {
		return particularCreateDate;
	}

	public void setParticularCreateDate(Date particularCreateDate) {
		this.particularCreateDate = particularCreateDate;
	}

	public Date getParticularUpdateDate() {
		return particularUpdateDate;
	}

	public void setParticularUpdateDate(Date particularUpdateDate) {
		this.particularUpdateDate = particularUpdateDate;
	}

	public boolean isParticularIsDeleted() {
		return particularIsDeleted;
	}

	public void setParticularIsDeleted(boolean particularIsDeleted) {
		this.particularIsDeleted = particularIsDeleted;
	}

	public String getParticularLocation() {
		return particularLocation;
	}

	public void setParticularLocation(String particularLocation) {
		this.particularLocation = particularLocation;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	} 
}
