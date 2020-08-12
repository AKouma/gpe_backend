package com.etna.gpe.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import com.etna.gpe.dto.OrganizationDto;

@Entity
@Table(name ="organization")
public class Organization extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "organization_id") 
	int organizationId;
	
	@Column(name="organization_matricule", nullable = false)
	private String organizationMatricule;
	
	@NotBlank
	@Column(name="organization_name", nullable = false)
	private String organizationName;
	
	@NotBlank
	@Column(name="organization_chief_name", nullable = false)
	private String organizationChiefName;
	
	@NotBlank
	@Column(name="organization_chief_firstname", nullable = false)
	private String organizationChiefFirstname;
	
	@NotBlank
	@Column(name="organization_password", nullable = false)
	private String organizationPassword;
	
	@NotBlank
	@Column(name="organization_location", nullable = false)
	private String organizationLocation;
	
	@Column(name="organization_logo")
	private String organizationLogo;
	
	@NotBlank
	@Column(name="organization_description", nullable = false)
	private String organizationDescription;
	
	@Column(name="organization_web_site")
	private String organizationWebSite;
	
	@NotBlank
	@Column(name="organization_phone_number", nullable = false)
	private String organizationPhoneNumber;
	
	@NotBlank
	@Column(name="organization_email", nullable = false)
	private String organizationEmail;
	
	@Column(name="organization_creation_date")
	private String organizationCreationDate;
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="organization_create_date")
	private Date organizationCreateDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="organization_update_date")
	private Date organizationUpdateDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="organization_delete_date")
	private Date organizationDeleteDate;
	
	@Column(name="organization_is_deleted")
	private boolean organizationIsDeleted = false;
	
	
	

	protected Organization() {
		//empty constructor
	}
	
	public Organization(@NonNull OrganizationDto organizationDto, boolean isNew) {
		if(!isNew)
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
		this.setOrganizationDescription(organizationDto.getOrganizationDescription());
		this.setOrganizationEmail(organizationDto.getOrganizationEmail());
		this.setOrganizationMatricule(organizationDto.getOrganizationMatricule());
		this.setOrganizationChiefFirstname(organizationDto.getOrganizationChiefFirstname());
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationMatricule() {
		return organizationMatricule;
	}

	public void setOrganizationMatricule(String organizationMatricule) {
		this.organizationMatricule = organizationMatricule;
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

	public Date getOrganizationDeleteDate() {
		return organizationDeleteDate;
	}

	public void setOrganizationDeleteDate(Date organizationDeleteDate) {
		this.organizationDeleteDate = organizationDeleteDate;
	}

	public boolean isOrganizationIsDeleted() {
		return organizationIsDeleted;
	}

	public void setOrganizationIsDeleted(boolean organizationIsDeleted) {
		this.organizationIsDeleted = organizationIsDeleted;
	}
	
}
