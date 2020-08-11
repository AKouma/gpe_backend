package com.etna.gpe.dto;


import java.util.Date;

import org.springframework.lang.NonNull;

import com.etna.gpe.model.Organization;

public class OrganizationDto {
	int organizationId;
	private String organizationName;
	private String organizationChiefName;
	private String organizationChiefFirstname;
	private String organizationPassword;
	private String organizationLocation;
	private String organizationMatricule;
	private String organizationLogo;
	private String organizationDescription;
	private String organizationWebSite;
	private String organizationPhoneNumber;
	private String organizationEmail;
	private String organizationCreationDate;
	private Date organizationCreateDate;
	private Date organizationUpdateDate;
	private boolean organizationIsDeleted;
	
	public OrganizationDto() {
		//empty consteuctor
	}

	public OrganizationDto(@NonNull Organization organization) {
		this.setOrganizationChiefName(organization.getOrganizationChiefName());
		this.setOrganizationCreateDate(organization.getOrganizationCreateDate());
		this.setOrganizationCreationDate(organization.getOrganizationCreationDate());
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
		this.setOrganizationMatricule(organization.getOrganizationMatricule());
		this.setOrganizationChiefFirstname(organization.getOrganizationChiefFirstname());
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

	public String getOrganizationChiefFirstname() {
		return organizationChiefFirstname;
	}

	public void setOrganizationChiefFirstname(String organizationChiefFirstname) {
		this.organizationChiefFirstname = organizationChiefFirstname;
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

	public String getOrganizationMatricule() {
		return organizationMatricule;
	}

	public void setOrganizationMatricule(String organizationMatricule) {
		this.organizationMatricule = organizationMatricule;
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

	public Date getOrganizationCreateDate() {
		return organizationCreateDate;
	}

	public void setOrganizationCreateDate(Date organizationCreateDate) {
		this.organizationCreateDate = organizationCreateDate;
	}

	public Date getOrganizationUpdateDate() {
		return organizationUpdateDate;
	}

	public void setOrganizationUpdateDate(Date organizationUpdateDate) {
		this.organizationUpdateDate = organizationUpdateDate;
	}

	public boolean isOrganizationIsDeleted() {
		return organizationIsDeleted;
	}

	public void setOrganizationIsDeleted(boolean organizationIsDeleted) {
		this.organizationIsDeleted = organizationIsDeleted;
	}

}
