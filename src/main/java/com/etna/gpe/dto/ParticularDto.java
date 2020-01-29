package com.etna.gpe.dto;

import org.springframework.lang.NonNull;

import com.etna.gpe.model.Particular;

public class ParticularDto {
	int particularId;
	 String particularName;
	 String particularFirstName;
	 String particularPassword;
	 String particularPhonenumber;
	 String particularEmail;
	 String particularCreateDate;
	 String particularUpdateDate;
	 String particularDeleteDate;
	 boolean particularIsDeleted;
	 
	 public ParticularDto() {
		// TODO Auto-generated constructor stub
	}
	 
	 public ParticularDto(@NonNull Particular particular) {
		 this.setParticularId(particular.getParticularId());
		 this.setParticularCreateDate(particular.getParticularCreateDate());
		 this.setParticularDeleteDate(particular.getParticularDeleteDate());
		 this.setParticularEmail(particular.getParticularEmail());
		 this.setParticularFirstName(particular.getParticularFirstName());
		 this.setParticularIsDeleted(particular.isParticularIsDeleted());
		 this.setParticularName(particular.getParticularName());
		 this.setParticularPassword(particular.getParticularPassword());
		 this.setParticularPhonenumber(particular.getParticularPhonenumber());
		 this.setParticularUpdateDate(particular.getParticularUpdateDate());
		}

	@Override
	public String toString() {
		return "ParticularDto [particularId=" + particularId + ", particularName=" + particularName
				+ ", particularFirstName=" + particularFirstName + ", particularPassword=" + particularPassword
				+ ", particularPhonenumber=" + particularPhonenumber + ", particularEmail=" + particularEmail
				+ ", particularCreateDate=" + particularCreateDate + ", particularUpdateDate=" + particularUpdateDate
				+ ", particularDeleteDate=" + particularDeleteDate + ", particularIsDeleted=" + particularIsDeleted
				+ "]";
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

	public String getParticularCreateDate() {
		return particularCreateDate;
	}

	public void setParticularCreateDate(String particularCreateDate) {
		this.particularCreateDate = particularCreateDate;
	}

	public String getParticularUpdateDate() {
		return particularUpdateDate;
	}

	public void setParticularUpdateDate(String particularUpdateDate) {
		this.particularUpdateDate = particularUpdateDate;
	}

	public String getParticularDeleteDate() {
		return particularDeleteDate;
	}

	public void setParticularDeleteDate(String particularDeleteDate) {
		this.particularDeleteDate = particularDeleteDate;
	}

	public boolean isParticularIsDeleted() {
		return particularIsDeleted;
	}

	public void setParticularIsDeleted(boolean particularIsDeleted) {
		this.particularIsDeleted = particularIsDeleted;
	}
}
