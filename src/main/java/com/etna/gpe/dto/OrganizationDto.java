package com.etna.gpe.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

import com.etna.gpe.model.Organization;

public class OrganizationDto {
	int organizationId;
	String organizationName;
	String organizationChiefName;
	String organizationPassword;
	String organizationLocation;
	String organizationLogo;
	String organizationDescription;
	String organizationWebSite;
	String organizationPhoneNumber;
	String organizationEmail;
	String organizationCreationDate;
	String organizationCreateDate;
	String organizationUpdateDate;
	String organizationDeleteDate;
	boolean organizationIsDeleted;
	
	public OrganizationDto() {
		//empty consteuctor
	}

	public OrganizationDto(@NonNull Organization organization) {
		this.setOrganizationChiefName(organization.getOrganizationChiefName());
		this.setOrganizationCreateDate(organization.getOrganizationCreateDate());
		this.setOrganizationCreationDate(organization.getOrganizationCreationDate());
		this.setOrganizationDeleteDate(organization.getOrganizationDeleteDate());
		this.setOrganizationDescription(organization.getOrganizationDescription());
		this.setOrganizationEmail(organization.getOrganizationEmail());
		this.setOrganizationId(organization.getOrganizationId());
		this.setOrganizationIsDeleted(organization.isOrganizationIsDeleted());
		this.setOrganizationLocation(organization.getOrganizationLocation());
		this.setOrganizationLogo(organization.getOrganizationLogo());
		this.setOrganizationName(organization.getOrganizationName());
		this.setOrganizationPassword(organization.getOrganizationPassword());
		this.setOrganizationPhoneNumber(organization.getOrganizationPhoneNumber());
		this.setOrganizationUpdateDate(organization.getOrganizationUpdateDate());
		this.setOrganizationWebSite(organization.getOrganizationWebSite());
	}

	@Override
	public String toString() {
		return "OrganizationDto [organizationId=" + organizationId + ", organizationName=" + organizationName
				+ ", organizationChiefName=" + organizationChiefName + ", organizationPassword=" + organizationPassword
				+ ", organizationLocation=" + organizationLocation + ", organizationLogo=" + organizationLogo
				+ ", organizationDescription=" + organizationDescription + ", organizationWebSite="
				+ organizationWebSite + ", organizationPhoneNumber=" + organizationPhoneNumber + ", organizationEmail="
				+ organizationEmail + ", organizationCreationDate=" + organizationCreationDate
				+ ", organizationCreateDate=" + organizationCreateDate + ", organizationUpdateDate="
				+ organizationUpdateDate + ", organizationDeleteDate=" + organizationDeleteDate
				+ ", organizationIsDeleted=" + organizationIsDeleted + "]";
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationChiefName() {
		return organizationChiefName;
	}

	public void setOrganizationChiefName(String organizationChiefName) {
		this.organizationChiefName = organizationChiefName;
	}

	public String getOrganizationPassword() {
		return organizationPassword;
	}

	public void setOrganizationPassword(String organizationPassword) {
		this.organizationPassword = organizationPassword;
	}

	public String getOrganizationLocation() {
		return organizationLocation;
	}

	public void setOrganizationLocation(String organizationLocation) {
		this.organizationLocation = organizationLocation;
	}

	public String getOrganizationLogo() {
		return organizationLogo;
	}

	public void setOrganizationLogo(String organizationLogo) {
		this.organizationLogo = organizationLogo;
	}

	public String getOrganizationDescription() {
		return organizationDescription;
	}

	public void setOrganizationDescription(String organizationDescription) {
		this.organizationDescription = organizationDescription;
	}

	public String getOrganizationWebSite() {
		return organizationWebSite;
	}

	public void setOrganizationWebSite(String organizationWebSite) {
		this.organizationWebSite = organizationWebSite;
	}

	public String getOrganizationPhoneNumber() {
		return organizationPhoneNumber;
	}

	public void setOrganizationPhoneNumber(String organizationPhoneNumber) {
		this.organizationPhoneNumber = organizationPhoneNumber;
	}

	public String getOrganizationEmail() {
		return organizationEmail;
	}

	public void setOrganizationEmail(String organizationEmail) {
		this.organizationEmail = organizationEmail;
	}

	public String getOrganizationCreationDate() {
		return organizationCreationDate;
	}

	public void setOrganizationCreationDate(String organizationCreationDate) {
		this.organizationCreationDate = organizationCreationDate;
	}

	public String getOrganizationCreateDate() {
		return organizationCreateDate;
	}

	public void setOrganizationCreateDate(String organizationCreateDate) {
		this.organizationCreateDate = organizationCreateDate;
	}

	public String getOrganizationUpdateDate() {
		return organizationUpdateDate;
	}

	public void setOrganizationUpdateDate(String organizationUpdateDate) {
		this.organizationUpdateDate = organizationUpdateDate;
	}

	public String getOrganizationDeleteDate() {
		return organizationDeleteDate;
	}

	public void setOrganizationDeleteDate(String organizationDeleteDate) {
		this.organizationDeleteDate = organizationDeleteDate;
	}

	public boolean isOrganizationIsDeleted() {
		return organizationIsDeleted;
	}

	public void setOrganizationIsDeleted(boolean organizationIsDeleted) {
		this.organizationIsDeleted = organizationIsDeleted;
	}
	
}
