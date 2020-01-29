package com.etna.gpe.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

import com.etna.gpe.dto.OrganizationDto;

@Entity
@Table(name ="organization")
public class Organization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "organization_id") 
	int organizationId;
	
	@NotBlank
	@Column(name="organization_name", nullable = false)
	String organizationName;
	
	@NotBlank
	@Column(name="organization_chief_name", nullable = false)
	String organizationChiefName;
	
	@NotBlank
	@Column(name="organization_password", nullable = false)
	String organizationPassword;
	
	@NotBlank
	@Column(name="organization_location", nullable = false)
	String organizationLocation;
	
	@Column(name="organization_logo")
	String organizationLogo;
	
	@NotBlank
	@Column(name="organization_description", nullable = false)
	String organizationDescription;
	
	@Column(name="organization_web_site")
	String organizationWebSite;
	
	@NotBlank
	@Column(name="organization_phone_number", nullable = false)
	String organizationPhoneNumber;
	
	@NotBlank
	@Column(name="organization_email", nullable = false)
	String organizationEmail;
	
	@Column(name="organization_creation_date")
	String organizationCreationDate;
	
	@Column(name="organization_create_date")
	String organizationCreateDate;
	
	@Column(name="organization_update_date")
	String organizationUpdateDate;
	
	@Column(name="organization_delete_date")
	String organizationDeleteDate;
	
	@Column(name="organization_is_deleted")
	boolean organizationIsDeleted = false;
	
	
	

	protected Organization() {
		//empty constructor
	}
	
	public Organization(@NonNull OrganizationDto organizationDto, boolean isNew) {
		if(isNew)
			this.setOrganizationId(organizationDto.getOrganizationId());
		this.setOrganizationIsDeleted(organizationDto.isOrganizationIsDeleted());
		this.setOrganizationLocation(organizationDto.getOrganizationLocation());
		this.setOrganizationLogo(organizationDto.getOrganizationLogo());
		this.setOrganizationName(organizationDto.getOrganizationName());
		this.setOrganizationPassword(organizationDto.getOrganizationPassword());
		this.setOrganizationPhoneNumber(organizationDto.getOrganizationPhoneNumber());
		this.setOrganizationUpdateDate(organizationDto.getOrganizationUpdateDate());
		this.setOrganizationWebSite(organizationDto.getOrganizationWebSite());
		this.setOrganizationChiefName(organizationDto.getOrganizationChiefName());
		this.setOrganizationCreateDate(organizationDto.getOrganizationCreateDate());
		this.setOrganizationCreationDate(organizationDto.getOrganizationCreationDate());
		this.setOrganizationDeleteDate(organizationDto.getOrganizationDeleteDate());
		this.setOrganizationDescription(organizationDto.getOrganizationDescription());
		this.setOrganizationEmail(organizationDto.getOrganizationEmail());
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
